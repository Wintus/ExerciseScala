package ArchitectureOfCollections

import scala.collection.generic.CanBuildFrom
import scala.collection.{immutable, mutable}

/**
  * Patricia trie.
  * http://eed3si9n.github.io/scala-collections-impl-doc-ja/
  * Created by Admin on 2015/11/22.
  */
class PrefixMap[T]
  extends mutable.Map[String, T]
  with mutable.MapLike[String, T, PrefixMap[T]] {

  var value: Option[T] = None
  var suffixes: immutable.Map[Char, PrefixMap[T]] = Map.empty

  override def get(key: String): Option[T] =
    if (key.isEmpty) value
    else suffixes get key(0) flatMap (_ get (key substring 1))

  override def iterator: Iterator[(String, T)] =
    (for (v ← value.iterator) yield ("", v)) ++
      (for {
        (char, map) ← suffixes.iterator
        (s, v) ← map.iterator
      } yield (char +: s, v))

  override def empty = new PrefixMap[T]

  def withPrefix(key: String): PrefixMap[T] =
    if (key.isEmpty) this
    else {
      val leading = key(0)
      if (suffixes get leading isEmpty) suffixes = suffixes + (leading → empty)
      suffixes(leading) withPrefix (key substring 1)
    }

  override def update(key: String, elem: T) {
    withPrefix(key).value = Some(elem)
  }

  override def remove(key: String): Option[T] =
    if (key.isEmpty) {
      val prev = value
      value = None
      prev
    } else suffixes get key(0) flatMap (_ remove (key substring 1))

  override def +=(kv: (String, T)): this.type = {
    update(kv._1, kv._2)
    this
  }

  override def -=(key: String): this.type = {
    remove(key)
    this
  }
}

object PrefixMap {
  def apply[T](entries: (String, T)*): PrefixMap[T] = {
    val map: PrefixMap[T] = empty
    entries foreach (map +=)
    map
  }

  implicit def cbf[T] =
    new CanBuildFrom[PrefixMap[_], (String, T), PrefixMap[T]] {
      override def apply(from: PrefixMap[_]): mutable.Builder[(String, T), PrefixMap[T]] =
        newBuilder[T]

      override def apply(): mutable.Builder[(String, T), PrefixMap[T]] = newBuilder[T]
    }

  def newBuilder[T]: mutable.MapBuilder[String, T, PrefixMap[T]] =
    new mutable.MapBuilder[String, T, PrefixMap[T]](empty)

  def empty[T] = new PrefixMap[T]
}
