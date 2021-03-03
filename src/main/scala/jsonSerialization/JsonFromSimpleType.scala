package jsonSerialization

trait JsonFromSimpleType[T] {
  def converter(value: T): JsonValue
}
