package jsonSerialization

import jsonSerialization.SimpleTypesToJson._

object MonadsToJson {

  implicit class JsonOpsFunctor[T[_], S : JsonConverter](value: T[S]) {
    def functorToJson(implicit jsonFunctor: JsonFunctor[T]): JsonValue = jsonFunctor.converter(value)
  }

  implicit object FunctorArray extends JsonFunctor[List] {
    override def converter[S : JsonConverter](value: List[S]): JsonValue =
      value.map(_.toJson).toJson
  }

  implicit object FunctorOption extends JsonFunctor[Option] {
    override def converter[S : JsonConverter](value: Option[S]): JsonValue =
      value match {
        case Some(value) => value.toJson
        case None => StringToJson("null")
      }
  }

}
