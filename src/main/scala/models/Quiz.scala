package models

case class Quiz(background: String, description: String, icon: String, theme: Theme, title: String) {

  def toBean: QuizBean = {
    new QuizBean()
      .withBackground(background)
      .withDescription(description)
      .withIcon(icon)
      .withTheme(theme)
      .withTitle(title)
  }
}
