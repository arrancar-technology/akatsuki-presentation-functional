package akatsuki.page

import akatsuki.page.module.FormBirthModule
import akatsuki.path.PathPresentation

class BirthCertificatePage extends BasePage {

  static url = PathPresentation.CERTIFICATE_BIRTH
  static at = { title == "UK Birth Certificate" }

  static content = {
    formBirth { module FormBirthModule, $('.step.first') }
  }
}
