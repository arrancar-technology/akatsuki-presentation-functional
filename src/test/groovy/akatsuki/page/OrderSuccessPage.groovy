package akatsuki.page

import akatsuki.path.PathPresentation

class OrderSuccessPage extends BasePage {

  static url = PathPresentation.CERTIFICATE_SUCCESS
  static at = {
    waitFor(10) { title == "Simply Certificate - Order Success" }
  }

  static content = {
    successMessage { $('.row .col-md-8') }
  }
}
