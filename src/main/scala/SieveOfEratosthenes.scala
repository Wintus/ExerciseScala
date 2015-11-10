import scala.collection.mutable

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

object SieveLazy {
  val primes = sieve(Stream from 2)

  def main(args: Array[String]) {
    println(primes take 10)
    println(primes(100))
    println(primes filter (_ > 1000) head)
    // println(primes count (_ < 1000)) // nonstop
    println(primes takeWhile (_ < 1000) size)
  }

  private def sieve(ns: Stream[Int]): Stream[Int] =
    ns.head #:: sieve(ns.tail filter (_ % ns.head != 0))
}

object SieveBitSet {
  val sup: Int = 1000000
  // use foreach to run while loop
  val primes: List[Int] = {
    val toIndex: Int ⇒ Int = _ >> 1
    // initialize BitSet
    val oddPrimes = mutable.BitSet.empty
    toIndex(3) until toIndex(sup) foreach (oddPrimes +=)
    // sieve out non-primes
    val max_int32_sqrt: Int = 46340
    3 until max_int32_sqrt by 2 foreach (n ⇒
      if (oddPrimes(toIndex(n)))
        toIndex(n * n) until toIndex(sup) by toIndex(n * 2) foreach (oddPrimes -=)
      )
    // return in list
    2 :: (oddPrimes.toIterator map (_ * 2 + 1) toList)
  }

  def main(args: Array[String]) {
    /*
        println("Primes up to: " + sup)
        println("Primes: %s".format(primes mkString ", "))
        println("Number of Primes: %d / %d".format(primes length, sup))
    */
    for (n ← Functional.iterate[Int](_ * 10, 1) takeWhile (_ <= sup))
    //    for (n ← Functional.iterate[Int](_ << 1, 1) takeWhile (_ <= sup))
      println("Number of Primes: %5d / %7d".format(countPrimesLessThan(n), n))
  }

  def countPrimesLessThan(n: Int): Int = primes count (_ < n)

  def primesLessThan(n: Int): List[Int] = primes takeWhile (_ < n)
}

