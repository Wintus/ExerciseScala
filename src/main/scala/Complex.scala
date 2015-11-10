/**
 * Complex.
 * Created by Admin on 2015/10/28.
 */
class Complex(real: Double, imaginary: Double) {
  override def toString =
    "" + re + (if (im < 0) "-" else "+") + im + "i"

  def re = real

  def im = imaginary
}

object Main {
  def main(args: Array[String]) {
    val c = new Complex(7, 26)
    println(c)
  }
}
