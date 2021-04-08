class Brick(x: Double, y: Double) : BaseObject(x, y, 3.0) {
    override fun draw(canvas: Canvas) = canvas.drawMatrix(x - radius + 1, y, matrix, 'H')
}

private val matrix = arrayOf(
    intArrayOf(0, 0, 0, 0, 0),
    intArrayOf(0, 1, 1, 1, 0),
    intArrayOf(0, 1, 1, 1, 0),
    intArrayOf(0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0),
)

