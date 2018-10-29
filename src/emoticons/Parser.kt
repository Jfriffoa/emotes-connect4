package emoticons

import java.io.File
import java.io.FileNotFoundException

class Parser {
    val set:HashMap<String, Array<Array<Boolean>>>
    var matrix:Array<Array<Boolean>>

    @Throws(FileNotFoundException::class)
    constructor(){
        this.matrix = Array(70) { Array(100){ false }}
        this.set = HashMap()

        //Initialize
        for (em in Emotes.values()){
            read(em.filename)
            this.set.put(em.emote, copy(this.matrix))
        }
    }

    @Throws(FileNotFoundException::class)
    fun read(filename:String){
        val file = File(filename)
        var i = 0
        file.forEachLine {
            var j = 0
            it.forEach {
                if (it.equals('0')) {
                    matrix[i][j] = false
                    j++
                } else if (it.equals('1')) {
                    matrix[i][j] = true
                    j++
                }
            }
            i++
        }
//        println("Matrix leida: $i lineas leidas")
//        printMatrix()
    }

    private fun printMatrix(){
        for (i in 0 until matrix.size){
            for (j in 0 until matrix[i].size){
                print((if (matrix[i][j]) "1" else "0") + " ")
            }
            println()
        }
    }

    fun parse():String{
        var porcentaje = 0f
        var bestEmote = ""

        set.forEach(){
            val map = it.value
            var similitud = 0
            for (i in 0 until map.size){
                for (j in 0 until map[i].size){
                    if (map[i][j] == matrix[i][j]){
                        similitud++
                    }
                }
            }

            val temp = (similitud * 1f / (map.size * map[0].size))
            //println(it.key + " | " + temp + ", " + similitud)
            if (temp > porcentaje){
                porcentaje = temp
                bestEmote = it.key
            }
        }

        return bestEmote
    }

    private fun copy(ar:Array<Array<Boolean>>):Array<Array<Boolean>> {
        var newAr = ArrayList<Array<Boolean>>()
        for (i in 0 until ar.size){
            val a = ar[i].clone()
            newAr.add(a)
        }
        return newAr.toTypedArray()
    }
}