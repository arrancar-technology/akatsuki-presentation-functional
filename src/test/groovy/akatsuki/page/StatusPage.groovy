package akatsuki.page

import akatsuki.page.module.TableModule
import akatsuki.path.PathPresentation

class StatusPage extends BasePage {

  static url = PathPresentation.STATUS
  static at = {
    title == "akatsuki presentation admin"
    header.text() == "akatsuki presentation status"
  }

  static content = {
    header { $("h2") }

    status(required: false) { name -> module TableModule, $(".$name") }
  }
}
