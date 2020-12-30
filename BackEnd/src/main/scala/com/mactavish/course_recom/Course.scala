package com.mactavish.course_recom

case class Course(private val id:Int,val name:String,val teacher:Set[Teacher]) {
  private val history:Set[Student] = Set()
}
