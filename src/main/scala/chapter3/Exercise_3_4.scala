package chapter3


object Exercise_3_4 {
	def main(ar: Array[String]): Unit = {
		val list : List[Int] = List(1,2,3,4,5,6)
		println(List.drop (list, 2))
		println(List.dropWhile(list, (d :Int) => d < 3))
	}
}
