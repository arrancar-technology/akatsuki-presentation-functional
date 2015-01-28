package akatsuki.page

import akatsuki.page.module.ArticleModule
import akatsuki.path.PathPresentation

class BlogLandingPage extends BasePage {

  static url = PathPresentation.LANDING_BLOG
  static at = {
    waitFor(10) { title == "Simply Certificate | Blog" }
  }

  static content = {
    pageTitle { $('h1') }
    articles { title -> moduleList ArticleModule, $("article") }
  }
}
