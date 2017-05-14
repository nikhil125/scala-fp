package chapter2

/**
  * <pre>
  * Implement uncurry, which reverses the transformation of curry. Note that since => associate to the right,
  * A => (B => C) can be written as A => B => C.
  * </pre>
  */
class Exercise_2_4 {
  def uncurry[A,B,C] (f : A => B => C) : (A ,B) => C = {
    (a : A, b : B) => f(a) (b)
  }
}
