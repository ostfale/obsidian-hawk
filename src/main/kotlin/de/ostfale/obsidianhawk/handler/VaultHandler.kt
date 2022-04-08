package de.ostfale.obsidianhawk.handler

import com.google.gson.*
import de.ostfale.obsidianhawk.model.HotKey
import de.ostfale.obsidianhawk.model.HotkeyContext
import java.lang.reflect.Type

class VaultHandler {

    fun readJsonHotkey(jsonString: String): HotkeyContext {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(HotkeyContext::class.java, HotKeyContextDeserializer())
        val gson = gsonBuilder.create()

        val result = gson.fromJson(jsonString, HotkeyContext::class.java)
        if (result != null) {
            return result
        }
        throw java.lang.IllegalArgumentException("Could not parse JSON Hotkey format")
    }
}

class HotKeyContextDeserializer : JsonDeserializer<HotkeyContext> {

    override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): HotkeyContext {
        val contextKey = json.asJsonObject.keySet().first()
        val (commandContext, commandName) = contextKey.split(":")

        val jsonVal = json.asJsonObject.entrySet().first().value as JsonArray
        val hotkeyMapped = Gson().fromJson(jsonVal[0], HotKey::class.java)

        return HotkeyContext(
            context = commandContext,
            commandName = commandName,
            hotkey = listOf(hotkeyMapped)
        )
    }
}

private const val VAULT_PATH = "c:/work/junk/MyObsidian_test/"
private const val CONFIG_DIR = ".obsidian"
private const val HOTKEY_FILE_NAME = "hotkeys.json"