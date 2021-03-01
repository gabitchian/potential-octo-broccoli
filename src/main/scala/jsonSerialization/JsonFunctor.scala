package jsonSerialization

trait JsonFunctor[C[_]] {
  def converter[S: JsonConverter](value: C[S]): JsonValue
}