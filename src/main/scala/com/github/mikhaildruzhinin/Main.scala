package com.github.mikhaildruzhinin

import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    implicit lazy val spark: SparkSession = SparkSession
      .builder()
      .master("local")
      .getOrCreate()

    import spark.implicits._

    val df = Seq(
      ("1", "A", 12),
      ("2", "B", 13),
      ("3", "C", 0)
    ).toDF("id", "category", "value")

    df.show()

    spark.stop()
  }
}
