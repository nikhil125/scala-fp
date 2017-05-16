package chapter5

object Exercise_5_8 {
  def main(ar:Array[String]): Unit = {
    val list: Stream[Int] = Stream(6,1,2,3,4,5);
    println(list.constant(1).take(7).toList)

  }
}
