package connect4

class IA {
    var tt = TT()
    val maxDepth = 2

    fun makeMove(b:Board){
        var move = negaMax(b, -1, 0)

        if (move.second != 5)
            b.makePlay(-1, move.second)
    }

    private fun negaMax(b:Board, player:Int, depth:Int):Pair<Int, Int> {
        //Revisar en mi tabla si es que esta jugada ya la había visto
        var entry = tt.lookup(b)

        //Si la jugada ya está "calculada", retornar
        if (b.hashCode() == entry.hash){
            return Pair(entry.value, entry.bestCol)
        }

        //Cancelar la busqueda en caso de llegar aquí
        if (depth > maxDepth){
            return Pair(5, -1);
        }

        val winner = b.checkWinner()

        //Si el juego ya terminó, Empate (0) y mejor columna (-1)
        if (b.isFull() && winner == 0){
            return Pair(0, -1)
        }

        //Si ya hay ganador, devuelve uno si es que el jugador actual ganó
        if (winner != 0){
            return Pair(if (winner == player) 1 else -1, -1)
        }

        //Si nadie a ganado, llamar a NegaMax por cada movimiento
        var score = -5
        var bestCol = -1

        for (i in 0 until b.Width()){
            var child = b.clone()
            if (child.makePlay(player, i)) {
                var value = negaMax(child, -player, depth + 1)
                if (-value.first > score){
                    score = -value.first
                    bestCol = value.second
                }
            }
        }

        if (score == -5){
            return Pair(5, -1)
        }

        tt.store(b, depth, score, bestCol)
        return Pair(score, bestCol)
    }
}