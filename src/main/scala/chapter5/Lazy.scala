package chapter5

import scala.annotation.tailrec


class Lazy {


}

sealed trait Stream[+A] {
	def toList: List[A]

	def take(n: Int): Stream[A]

	def drop(n: Int): Stream[A]

	def exists(p: A => Boolean): Boolean = {
		foldRight(false)((a, b) => p(a) || b)
	}

	def forAll(p: A => Boolean): Boolean = {
		this match {
			case Cons(h, t) => p(h()) && t().forAll(p)
		}
	}

	def foldRight[B](z: => B)(f: (A, => B) => B): B = {
		this match {
			case Empty => z
			case Cons(h, t) => f(h(), t().foldRight(z)(f))
		}
	}

	def takeWhile(f: A => Boolean): Stream[A] = {
		this match {
			case Empty => Stream.empty[A]
			case Cons(h, t) if (f(h())) => Stream.cons(h(), t().takeWhile(f))
			case Cons(h, t) if (!f(h())) => t().takeWhile(f)

		}
	}

	def headOption: Option[A] = {
		foldRight(Option.empty[A])((a, b) => Option[A](a))
	}

	def map[B](f: A => B): Stream[B] = {
		foldRight(Stream.empty[B])((a, b) => Stream.cons(f(a), b))
	}

	def filter(f: A => Boolean): Stream[A] = {
		foldRight(Stream.empty[A])((a, b) => if (f(a)) Stream.cons(a, b) else b.filter(f))
	}

	def append[B >: A](that: Stream[B]): Stream[B] = {
		this match {
			case Empty => that
			case Cons(h, t) => Stream.cons(h(), t().append(that))
		}
	}

	def find(p: A => Boolean): Option[A] = {
		filter(p).headOption
	}

	def constant[A](a: A): Stream[A] = {
		Stream.cons(a, Stream.apply(a).constant(a))
	}

	def from(n: Int): Stream[Int] = {
		Stream.cons(n, from(n+1))
	}
}

case object Empty extends Stream[Nothing] {
	def toList = List.empty

	def take(n: Int) = Stream.empty

	def drop(n: Int) = Stream.empty


}

case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A] {

	def toList: List[A] = {
		val head: List[A] = List(h())
		val tail: Stream[A] = t()

		@tailrec
		def loop[A](result: List[A], tail: Stream[A]): List[A] = {
			tail match {
				case Empty => result

				case Cons(x, xs) => loop(result ::: List(x()), xs())
			}
		}

		loop(head, tail)
	}

	def take(n: Int): Stream[A] = {
		if (n <= 0) Stream.empty
		else if (n == 1) Stream.cons[A](h(), Stream.empty[A])
		else Stream.cons[A](h(), t().take(n - 1))
	}

	def drop(n: Int): Stream[A] = {
		if (n <= 0) this
		else if (n == 1) t()
		else t().drop(n - 1)
	}

	override def toString: String = this.toList.toString()
}

object Stream {
	def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
		lazy val head = hd
		lazy val tail = tl
		Cons(() => head, () => tail)
	}

	def empty[A]: Stream[A] = Empty

	def apply[A](as: A*): Stream[A] = {
		if (as.isEmpty)
			empty
		else
			cons(as.head, apply(as.tail: _*))
	}


}
