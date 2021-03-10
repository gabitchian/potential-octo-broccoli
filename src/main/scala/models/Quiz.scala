package models

case class Quiz(background: String, description: String, icon: String, theme: Theme, title: String) {

  def toBean: QuizClass = new QuizClass(background, description, icon, theme, title)
}
