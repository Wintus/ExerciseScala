/**
  * Created by Admin on 2015/11/11.
  */
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
