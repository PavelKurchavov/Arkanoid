class Stand(x: Double, y: Double) : BaseObject(x, y, 3.0) {
    private val speed: Double = 1.0
    private var direction: Double = 0.0

    override fun draw(canvas: Canvas) = canvas.drawMatrix(x - radius + 1, y, matrix, 'M')

    override fun move() {
        val dx = speed * direction
        x += dx
        checkBorders(radius, game.width - radius + 1, 1.0, game.height + 1.0)
    }

    fun moveLeft() {
        direction = -1.0
    }

    fun moveRight() {
        direction = 1.0
    }
}

private val matrix = arrayOf(
    intArrayOf(1, 1, 1, 1, 1),
    intArrayOf(1, 0, 0, 0, 1),
    intArrayOf(0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0)
)