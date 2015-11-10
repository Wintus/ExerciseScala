/**
  * Created by Admin on 2015/11/09.
  */
object ExerciseOption {
  val _toInt: (String ⇒ Option[Int]) = { n ⇒
    try {
      Some(n.trim.toInt)
    } catch {
      case e: NumberFormatException ⇒ None
    }
  }

  def main(args: Array[String]) {
    println(_toInt)

    _toInt("123") foreach println
    _toInt("0x123") foreach println
    println(_toInt("0x123") getOrElse 0)

    _toInt("123") match {
      case Some(n) ⇒ println(n)
      case None ⇒ println("Not a number")
    }

    val bag = List("1", "2", "foo", "3", "bar", "4")
    println(bag)
    println(bag map _toInt)
    println(bag flatMap (s ⇒ _toInt(s)))
    val sum = (bag flatMap (s ⇒ _toInt(s))).sum
    println(sum)
  }
}
