package com.mactavish.course_recom

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{SQLContext, SparkSession}

object CourseRecom extends App {
  System.setProperty("hadoop.home.dir","E:\\MyProjects\\CourseRecom")
  val spark = SparkSession.builder
    .master("local[*]")
    .appName("App")
    .getOrCreate()
  // test if Spark works
  //val data = spark.sparkContext.parallelize(
  //  Seq("Test", "Spark demo", "CourseRecom","Big Data")
  //)
  //val filtered = data.filter(line => line.contains("t"))
  //filtered.collect().foreach(print)
}
