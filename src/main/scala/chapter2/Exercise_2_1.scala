package chapter2

import scala.annotation.tailrec

/**
 * <pre>
 * Write a recursive function to get nth Fibonacci number.
 * First two Fibonacci numbers are 0 and 1. The nth number is always the sum of the previous two -
 * the sequence begins 0,1,1,2,3,5,8... .Your definition should use a local tail-recursive function.
 * def fib(n : Int) : Int
 * </pre>
 */
class Exercise_2_1 {
  def fib(n: Int) :Int = {
    if( n<= 0) 0
    else {
      @tailrec
      def fib_number(x: List[Int]): Int = {
        val len = x.length
        if (x.length >= n) x(len - 1)
        else fib_number(x :+ (x(len - 1) + x(len - 2)))
      }
      fib_number(List(0, 1))
    }

  }

}
