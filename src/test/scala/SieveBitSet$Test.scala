import org.scalatest.{FunSuite, ShouldMatchers}

/**
  * Created by Admin on 2015/11/02.
  */
class SieveBitSet$Test extends FunSuite with ShouldMatchers {

  // instantiate object
  Timer.timeInMillisecond {SieveBitSet.getClass}

  test("testCountPrimesLessThan10") {
    SieveBitSet countPrimesLessThan 10 shouldEqual 4
  }

  test("testCountPrimesLessThan100") {
    SieveBitSet countPrimesLessThan 100 shouldEqual 25
  }

  test("testCountPrimesLessThan1000") {
    SieveBitSet countPrimesLessThan 1000 shouldEqual 168
  }

  test("testCountPrimesLessThan10000") {
    SieveBitSet countPrimesLessThan 10000 shouldEqual 1229
  }

  test("testCountPrimesLessThan100000") {
    SieveBitSet countPrimesLessThan 100000 shouldEqual 9592
  }

  // test("some new test") (pending)
}
