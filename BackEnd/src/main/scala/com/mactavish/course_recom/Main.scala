package com.mactavish.course_recom

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{SQLContext, SparkSession}
import monix._; import eval.Task; import execution.Scheduler.Implicits.global
import io.taig.communicator._
import okhttp3.OkHttpClient
import scala._; import util._; import concurrent._; import duration._

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

// Client for network communication
object SimpleClient {
  implicit val client = new OkHttpClient()
  val url: String = ???

  // Simple OkHttp request builder
  val builder = new OkHttpRequestBuilder().url(url)

  // Construct a Task[Response] and parse it to a String
  val request = Request(builder.build()).parse[String]

  // Kick off the actual request
  val response = request.runAsync
}
