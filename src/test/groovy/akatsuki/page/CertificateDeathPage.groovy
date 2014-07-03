package akatsuki.page

import akatsuki.page.module.FormDetailsDeathModule
import akatsuki.page.module.OrderSummaryDetailsCertificateDeathModule
import akatsuki.path.PathPresentation

class CertificateDeathPage extends CertificateBasePage {

  def getOrderSummaryDetailsModuleForCertificate() {
    return OrderSummaryDetailsCertificateDeathModule
  }

  static url = PathPresentation.CERTIFICATE_DEATH
  static at = { title == "Simply Certificate - Death Certificate" }

  static content = {
    formDeath { module FormDetailsDeathModule, $('.step.first') }
  }

  def populateDeathDetails() {
    formDeath.dateOfDeath.day = '10' // 0 indexed
    formDeath.dateOfDeath.month = 'November'
    formDeath.dateOfDeath.year = '2083'
    formDeath.placeOfDeath = 'London'
    formDeath.dateOfBirth.day = '15' // 0 indexed
    formDeath.dateOfBirth.month = 'October'
    formDeath.dateOfBirth.year = '2000'
    formDeath.lastNameAtDeath = 'Haptism'
    formDeath.firstNameAtDeath = 'Allelujah'
    formDeath.eventCountry = 'Scotland'
    formDeath.serviceType = 'prime'
    formDeath.numberOfCertificateCopies = '2'
    formDeath.numberOfApostilledCopies = '1'
  }
}
