package models

case class Colors(contrastText: String, mainBackground: String,
                  primary: String, secondary: String,
                  success: String, wrong: String) {

  def toBean: ColorsBean = {
    new ColorsBean()
      .withContrastText(contrastText)
      .withMainBackground(mainBackground)
      .withPrimary(primary)
      .withSecondary(secondary)
      .withSuccess(success)
      .withWrong(wrong)
  }
}
