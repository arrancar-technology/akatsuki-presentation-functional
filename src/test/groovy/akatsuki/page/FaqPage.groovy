package akatsuki.page

import akatsuki.path.PathPresentation

class FaqPage extends BasePage {

  static url = PathPresentation.FAQ
  static at = { title == "Simply Certificate - Faq" }

}
