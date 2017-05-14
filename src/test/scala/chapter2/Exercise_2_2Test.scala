package chapter2

import org.scalatest.FunSuite


class Exercise_2_2Test extends FunSuite {

  test("testIsSorted") {
    val testObj = new Exercise_2_2
    val result = testObj.isSorted[Int](Array(1,2,3,4), (a1, a2) => a1 <= a2)
    assert(result == true)
  }

  test("testIsSortedFalse") {
    val testObj = new Exercise_2_2
    val result = testObj.isSorted[Int](Array(1,5,3,4), (a1, a2) => a1 <= a2)
    assert(result == false)
  }

  test("testIsSortedBig") {
    val testObj = new Exercise_2_2
    val result = testObj.isSorted[Int](Range (1 , 100000).toArray, (a1, a2) => a1 <= a2)
    assert(result == true)
  }

}
