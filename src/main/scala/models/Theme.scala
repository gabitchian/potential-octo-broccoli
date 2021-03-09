package models

case class Theme(borderRadius: String, colors: Colors) {

  def toBean: ThemeBean = {
    new ThemeBean()
      .withBorderRadius(borderRadius)
      .withColors(colors)
  }

}
