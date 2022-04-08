package de.ostfale.obsidianhawk.model

data class HotkeyContext(
    val context: String,
    val commandName: String,
    val hotkey: List<HotKey> = listOf(),
) {
    override fun toString(): String {
        return "\nHotkeyContext(\n\tcontext='$context', \n\tcommandName='$commandName') " +
                "\n\tKey-Sequence: ${hotkey.forEach { it.getKeySequence() }}"
    }
}

data class HotKey(
    val modifiers: MutableList<String> = mutableListOf(),
    val key: String
) {
    fun getKeySequence(): String {
        return modifiers.joinToString(" + ") + " $key"
    }

    override fun toString(): String {
        return "HotKey(modifiers=$modifiers, key='$key')"
    }
}
