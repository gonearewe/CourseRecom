package com.mactavish.course_recom.database

import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.recommendation.ALS

case class Rating(userId: Int, courseId: Int, rating: Float, timestamp: Long) {
  def parseRating(str: String): Rating = {
    val fields = str.split("::")
    assert(fields.size == 4)
    Rating(fields(0).toInt, fields(1).toInt, fields(2).toFloat, fields(3).toLong)
  }

  val ratings = spark.read.textFile("../resource/student.db")
    .map(parseRating)
    .toDF()
  val Array(training, test) = ratings.randomSplit(Array(0.8, 0.2))

  // Build the recommendation model using ALS on the training data
  val als = new ALS()
    .setMaxIter(5)
    .setRegParam(0.01)
    .setUserCol("userId")
    .setItemCol("courseId")
    .setRatingCol("rating")
  val model = als.fit(training)

  // Evaluate the model by computing the RMSE on the test data
  model.setColdStartStrategy("drop")
  val predictions = model.transform(test)

  val evaluator = new RegressionEvaluator()
    .setMetricName("rmse")
    .setLabelCol("rating")
    .setPredictionCol("prediction")
  val rmse = evaluator.evaluate(predictions)
  println(s"Root-mean-square error = $rmse")

  // Generate top 10 course recommendations for each user
  val userRecs = model.recommendForAllUsers(10)
  // Generate top 10 user recommendations for each course
  val courseRecs = model.recommendForAllItems(10)

  // Generate top 10 course recommendations for a specified set of users
  val users = ratings.select(als.getUserCol).distinct().limit(3)
  val userSubsetRecs = model.recommendForUserSubset(users, 10)
  // Generate top 10 user recommendations for a specified set of courses
  val courses = ratings.select(als.getItemCol).distinct().limit(3)
  val courseSubSetRecs = model.recommendForItemSubset(courses, 10)
}
