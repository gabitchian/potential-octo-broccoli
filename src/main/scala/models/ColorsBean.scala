package models

import java.beans.BeanProperty

class ColorsBean(contrastText: String, mainBackground: String, primary: String, secondary: String, success: String, wrong: String) {

  def toCase: Colors = Colors(contrastText, mainBackground, primary, secondary, success, wrong)
}
