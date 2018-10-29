package emoticons

enum class Emotes(val emote:String, val filename: String) {
    FELIZ(":-)", "src/emotes/feliz.txt"),
    TRISTE(":-(", "src/emotes/triste.txt"),
    SONRISA(":-D", "src/emotes/sonrisa.txt"),
    LENGUA(":-P", "src/emotes/lengua.txt"),
    GUINO(";-)", "src/emotes/guino.txt"),
    INDECISO(":-S", "src/emotes/indeciso.txt"),
    RISA("XD", "src/emotes/risa.txt")
}