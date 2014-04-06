package akatsuki.page

import akatsuki.path.PathPresentation

class ErrorNotFoundPage extends BasePage {

  static url = PathPresentation.ERROR_NOT_FOUND
  static at = {
    title == "Simply Certificate"
  }

  static content = {
    pageContent { $(".container") }
  }
}
