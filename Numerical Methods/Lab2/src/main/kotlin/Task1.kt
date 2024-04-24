import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sin

const val EPSILON = 0.000001


class Task1 {
    companion object {
        private val a = 0
        private val b = Math.PI

        private val h = EPSILON.pow(0.25)

        private val nNotRounded = (b - a) / h

        private val n = if (nNotRounded.roundToInt() < nNotRounded) {
            nNotRounded.roundToInt() + 1
        } else {
            nNotRounded.roundToInt()
        }
        private fun initPoints(n: Int): Array<Double> {
            val points = Array(n + 1) { 0.0 }
            for (i in 0..< n) {
                points[i] = a + h * i
            }
            points[n] = b
            return points
        }
        private fun integrand(x: Double): Double {
            return sin(3 * x) * sin(5 * x)
        }

        private fun calculate(points: Array<Double>): Double {
            var sum = (integrand(points[0]) + integrand(points[n])) / 2
            for (i in 1..<n) {
                sum += integrand(points[i])
            }
            return h * sum
        }
        fun solve() {
            val points = initPoints(n)
            val integral = calculate(points)
            println("Step: $h\n" +
                    "Integral = $integral\n" +
                    "Analytics Integral = 0")
        }
    }
}
