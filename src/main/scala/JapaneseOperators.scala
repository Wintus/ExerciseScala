/**
  * Created by Admin on 2015/11/03.
  */
object JapaneseOperators {

  def main(args: Array[String]) {
    def 平方根(v: Int): Double = Math.sqrt(v.asInstanceOf[Double])
    def 逆数(v: Double): Double = 1 / v
    def 表示(v: Any): Any = {
      println(v)
      v
    }

    import JapaneseOperators.{Standard ⇒ Japanese}
    implicit def any2japanese[A](v: A): Japanese[A] = new Japanese(v)

    100 の 平方根 の 逆数 を 表示 する
  }

  class Standard[A](self: A) {
    def の[B](f: (A) ⇒ B): B = f(self)

    def を[B](f: (A) ⇒ B): B = f(self)

    def する(): Unit = ()
  }

  class PseudoKansai[A](self: A) {
    def のな[B](f: (A) ⇒ B) = f(self)

    def をな[B](f: (A) ⇒ B) = f(self)

    def すんねん() = ()
  }

}


