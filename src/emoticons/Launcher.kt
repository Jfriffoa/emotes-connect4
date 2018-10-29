package emoticons

import java.io.FileNotFoundException

fun main(args:Array<String>) {
    val p = Parser()
    //print("Ingresar el nombre del archivo: ")
    //var filename = readLine()!!.toString()
    val filename = "emoticons/input/input"

    try {
        for (i in 0..69){
            val temp = filename + i + ".txt"
            p.read(temp)
            val emote = p.parse()
            println((i+1).toString() + " | El emoticon leido es: $emote")
        }
    } catch (e: FileNotFoundException) {
        println("Archivo no encontrado, cerrando programa. . . ")
    } catch (e: IllegalArgumentException) {
        println("Archivo no valido, cerrando programa. . .")
    }
}