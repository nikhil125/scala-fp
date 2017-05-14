package chapter2

import scala.annotation.tailrec

/**
  * <pre>
  *   Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function:
  * </pre>
  */
class Exercise_2_2 {
  def isSorted[A](as: Array[A], ordered :(A,A) => Boolean) : Boolean = {
    if (as.length <= 1)
      true
    else {

      @tailrec
      def loop(n: Int, result: Boolean): Boolean = {
        if(n >= as.length)  result
        else if(!ordered(as(n-1), as(n))) false
        else loop(n+1, result)

      }
      loop(1, true)
    }

  }
}
