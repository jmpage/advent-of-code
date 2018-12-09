package io.jenpage.advent2017

object Day1 {
  def solve(captcha: String, offset: Int = 1): Int = {
    val values = for (idx <- 0 to captcha.length - 1) yield {
      val lastIdx = if (idx < offset) captcha.length - (offset - idx) else idx - offset
      val lastChar = captcha.charAt(lastIdx)
      val char = captcha.charAt(idx)
      if (lastChar == char)
        char.asDigit
      else
        0
    }
    values.reduce(_ + _)
  }

  def solve2(captcha: String): Int = {
    this.solve(captcha, captcha.length / 2)
  }
}


object Day2 {
  def transformSheet(sheet: String): Array[Array[Int]] = {
    for (row <- sheet.split("\n")) yield {
      val items = row.split(Array(' ', '\t'))
      for (item <- items) yield item.toInt
    }
  }
  def checksum(sheet: String): Int = {
    val rows = this.transformSheet(sheet)
    val differences = for (row <- rows) yield {
      val max = row.reduce((x, y) => if (x > y) x else y)
      val min = row.reduce((x, y) => if (x < y) x else y)
      max - min
    }
    differences.reduce(_ + _)
  }

  def checksum2(sheet: String): Int = {
    val rows = this.transformSheet(sheet)
    for (row <- rows) yield {
      val sorted = row.sorted
      for (i <- 0 to sorted.length - 2) yield {
        for (j <- i+1 to sorted.length - 1) yield {
          if (sorted(i) % sorted(j) == 0)
            sorted(i) / sorted(j)
          else
            0
        }.reduce(_ + _)
      }.reduce(_ + _)
    }.reduce(_ + _)
  }
}
