package chapter3

/*
See what happens when you pass Nil and Cons themselves to foldRight, like this:
foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_)) What do you think this says about the relationship between
foldRight and the data constructors of List?
 */
object Exercise_3_8 {
	def main(ar: Array[String]): Unit = {
		val list : List[Double] = List(1,2,3,0,5,6)
		println(List.foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_)))
	}
}
