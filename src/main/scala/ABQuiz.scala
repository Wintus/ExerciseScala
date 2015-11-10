/**
  * CodeIQ.
  * Created by Admin on 2015/10/30.
  */
object ABQuiz {
  val abBaseMap = Map((18, 86) -> 13, (16, 75) -> 15) //, (14, 68) -> 17, (13, 62) -> 18)

  def main(args: Array[String]) {
    val x = io.StdIn.readInt()
    val y = io.StdIn.readInt()
    val base = abBaseMap((x, y))
    val sumABC = 0xA + 0xB + 0xC // = 33
    println(Integer.toString(sumABC, base))
  }
}
