/**
  * Functional tools.
  * Created by Admin on 2015/11/02.
  */
object Functional {
  val natural = Stream from 0

  def cycle[T](a: Iterable[T]) = repeat(a) flatMap identity

  def repeat[T](a: T) = Stream.iterate(a)(identity)

  def iterate[T](f: T => T, x: T): Stream[T] = Stream.cons(x, iterate(f, f(x)))

  def replicate[T](n: Int, elem: T) = Stream.fill(n)(elem)

  def main(args: Array[String]) {
    repeat(1) take 10 print()
    println()

    cycle(1 to 4) take 10 print()
    println()

    cycle('A' to 'Z') take 100 print()
    println()

    iterate[Int](_ * 2, 1) take 10 print()
    println()

    replicate(3, 9) take 10 print()
    println()
  }
}
