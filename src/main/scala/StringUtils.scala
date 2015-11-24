/**
  * http://qiita.com/suin/items/61d121bef4d99a701543
  * https://coderwall.com/p/lcxjzw/safely-parsing-strings-to-numbers-in-scala
  * Created by Admin on 2015/11/24.
  */
object StringUtils {
  implicit class StringImprovements(val s: String) {
    import scala.util.control.Exception._
    def toIntOpt = catching(classOf[NumberFormatException]) opt s.toInt
  }
}