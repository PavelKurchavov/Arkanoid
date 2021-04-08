import java.awt.event.KeyEvent

class Arkanoid(val width: Int, val height: Int) {
    private val bricks: ArrayList<Brick> = ArrayList()
    private val ball: Ball = Ball(10.0, 29.0, 2.0, 95.0)
    private val stand: Stand = Stand(10.0, 30.0)
    private var isGameOver = false

    private fun draw(canvas: Canvas) {
        drawBorders(canvas)
        bricks.forEach { it.draw(canvas) }
        ball.draw(canvas)
        stand.draw(canvas)
    }

    private fun drawBorders(canvas: Canvas) {
        for (i in 0 until width + 2) {
            for (j in 0 until height + 2) canvas.setPoint(i.toDouble(), j.toDouble(), '.')
        }

        for (i in 0 until width + 2) {
            canvas.setPoint(i.toDouble(), 0.0, '-')
            canvas.setPoint(i.toDouble(), (height + 1).toDouble(), '-')
        }

        for (i in 0 until height + 2) {
            canvas.setPoint(0.0, i.toDouble(), '|')
            canvas.setPoint((width + 1).toDouble(), i.toDouble(), '|')
        }
    }

    fun run() {
        val canvas = Canvas(width, height)
        val keyboardObserver = KeyboardObserver()
        keyboardObserver.start()

        while (!isGameOver) {
            if (keyboardObserver.hasKeyEvents()) {
                val event = keyboardObserver.eventFromTop
                when (event.keyCode) {
                    KeyEvent.VK_LEFT -> stand.moveLeft()
                    KeyEvent.VK_RIGHT -> stand.moveRight()
                    KeyEvent.VK_SPACE -> ball.start()
                }
            }

            move()
            checkBricksBump()
            checkStandBump()
            checkEndGame()
            canvas.clear()
            draw(canvas)
            canvas.print()
            Thread.sleep(50)
        }
        println("Game over!")
    }

    private fun move() {
        ball.move()
        stand.move()
    }

    private fun checkBricksBump() {
        for(brick in ArrayList<Brick>(bricks)) {
            if(ball.isIntersec(brick)) {
                val angle = Math.random() * 360
                ball.setDirection(angle)
                bricks.remove(brick)
            }
        }
    }

    private fun checkStandBump() {
        if (ball.isIntersec(stand)) {
            val angle = 90 + 20 * (Math.random() - 0.5)
            ball.setDirection(angle)
        }
    }

    private fun checkEndGame() {
        if (ball.y > height && ball.dy > 0) isGameOver = true
    }
}
