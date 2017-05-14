package chapter3
/*
Can product, implemented using foldRight, immediately halt the recursion and return 0.0 if it encounters a 0.0? Why
or why not? Consider how any short-circuiting might work if you call foldRight with a large list.
This is a deeper question that we’ll return to in chapter 5.
 */
object Exercise_3_7 {
	def main(ar: Array[String]): Unit = {
		val list : List[Double] = List(1,2,3,0,5,6)
		println(List.product2(list))
	}
}
