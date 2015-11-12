/**
  * Sieve of Eratosthenes.
  * Created by Admin on 2015/11/02.
  */
object SieveOfEratosthenes {
  def primesTo(n: Int) = sieve(Range(2, n) toList)

  def main(args: Array[String]) {
    println(primesTo(100))
  }

  private def sieve(ns: List[Int]): List[Int] =
    if (ns isEmpty)
      Nil
    else
      ns.head :: sieve(ns.tail filter (_ % ns.head != 0))
}
