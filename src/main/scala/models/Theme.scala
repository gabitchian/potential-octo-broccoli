package models

case class Theme(borderRadius: String, colors: Colors) {

  def toBean: ThemeClass = {
    new ThemeClass(borderRadius, colors)
  }
}
