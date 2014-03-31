package akatsuki.page

import akatsuki.page.module.*
import akatsuki.path.PathPresentation

class CertificateMarriagePage extends CertificateBasePage {

  def getOrderSummaryDetailsModuleForCertificate() {
    return OrderSummaryDetailsCertificateMarriageModule
  }

  static url = PathPresentation.CERTIFICATE_MARRIAGE
  static at = { title == "Simply Certificate - Marriage Certificate" }

  static content = {
    formMarriage { module FormDetailsMarriageModule, $('.step.first') }
  }

  def populateMarriageDetails() {
    formMarriage.dateOfMarriage.day = '1' // 0 indexed
    formMarriage.dateOfMarriage.month = 'July'
    formMarriage.dateOfMarriage.year = '1980'
    formMarriage.placeOfMarriage = 'London'
    formMarriage.womanLastName = 'Ismail'
    formMarriage.womanFirstName = 'Marina'
    formMarriage.manLastName = 'Seiei'
    formMarriage.manFirstName = 'Setsuna F.'
    formMarriage.eventCountry = 'North Ireland'
    formMarriage.serviceType = '2'
    formMarriage.numberOfCertificateCopies = '2'
    formMarriage.numberOfApostilledCopies = '1'
  }
}
