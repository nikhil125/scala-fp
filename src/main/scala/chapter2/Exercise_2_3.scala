package chapter2

/**
  * <pre>
  * Let's lool at another example, currying, which onverts a function f of two arguments into a function of one argument
  * that partially applies f. Here again there's only one implementation that compiles.
  * </pre>
  */
class Exercise_2_3 {
  def curry[A,B,C] (f :(A,B) => C) : A => (B =>C) = {
    a: A => b :B => f(a, b)
  }
}
