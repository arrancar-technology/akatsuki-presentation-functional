package akatsuki.page

import akatsuki.page.module.FormDetailsAdditionalModule
import akatsuki.page.module.FormDetailsPaymentModule
import akatsuki.page.module.OrderSummaryContainerModule
import akatsuki.page.module.ProgressTrackerModule

abstract class CertificateBasePage extends BasePage {

  abstract def getOrderSummaryDetailsModuleForCertificate()

  static content = {
    progressTracker { module ProgressTrackerModule, $('.progress-tracker-container')}
    orderSummary { module OrderSummaryContainerModule, $('.order-summary-details-container'), certificateDetailsModule: orderSummaryDetailsModuleForCertificate }

    formAdditional { module FormDetailsAdditionalModule, $('.step.second') }
    formPayment { module FormDetailsPaymentModule, $('.step.third') }
  }

  def populateAdditionalDetails() {
    formAdditional.firstName = 'Lockon'
    formAdditional.lastName = 'Stratos'
    formAdditional.email = 'lockon.stratos@example.com'
    formAdditional.address.address1 = 'Station Parade'
    formAdditional.address.address2 = 'Kobe Road'
    formAdditional.address.city = 'Tokyo'
    formAdditional.address.postcode = 'W8 9DF'
    formAdditional.address.country = 'Japan'
    formAdditional.address.phone = '07517158978'
  }

  def populatePaymentDetails(values = [:]) {
    def valuesDefault = [
      cardNumber: "4242424242424242",
      month: 'July',
      year: '2020',
      cardVerificationNumber: '123'
    ]
    valuesDefault.putAll(values)

    formPayment.cardNumber = valuesDefault.cardNumber
    formPayment.expiryDate.month = valuesDefault.month
    formPayment.expiryDate.year = valuesDefault.year
    formPayment.cardVerificationNumber = valuesDefault.cardVerificationNumber
  }
}
