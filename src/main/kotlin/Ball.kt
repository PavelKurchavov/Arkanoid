import kotlin.math.cos
import kotlin.math.sin

class Ball(x: Double, y: Double, private var speed: Double) : BaseObject(x, y, 1.0) {
    private var dx: Double = 0.0
    var dy: Double = 0.0
    private var isFrozen = true

    var direction: Double = 95.0
        set(direction) {
            field = direction
            val angle: Double = Math.toRadians(direction)
            dx = cos(angle) * speed
            dy = -sin(angle) * speed
        }

    override fun draw(canvas: Canvas) = canvas.setPoint(x, y, '0')

    override fun move() {
        if (isFrozen) return
        x += dx
        y += dy

        checkRebound(game.width, game.height + 5)
    }

    private fun checkRebound(maxX: Int, maxY: Int) {
        if (x < 1) {
            x = 2 - x
            dx = -dx
        }

        else if (x > maxX) {
            x = 2 * maxX - x
            dx = -dx
        }

        if (y < 1) {
            y = 2 - y
            dy = -dy
        }

        else if (y > maxY) {
            y = 2 * maxY - y
            dy = -dy
        }
    }

    fun start() {
        direction = direction
        isFrozen = false
    }


}