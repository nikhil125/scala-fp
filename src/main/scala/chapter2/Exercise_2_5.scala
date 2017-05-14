package chapter2

/**
  * <pre>
  * Implement the high order function that composes two function.
  * </pre>
  */
class Exercise_2_5 {
  def compose[A,B,C] (f : B => C, g: A => B) : A  => C = {
    (a : A) => f(g(a))
  }
}
