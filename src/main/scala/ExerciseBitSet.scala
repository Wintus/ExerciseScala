import scala.collection.mutable

/**
  * Created by Admin on 2015/11/03.
  */
object ExerciseBitSet {
  def main(args: Array[String]) {
    val int = "1_000_000".replaceAll("\\D", "").toInt
    println(int)
    val bitSet0 = mutable.BitSet.empty ++= 0 to 9
//    val bitSet0 = new mutable.BitSet(10)
    println(bitSet0 toList)
    println(bitSet0 size)
    bitSet0 &~= (mutable.BitSet.empty ++= Array(2, 3, 5, 7))
    println(bitSet0 toList)
    val bitSet1 = mutable.BitSet.empty ++= 3 to 1000 by 2
  }
}
