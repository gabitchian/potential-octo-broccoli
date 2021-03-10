package models

class QuizBean(background: String, description: String, icon: String, theme: Theme, title: String) {

  def this() = this("", "", "", null, "")

  def toCase: Quiz = Quiz(background, description, icon, theme, title)
}
