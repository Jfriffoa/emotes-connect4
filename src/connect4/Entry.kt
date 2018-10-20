package connect4

//"Struct" para almacenar las entradas de la tabla
data class Entry(val hash : Int, val depth : Int, val value : Int, val bestCol : Int)