package models

import java.beans.BeanProperty

class ThemeBean() {

  @BeanProperty var borderRadius: String = _
  @BeanProperty var colors: Colors = _

  def toCase: Theme = {
    Theme(borderRadius, colors)
  }

  def withBorderRadius(borderRadius: String): ThemeBean = {
    this.borderRadius = borderRadius
    this
  }

  def withColors(colors: Colors): ThemeBean = {
    this.colors = colors
    this
  }

}
