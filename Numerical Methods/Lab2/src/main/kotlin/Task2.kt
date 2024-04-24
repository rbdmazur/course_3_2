import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

class Task2 {
    companion object {
        private val n = 50
        private val a = -1
        private val b = 1
        private val h: Double = (b - a) / n.toDouble()

        private val PI = Math.PI

        private fun integrand(x: Double): Double {
            return ln(x + 1) / sqrt(1 - x.pow(2))
        }
        private fun f(x: Double): Double = ln(x + 1)

        private fun initWeightsForGauss() = Array(n + 1) {PI / n}
        private fun initPointsForGauss(): Array<Double> {
            val points = Array(n + 1){0.0}
            for (i in 0..n) {
                points[i] = cos(((2 * i - 1) * PI) / (2 * n))
            }
            return points
        }

        private fun initPointsForRectangle(): Array<Double> {
            val points = Array(n){0.0}
            for (i in 0..<n) {
                points[i] = a + h * i
            }
            return points
        }

        private fun calculateGauss(weights: Array<Double>, points: Array<Double>): Double {
            var sum = 0.0
            for (i in 0..n) {
                sum += weights[i] * f(points[i])
            }
            return sum
        }

        private fun calculateRectangle(points: Array<Double>): Double {
            var sum = 0.0
            for (i in 0..<n) {
                sum += integrand(points[i] + h / 2)
            }
            return h * sum
        }

        fun solve() {
            val integralGauss = calculateGauss(initWeightsForGauss(), initPointsForGauss())
            val integralRectangle = calculateRectangle(initPointsForRectangle())
            println("Number of keys: $n\n" +
            "Integral with Gauss: I = $integralGauss\n" +
            "Integral with Rectangle: I = $integralRectangle")
        }
    }
}
