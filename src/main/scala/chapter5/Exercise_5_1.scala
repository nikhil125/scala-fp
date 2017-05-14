package chapter5

object Exercise_5_1 {
  def main(ar:Array[String]): Unit = {
    val list: Stream[Int] = Stream(1,2,3,4,5);
    println(list.toList)

  }
}
