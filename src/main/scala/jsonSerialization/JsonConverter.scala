package jsonSerialization

trait JsonConverter[T] {
  def converter(value: T): JsonValue
}
