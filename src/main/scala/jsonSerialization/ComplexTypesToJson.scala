package jsonSerialization

import jsonSerialization.SimpleTypesToJson._

object ComplexTypesToJson {

  implicit class HighOrderTypeJsonOps[T[_], S : JsonFromSimpleType](value: T[S]) {
    def dataToJson(implicit jsonFunctor: JsonFromComplexType[T]): JsonValue = jsonFunctor.converter(value)
  }

  implicit object FromComplexTypeArray extends JsonFromComplexType[List] {
    override def converter[S : JsonFromSimpleType](value: List[S]): JsonValue =
      value.map(_.toJson).toJson
  }

  implicit object FromComplexTypeOption extends JsonFromComplexType[Option] {
    override def converter[S : JsonFromSimpleType](value: Option[S]): JsonValue =
      value match {
        case Some(value) => value.toJson
        case None => StringToJson("null")
      }
  }
}
