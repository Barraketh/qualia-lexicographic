package scalaclasses

object LexicographicSort {
  val ALPHABET = "abcdefghijklmnopqrstuvwxyz"

  def mapStrings(strings: Array[String], mapping: Map[Char, Char]): Array[String] = {
    strings map { s =>
      s.map { c =>
        mapping(c)
      }
    }
  }

  def sort(strings: Array[String], order: String): Array[String] = {
    val forwardMapping = (order zip ALPHABET).toMap
    val backwardsMapping = (ALPHABET zip order).toMap

    val mapped = mapStrings(strings, forwardMapping)
    val sorted = mapped.sorted

    mapStrings(sorted, backwardsMapping)
  }

  def main(args: Array[String]): Unit = {
    println(sort(Array("acb", "abc", "bca"), "abc").toList)
    println(sort(Array("acb", "abc", "bca"), "cba").toList)
    println(sort(Array("aaa", "aa", ""), "a").toList)
  }

}
