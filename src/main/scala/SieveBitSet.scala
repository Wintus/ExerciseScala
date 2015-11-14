import scala.collection.mutable

/**
  * Created by Admin on 2015/11/11.
  */
object SieveBitSet {
  val sup: Int = 10000000
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
    for (n ← Functional.iterate[Int](_ * 10, 1) takeWhile (_ <= sup))
      println("Number of Primes: %5d / %7d".format(countPrimesLessThan(n), n))
  }

  def countPrimesLessThan(n: Int): Int = primes count (_ < n)

  def primesLessThan(n: Int): List[Int] = primes takeWhile (_ < n)
}
