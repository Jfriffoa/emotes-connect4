package connect4

fun main(args:Array<String>){
    var b = Board()
    val ia = IA()

    var winner = 0
    while (winner == 0){
        b.print()
        print("Make your move: ")

        var pos = -1
        try {
            pos = readLine()!!.trim().toInt()
        } catch (e:Exception) {

        }

        if (!b.makePlay(1, pos - 1)){
            println("¡¡MOVEMENT UNALLOWED!!")
        }

        winner = b.checkWinner()
        //println()

        if (b.isFull() && winner == 0){
            winner = -5
        }

        if (winner == 0){
            println("Turno de la CPU...")
            ia.makeMove(b)

            winner = b.checkWinner()

            if (b.isFull() && winner == 0){
                winner = -5
            }
        }
    }

    b.print()
    if (winner == -5)
        println("¡¡ES UN EMPATE!!")
    else
        println("FELICIDADES, " + ( if (winner == 1) "x" else "o") + " ES EL GANADOR")
}