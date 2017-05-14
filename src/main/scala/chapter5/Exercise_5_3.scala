package chapter5

object Exercise_5_3 {
  def main(ar:Array[String]): Unit = {
    val list: Stream[Int] = Stream(1,2,3,4,5);
    println(list.drop(2).toList)
    println(list.drop(1))
    println(list.drop(0))

  }
}
