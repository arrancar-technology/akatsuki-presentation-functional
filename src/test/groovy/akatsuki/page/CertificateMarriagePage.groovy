package akatsuki.page

import akatsuki.page.module.*
import akatsuki.path.PathPresentation

class CertificateMarriagePage extends CertificateBasePage {

  def getOrderSummaryDetailsModuleForCertificate() {
    return OrderSummaryDetailsCertificateMarriageModule
  }

  static url = PathPresentation.CERTIFICATE_MARRIAGE
  static at = { title == "UK Official Certificate - Marriage Certificate" }

  static content = {
    formMarriage { module FormDetailsMarriageModule, $('.step.first') }
  }

  def populateMarriageDetails() {
    formMarriage.dateOfMarriage.day = '1' // 0 indexed
    formMarriage.dateOfMarriage.month = 'July'
    formMarriage.dateOfMarriage.year = '1981'
    formMarriage.placeOfMarriage = 'London'
    formMarriage.lastNameAtMarriage = 'Erde'
    formMarriage.firstNameAtMarriage = 'Tieria'
    formMarriage.motherMaidenName = 'Regetta'
    formMarriage.motherFirstName = 'Regene'
    formMarriage.fatherLastName = 'Almark'
    formMarriage.fatherFirstName = 'Ribbons'
    formMarriage.serviceType = '1'
    formMarriage.numberOfCertificateCopies = '1'
    formMarriage.numberOfApostilledCopies = '1'
  }
}
