package akatsuki.page

import akatsuki.path.PathPresentation

class OrderSuccessPage extends BasePage {

  static url = PathPresentation.CERTIFICATE_BIRTH
  static at = {
    waitFor(10) { title == "UK Official Certificate - Order Success" }
  }

  static content = {
    successMessage { $('p.lead') }
  }
}
