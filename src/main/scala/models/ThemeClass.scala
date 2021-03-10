package models

class ThemeClass(borderRadius: String, colors: Colors) {

  def this() = this("", null)

  def toCase: Theme = Theme(borderRadius, colors)
}
