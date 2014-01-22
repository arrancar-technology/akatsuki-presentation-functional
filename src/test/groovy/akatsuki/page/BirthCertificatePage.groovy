package akatsuki.page

import akatsuki.page.module.FormAdditionalDetailsModule
import akatsuki.page.module.FormBirthDetailsModule
import akatsuki.path.PathPresentation

class BirthCertificatePage extends BasePage {

  static url = PathPresentation.CERTIFICATE_BIRTH
  static at = { title == "UK Birth Certificate" }

  static content = {
    formBirth { module FormBirthDetailsModule, $('.step.first') }
    formAdditional { module FormAdditionalDetailsModule, $('.step.second') }
  }

  def populateBirthDetails() {
    formBirth.dateOfBirth.day = '1'
    formBirth.dateOfBirth.month = 'July'
    formBirth.dateOfBirth.year = '1981'
    formBirth.placeOfBirth = 'London'
    formBirth.lastNameAtBirth = 'Tieria'
    formBirth.firstNameAtBirth = 'Erde'
  }
}
