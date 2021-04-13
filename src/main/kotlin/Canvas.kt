import kotlin.math.round

class Canvas(private val width: Int, private val height: Int) {
    private var matrix: Array<Array<Char>> = Array(height + 2) { Array(width + 2) {'.'} }

    fun clear() {
        matrix = Array(height + 2) { Array(width + 2) {'.'} }
    }

   fun drawMatrix(x: Double, y: Double, matrix: Array<IntArray>, c: Char) {
       for((outerIndex, element) in matrix.withIndex()) {
           for((innerIndex, innerElement) in element.withIndex()) {
               if(innerElement == 1) setPoint(x + innerIndex, y + outerIndex, c)
           }
       }
   }

    fun setPoint(x: Double, y: Double, c: Char) {
        val x0 = round(x).toInt()
        val y0 = round(y).toInt()
        if(y0 < 0 || y0 >= matrix.size || x0 < 0 || x0 >= matrix[y0].size) return

        matrix[y0][x0] = c
    }

    fun print() {
        println()

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                print(" ")
                print(matrix[i][j])
                print(" ")
            }
            println()
        }
        println()
        println()
        println()
    }
}