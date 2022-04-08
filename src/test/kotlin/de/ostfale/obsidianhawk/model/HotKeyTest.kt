package de.ostfale.obsidianhawk.model

import de.ostfale.obsidianhawk.handler.VaultHandler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unittest")
@DisplayName("Test Hotkey Display function")
internal class HotKeyTest {

    private val sut: VaultHandler = VaultHandler()

    @Test
    @DisplayName("Read a single JSON key")
    fun `Test reading a hotkey in JSON format `() {
        // given

        // when
        val result: HotkeyContext = sut.readJsonHotkey(SINGLE_JSON_HOTKEY)
        // then
        assertNotNull(result)
        assertEquals("app", result.context)
        assertEquals("open-vault", result.commandName)
        assertEquals("Alt", result.hotkey.first().modifiers[0])
        assertEquals("Shift", result.hotkey.first().modifiers[1])
        assertEquals("P", result.hotkey.first().key)
        assertEquals("Alt + Shift P", result.hotkey.first().getKeySequence())
    }
}

private const val SINGLE_JSON_HOTKEY = """
{
    "app:open-vault": [
    {
      "modifiers": [
        "Alt",
        "Shift"
      ],
      "key": "P"
    }
  ]
}
"""

private const val MULTIPLE_JSON_HOTKEY = """
{
"workspaces-plus:Default": [
    {
      "modifiers": [
        "Alt",
        "Mod",
        "Shift"
      ],
      "key": "D"
    }
  ],
  "zk-prefixer": [
    {
      "modifiers": [
        "Alt",
        "Mod"
      ],
      "key": "Z"
    }
  ],
  "app:toggle-left-sidebar": [
    {
      "modifiers": [
        "Alt",
        "Shift"
      ],
      "key": "ArrowLeft"
    }
  ],
}
"""