import Functional._

/**
  * Created by Admin on 2015/11/02.
  */
object FizzBuzzLazy {
  lazy val fizz_buzz =
    cycle("Fizz" #:: replicate(3 - 1, "")) zip
      cycle("Buzz" #:: replicate(5 - 1, "")) map { case (fizz, buzz) ⇒ fizz + buzz } zip
      (Stream from 0) map { case (s, n) ⇒ if (s == "") n else s }

  def main(args: Array[String]) {
    fizz_buzz slice(1, 21) print()
    println()
    fizz_buzz take 1 << 5 print()
    println()
    println((Range(0, 10), Range(5, 15)).zipped map (_ + _))
    println('A' to 'Z' zip Range(5, 15) map { case (char, int) ⇒ s"$char$int" } mkString ", ")
    println('A' to 'Z' zip natural map { case (char, index) ⇒ s"$char:$index" } mkString ", ")
  }
}
