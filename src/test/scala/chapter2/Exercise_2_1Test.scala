package chapter2

import org.scalatest.FunSuite

class Exercise_2_1Test extends FunSuite {

  test("test small number fibonacci number" ) {
    val testObj = new Exercise_2_1

    val result = testObj.fib(2)

    assert(1 == result)
  }

  test("test number 3 fibonacci number" ) {
    val testObj = new Exercise_2_1

    val result = testObj.fib(3)

    assert(1 == result)
  }

  test("test number 5 fibonacci number" ) {
    val testObj = new Exercise_2_1

    val result = testObj.fib(5)

    assert(3 == result)
  }

  test("test number -1 fibonacci number" ) {
    val testObj = new Exercise_2_1

    val result = testObj.fib(-1)

    assert(0 == result)

  }

  test("test number 1111 fibonacci number" ) {
    val testObj = new Exercise_2_1

    val result = testObj.fib(1111)

    assert(67475912 == result)

  }
}
