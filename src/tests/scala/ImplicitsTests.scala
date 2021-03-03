import org.scalatest.flatspec.AnyFlatSpec

import jsonSerialization.SimpleTypesToJson._
import jsonSerialization.ComplexTypesToJson._

class ImplicitsTests extends AnyFlatSpec {

  "A list of integers" should "become a js-like array" in {
    assert(List(1, 2, 3).dataToJson.stringify == "[1,2,3]")
  }

  "A list of strings" should "become a js-like array" in {
    assert(List("teste1", "teste2", "teste3").dataToJson.stringify == """["teste1","teste2","teste3"]""")
  }

  "An Option" should "become either a 'null' or a number in json format" in {
    val someValue: Option[Int] = Some(1)
    val none: Option[Int] = None
    assert(someValue.dataToJson.stringify == "1")
    assert(none.dataToJson.stringify == "null")
  }

  "An Option" should "become either a 'null' or a string in json format" in {
    val someValue: Option[String] = Some("name")
    val none: Option[String] = None
    assert(someValue.dataToJson.stringify == """"name"""")
    assert(none.dataToJson.stringify == "null")
  }

}
