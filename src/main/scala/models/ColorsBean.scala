package models

import java.beans.BeanProperty

class ColorsBean() {

  @BeanProperty var contrastText: String = _
  @BeanProperty var mainBackground: String = _
  @BeanProperty var primary: String = _
  @BeanProperty var secondary: String = _
  @BeanProperty var success: String = _
  @BeanProperty var wrong: String = _

  def toCase: Colors = {
    Colors(contrastText, mainBackground,
      primary, secondary, success, wrong)
  }

  def withContrastText(contrastText: String): ColorsBean = {
    this.contrastText = contrastText
    this
  }
  def withMainBackground(mainBackground: String): ColorsBean = {
    this.mainBackground = mainBackground
    this
  }
  def withPrimary(primary: String): ColorsBean = {
    this.primary = primary
    this
  }
  def withSecondary(secondary: String): ColorsBean = {
    this.secondary = secondary
    this
  }
  def withSuccess(success: String): ColorsBean = {
    this.success = success
    this
  }
  def withWrong(wrong: String): ColorsBean = {
    this.wrong = wrong
    this
  }
}
