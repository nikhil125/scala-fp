package chapter5

object Exercise_5_7 {
  def main(ar:Array[String]): Unit = {
    val list: Stream[Int] = Stream(6,1,2,3,4,5);
    println(list.toList)
    println(list.map(_+10).toList)
    println(list.filter( (a :Int) => (a % 2) == 0).toList)
    println(list.append(Stream(7,8)).toList)
  }
}
