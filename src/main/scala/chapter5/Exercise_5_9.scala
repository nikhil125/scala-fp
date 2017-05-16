package chapter5

object Exercise_5_9 {
  def main(ar:Array[String]): Unit = {
    val list: Stream[Int] = Stream(6,1,2,3,4,5);
    println(list.from(4).take(7).toList)

  }
}
