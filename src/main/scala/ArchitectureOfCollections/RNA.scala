package ArchitectureOfCollections

import scala.collection.{IndexedSeqLike, generic, mutable}

abstract class Base

case object A extends Base

case object G extends Base

case object C extends Base

case object U extends Base

object Base {
  val fromInt: Int ⇒ Base = Array(A, G, C, U).apply
  val toInt: Base ⇒ Int = Map(A → 0, G → 1, C → 2, U → 3)
}

/**
  * http://eed3si9n.github.io/scala-collections-impl-doc-ja/
  * Created by Admin on 2015/11/21.
  */
final class RNA private(val groups: Array[Int], val length: Int)
  extends IndexedSeq[Base]
  with IndexedSeqLike[Base, RNA] {

  import RNA._

  // IndexedSeqLike requires
  def apply(index: Int): Base = {
    if (index < 0 || length <= index) throw new IndexOutOfBoundsException
    else Base.fromInt(groups(index / N) >> (index % N * S) & M)
  }

  // reimplementation for efficiency
  override def foreach[U](f: Base ⇒ U): Unit = {
    var i = 0
    var b = 0
    while (i < length) {
      b = if (i % N == 0) groups(i / N) else b >>> S
      f(Base.fromInt(b & M))
      i += 1
    }
  }

  override def equals(other: Any) = canEqual(other) && super.equals(other)

  override def canEqual(other: Any) = other.isInstanceOf[RNA]

  // IndexedSeqLike requires
  override protected[this] def newBuilder: mutable.Builder[Base, RNA] = RNA.newBuilder
}

object RNA {
  // number of bits in group
  private val S = 2
  // bitmask to isolate a group
  private val M = (1 << S) - 1
  // number of groups in an Int
  private val N = 32 / S

  def apply(bases: Base*) = fromSeq(bases)

  implicit def cbf: generic.CanBuildFrom[RNA, Base, RNA] =
    new generic.CanBuildFrom[RNA, Base, RNA] {
      def apply(): mutable.Builder[Base, RNA] = newBuilder

      def apply(from: RNA): mutable.Builder[Base, RNA] = newBuilder
    }

  def newBuilder: mutable.Builder[Base, RNA] = new mutable.ArrayBuffer[Base] mapResult fromSeq

  def fromSeq(buf: Seq[Base]): RNA = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    buf.indices foreach { i ⇒ groups(i / N) |= Base.toInt(buf(i)) << (i % N * S) }
    new RNA(groups, buf.length)
  }
}
