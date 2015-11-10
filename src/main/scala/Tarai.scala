/**
 * TaraiInJava Function.
 * Created by Admin on 2015/10/28.
 */
object Tarai {
  def tak(x: Int, y: Int, z: Int): Int = {
    if (x <= y) z
    else tak(tak(x - 1, y, z), tak(y - 1, z, x), tak(z - 1, x, y))
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    tak(22, 11, 0)
    println((System.currentTimeMillis - start) + "ms")
  }
}
