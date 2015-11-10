/**
 * Factoring.
 * Created by Admin on 2015/10/28.
 */
object Factor1234567890 {
  def main(args: Array[String]) {
    var n = 1234567890
    while (n % 2 == 0) {
      print(2 + " ")
      n /= 2
    }
    var m = 3
    while (m * m <= n) {
      while (n % m == 0) {
        print(m + " ")
        n /= m
      }
      m += 2
    }
    if (n > 1) println(n)
  }
}
