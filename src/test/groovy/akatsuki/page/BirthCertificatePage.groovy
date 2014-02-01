package akatsuki.page

import akatsuki.page.module.FormAdditionalDetailsModule
import akatsuki.page.module.FormBirthDetailsModule
import akatsuki.page.module.FormPaymentDetailsModule
import akatsuki.page.module.OrderSummaryBirthCertificateDetailsModule
import akatsuki.page.module.OrderSummaryContainerModule
import akatsuki.page.module.ProgressTrackerModule
import akatsuki.path.PathPresentation

class BirthCertificatePage extends BasePage {

  static url = PathPresentation.CERTIFICATE_BIRTH
  static at = { title == "UK Birth Certificate" }

  static content = {
    progressTracker { module ProgressTrackerModule, $('.progress-tracker-container')}
    orderSummary { module OrderSummaryContainerModule, $('.order-summary-details-container'), certificateDetailsModule: OrderSummaryBirthCertificateDetailsModule }

    formBirth { module FormBirthDetailsModule, $('.step.first') }
    formAdditional { module FormAdditionalDetailsModule, $('.step.second') }
    formPayment { module FormPaymentDetailsModule, $('.step.third') }
  }

  def populateBirthDetails() {
    formBirth.dateOfBirth.day = '1'
    formBirth.dateOfBirth.month = 'July'
    formBirth.dateOfBirth.year = '1981'
    formBirth.placeOfBirth = 'London'
    formBirth.lastNameAtBirth = 'Erde'
    formBirth.firstNameAtBirth = 'Tieria'
  }

  def populateAdditionalDetails() {
    formAdditional.numberOfCertificateCopies = '1'
    formAdditional.numberOfApostilledCopies = '0'
    formAdditional.address.country = 'United Kingdom'
    formAdditional.address.address1 = 'Station Parade'
    formAdditional.address.city = 'London'
    formAdditional.address.postcode = 'W8 9DF'
    formAdditional.address.phone = '07157158989'
  }

  def populatePaymentDetails() {
    formPayment.email = "tieria.erde@email.com"
    formPayment.cardType = "Visa Debit"
    formPayment.cardholderName = "M T Erde"
    formPayment.cardNumber = "4444333322221111"
    formPayment.expiryDate.month = 'July'
    formPayment.expiryDate.year = '2020'
    formPayment.cardVerificationNumber = '123'
  }
}
