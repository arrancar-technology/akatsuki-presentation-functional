package akatsuki.page

import akatsuki.path.PathPresentation

class ErrorInternalServerPage extends BasePage {

  static url = PathPresentation.ERROR_INTERNAL_SERVER

  static at = {
    title == "Simply Certificate"
  }

  static content = {
    pageContent { $(".container") }
  }
}
