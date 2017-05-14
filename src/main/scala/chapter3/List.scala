package chapter3

import scala.annotation.tailrec

object Exercise {
  def main(array: Array[String]): Unit = {
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + List.sum(t)
      case _ => 101
    }
    println(x)
  }
}

sealed trait List[+A] {
  def tail(): List[A]

  def head(): A

  def setHead[A](a: A) = List(a, tail())

}

case object Nil extends List[Nothing] {
  override def tail(): List[Nothing] = Nil

  override def head(): Nothing = None.get
}

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int =
    ints match {
      case Cons(x, xs) => x + sum(xs)
    }

  def product(ds: List[Double]): Double =
    ds match {
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }


  def sum2(ns: List[Int]) = foldRight(ns, 0)((x, y) => x + y)

  def product2(ns: List[Double]) = foldRight(ns, 1.0)(_ * _)

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def empty[A](): List[A] = Nil

  def drop[A](list: List[A], n: Int): List[A] = {

    @tailrec
    def loop(a: Int, result: List[A]): List[A] = {
      if (a > n) result
      else loop(a + 1, result.tail())
    }

    loop(1, list)

  }

  def dropWhile[A](list: List[A], f: A => Boolean): List[A] = {
    list match {
      case Nil => Nil
      case Cons(h, t) if (f(h)) => Cons(h, dropWhile(t, f))
      case Cons(h, t) if (!f(h)) => dropWhile(t, f)

    }
  }

  def foldRight[A, B, C](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) if (x == 0) => f(x, z)
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def length[A](as: List[A]): Int = {
    foldRight(as, 0)((x, y) => y + 1)
  }

  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) if (x == 0) => f(z, x)
      case Cons(x, xs) => f(foldLeft(xs, z)(f), x)
    }
  }


}
