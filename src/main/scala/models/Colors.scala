package models

case class Colors(contrastText: String, mainBackground: String,
                  primary: String, secondary: String,
                  success: String, wrong: String) {

  def toBean: ColorsClass = new ColorsClass(contrastText, mainBackground, primary, secondary, success, wrong)
}
