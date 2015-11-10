/**
  * Infinite List of Fibonacci Numbers.
  * Created by Admin on 2015/11/02.
  */
object FibonacciLazy {
  lazy val fibonacci: Stream[Int] =
    0 #:: (1 #:: (fibonacci zip fibonacci.tail map (fib ⇒ fib._1 + fib._2))) takeWhile (_ >= 0)
  lazy val fibonacciBigInt: Stream[BigInt] =
    BigInt(0) #:: (BigInt(1) #::
      (fibonacciBigInt zip fibonacciBigInt.tail map (fib ⇒ fib._1 + fib._2)))
  lazy val fibonacciLong = {
    def _fib(h: Long, n: Long): Stream[Long] = h #:: _fib(n, h + n)
    _fib(0, 1)
  } takeWhile (_ >= 0)

  /*
    val pos : Int ⇒ Boolean = _ >= 0
    def isPositive(n: Int) = n >= 0
    def isPositive(n: Long) = n >= 0
  */

  val natural = Stream from 0

  def main(args: Array[String]) {
    /*
    println(Int.MaxValue)
    println(Math pow(2, 31) toInt)
    println(Int.MaxValue == (Math pow(2, 31) toInt))
    println()
    */
    natural zip fibonacci take 1 << 4 print()
    println()
    natural zip fibonacci take 1 << 6 print()
    println()
    println(natural zip fibonacci apply 1 << 5)

    var _i = 2 << 3
    val a, b, c = {
      _i += 1
      natural zip fibonacci apply _i
    }
    println(a, b, c)

    println(fibonacciBigInt(1 << 7))

    natural zip fibonacciLong print()
    println()
  }
}

object Fibonacci {
  //  def fibonacciTo(n: Int): List[Int] =
}
