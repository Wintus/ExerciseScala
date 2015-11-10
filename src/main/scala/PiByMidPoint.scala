/**
 * Calc Pi.
 * Created by Admin on 2015/10/28.
 */
object PiByMidPoint {
  def main(args: Array[String]) {
    val n = 10000
    val w = 1.0 / n
    var s = 0.0
    for (i <- 1 to n) {
      val x = (i - 0.5) * w
      s += 4.0 / (1.0 + x * x)
    }
    println(s * w)
  }
}
