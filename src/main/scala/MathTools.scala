/**
  * Created by Admin on 2015/11/05.
  */
object MathTools {
  val sumByCurried: (BigInt ⇒ BigInt) ⇒ (Int) ⇒ (Int) ⇒ BigInt = {
    def _sumBy = sumBy(_: BigInt ⇒ BigInt, _: Int, _: Int)
    _sumBy curried
  }
  val sumTo = sumByCurried(identity)

  def factorial(n: Int): BigInt = if (n == 0) 1 else n * factorial(n - 1)

  def factorialTCO(n: Long, acc: BigInt = 1): BigInt =
    if (n == 0) 1 else factorialTCO(n - 1, acc * n)

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def lcd(a: Int, b: Int): Int = a * b / gcd(a, b)

  def sumBy(f: BigInt ⇒ BigInt, start: Int, end: Int, acc: BigInt = 0): BigInt =
    if (start > end) acc else sumBy(f, start + 1, end, acc + f(start))

  def sumTo(n: Int, m: Int): BigInt = sumBy(identity, n, m)

  def sumOfSquare(n: Int, m: Int): BigInt = sumBy(x ⇒ x * x, n, m)

  def sumOfCube(n: Int, m: Int): BigInt = sumBy(x ⇒ x * x * x, n, m)

  def fibonacciTCO(n: Int, acc0: BigInt = 0, acc1: BigInt = 1): BigInt =
    if (n == 0) acc0 else fibonacciTCO(n - 1, acc0 + acc1, acc0)

  def main(args: Array[String]) {
    for (i ← 0 to 20) println(fibonacciTCO(i))
    println()
    println(sumTo(1)(100))
  }
}
