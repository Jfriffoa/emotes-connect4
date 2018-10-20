package connect4

//Transposition Table para la IA
class TT {
    val size = 250
    var entries = Array<Entry>(size) {Entry(-1,-1,-1,-1)}

    //Siempre sobreescribir
    fun store(b:Board, depth: Int, score:Int, bestCol: Int){
        val hash = b.hashCode()
        val place = hash % size
        entries[place] = Entry(hash, depth, score, bestCol)
    }

    fun lookup(b:Board):Entry {
        return entries[b.hashCode() % size]
    }

    fun reset() {
        entries = Array<Entry>(size) {Entry(-1,-1,-1,-1)}
    }
}



