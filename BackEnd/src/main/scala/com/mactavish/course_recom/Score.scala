package com.mactavish.course_recom

case class Score(x:Int, student: Student, course: Course){
  def +(other:Score): Score ={
    if(student==other.student){
      Score(x+other.x,student,null)
    }else if(course==other.course){
      Score(x+other.x,null,course)
    }else{
      null
    }
  }

  def -(other:Score): Score ={
    if(student==other.student){
      Score(x-other.x,student,null)
    }else if(course==other.course){
      Score(x-other.x,null,course)
    }else{
      null
    }
  }
}

object Score{
  // Sum of the scores of one course.
  def of(course: Course):Score= ???
  // Sum of the scores of one student.
  def of(student: Student):Score= ???
}
