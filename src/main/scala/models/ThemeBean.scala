package models

class ThemeBean(borderRadius: String, colors: Colors) {

  def this() = this("", null)

  def toCase: Theme = Theme(borderRadius, colors)
}
