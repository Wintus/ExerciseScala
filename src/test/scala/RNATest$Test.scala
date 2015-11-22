import ArchitectureOfCollections._
import org.scalatest.{FunSuite, ShouldMatchers}

/**
  * Created by Admin on 2015/11/02.
  */
class RNATest$Test extends FunSuite with ShouldMatchers {

  val rna = RNA(A, U, G, G, C)

  test("RNA_0") {
    rna shouldBe RNA(A, U, G, G, C)
  }

  test("RNA_fromSeq_0") {
    val bs = List(A, G, C, A)
    RNA.fromSeq(bs) shouldBe RNA(A, G, C, A)
  }

  test("RNA_take") {
    rna take 3 shouldBe RNA(A, U, G)
  }

  test("RNA_filter") {
    rna filter (_ != U) shouldBe RNA(A, G, G, C)
  }

  test("RNA_map") {
    rna map { case A ⇒ C case b ⇒ b } shouldBe RNA(C, U, G, G, C)
  }

  test("RNA_map_nonVector") {
    rna map { case A ⇒ C case b ⇒ b } should not be Vector(C, U, G, G, C)
  }

  test("RNA_addAll") {
    rna ++ rna shouldBe RNA(A, U, G, G, C, A, U, G, G, C)
  }

  test("RNA_addAll_nonVector") {
    rna ++ rna should not be Vector(A, U, G, G, C, A, U, G, G, C)
  }
}
