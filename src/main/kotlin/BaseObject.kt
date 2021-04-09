import kotlin.math.max
import kotlin.math.sqrt

abstract class BaseObject(internal var x: Double, internal var y: Double, internal var radius: Double) {
    abstract fun draw(canvas: Canvas)
    open fun move() {}

    fun checkBorders(minX: Double, maxX: Double, minY: Double, maxY: Double) { TODO("remove million ifs")
        if (x < minX) x = minX
        if (x > maxX) x = maxX
        if (y < minY) y = minY
        if (y > maxY) y = maxY
    }

    fun isIntersec(o: BaseObject): Boolean {
        val dx = x - o.x
        val dy = y - o.y
        val destination = sqrt(dx * dx + dy * dy)
        val destination2 = max(radius, o.radius)
        return destination <= destination2
    }
}