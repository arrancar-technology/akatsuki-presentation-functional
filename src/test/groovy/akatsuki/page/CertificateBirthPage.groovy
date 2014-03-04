package akatsuki.page

import akatsuki.page.module.FormDetailsBirthModule
import akatsuki.page.module.OrderSummaryDetailsCertificateBirthModule
import akatsuki.path.PathPresentation

class CertificateBirthPage extends CertificateBasePage {

  def getOrderSummaryDetailsModuleForCertificate() {
    return OrderSummaryDetailsCertificateBirthModule
  }

  static url = PathPresentation.CERTIFICATE_BIRTH
  static at = { title == "UK Official Certificate - Birth Certificate" }

  static content = {
    formBirth { module FormDetailsBirthModule, $('.step.first') }
  }

  def populateBirthDetails() {
    formBirth.dateOfBirth.day = '1' // 0 indexed
    formBirth.dateOfBirth.month = 'July'
    formBirth.dateOfBirth.year = '1981'
    formBirth.placeOfBirth = 'London'
    formBirth.lastNameAtBirth = 'Erde'
    formBirth.firstNameAtBirth = 'Tieria'
    formBirth.motherMaidenName = 'Regetta'
    formBirth.motherFirstName = 'Regene'
    formBirth.fatherLastName = 'Almark'
    formBirth.fatherFirstName = 'Ribbons'
    formBirth.serviceType = '1'
    formBirth.numberOfCertificateCopies = '1'
    formBirth.numberOfApostilledCopies = '1'
  }
}
