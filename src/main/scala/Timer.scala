/**
  * Created by Admin on 2015/11/09.
  * http://stackoverflow.com/questions/23703476/scala-pararray-sorting
  */
object Timer {
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block // call-by-name
    val t1 = System.nanoTime()
    val diff: Long = t1 - t0
    println(s"Elapsed time: ${diff * 1.0 / 1E9}s")
    result
  }
}
