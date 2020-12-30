package com.mactavish.course_recom

import scala.collection.mutable

// Model for student
case class Student(private val id:Int,val name:String) {
  // Relations? TODO
  private val historyCourses:Set[Course] = Set()
  private val score:Map[Course,Score]= Map()
}
