class Brick(x: Double, y: Double) : BaseObject(x, y, 3.0) {
    override fun draw(canvas: Canvas) = canvas.drawMatrix(x - radius + 1, y, brickMatrix, 'H')
}


