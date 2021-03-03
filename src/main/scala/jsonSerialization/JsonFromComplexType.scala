package jsonSerialization

trait JsonFromComplexType[C[_]] {
  def converter[S: JsonFromSimpleType](value: C[S]): JsonValue
}