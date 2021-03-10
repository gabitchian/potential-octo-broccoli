package models

case class Colors(contrastText: String, mainBackground: String,
                  primary: String, secondary: String,
                  success: String, wrong: String) {

  def toBean: ColorsBean = new ColorsBean(contrastText, mainBackground, primary, secondary, success, wrong)
}
