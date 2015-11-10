/**
 * Timer using anonymous function.
 * Created by Admin on 2015/10/28.
 */
object TimerAnonymous {
  def main(args: Array[String]) {
    oncePerSecond(() =>
      println("Time flies like an arrow..."))
  }

  def oncePerSecond(callback: () => Unit) {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }
}
