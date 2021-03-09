package models

import java.beans.BeanProperty

class QuizBean() {

  @BeanProperty var background: String = _
  @BeanProperty var description: String = _
  @BeanProperty var icon: String = _
  @BeanProperty var theme: Theme = _
  @BeanProperty var title: String = _

  def toCase: Quiz = {
    Quiz(background, description, icon, theme, title)
  }

  def withBackground(background: String): QuizBean = {
    this.background = background
    this
  }

  def withDescription(description: String): QuizBean = {
    this.description = description
    this
  }

  def withIcon(icon: String): QuizBean = {
    this.icon = icon
    this
  }

  def withTheme(theme: Theme): QuizBean = {
    this.theme = theme
    this
  }

  def withTitle(title: String): QuizBean = {
    this.title = title
    this
  }

}
