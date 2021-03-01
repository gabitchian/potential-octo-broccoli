package jsonSerialization

import java.time.LocalDate

object SimpleTypesToJson {

  implicit class JsonOps[T](value: T) {
    def toJson(implicit jsonConverter: JsonConverter[T]): JsonValue = jsonConverter.converter(value)
  }

  final case class StringToJson(value: String) extends JsonValue {
    override def stringify: String = if (value != "null") "\"" + value + "\"" else "null"
  }
  implicit object StringToJson extends JsonConverter[String] {
    override def converter(value: String): JsonValue = StringToJson(value)
  }

  final case class IntToJson(value: Int) extends JsonValue {
    override def stringify: String = value.toString
  }
  implicit object IntToJson extends JsonConverter[Int] {
    override def converter(value: Int): JsonValue = IntToJson(value)
  }

  final case class LocalDateToJson(value: LocalDate) extends JsonValue {
    override def stringify: String = value.toString
  }
  implicit object LocalDateToJson extends JsonConverter[LocalDate] {
    override def converter(value: LocalDate): JsonValue = LocalDateToJson(value)
  }

  final case class ArrayToJson(list: List[JsonValue]) extends JsonValue {
    override def stringify: String = list.map(_.stringify).mkString("[", ",", "]")
  }
  implicit object ArrayToJson extends JsonConverter[List[JsonValue]] {
    override def converter(value: List[JsonValue]): JsonValue = ArrayToJson(value)
  }

  final case class ObjectToJson(values: Map[String, JsonValue]) extends JsonValue {
    override def stringify: String = values.map {
      case (key, value) => key.toJson.stringify + ":" + value.stringify
    }.mkString("\n{", ",\n", "\n}")
  }
  implicit object ObjectToJson extends JsonConverter[Map[String, JsonValue]] {
    override def converter(value: Map[String, JsonValue]): JsonValue = ObjectToJson(value)
  }

}
