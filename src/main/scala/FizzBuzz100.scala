/**
 * FizzBuzz.
 * Created by Admin on 2015/10/28.
 */
object FizzBuzz100 {
  def main(args: Array[String]) {
    for (n <- 0 to 100) {
      if (n % 15 == 0)
        print("FizzBuzz")
      else
      if (n % 3 == 0)
        print("Fizz")
      else if (n % 5 == 0)
        print("Buzz")
      else
        print(n)
      print(" ")
    }
  }
}
