package akatsuki.page.module

class OrderSummaryContainerModule extends FormModule {

  def certificateDetailsModule

  static content = {
    certificateDetails { module certificateDetailsModule, $('.certificate-details-container') }
    additionalDetails { module OrderSummaryAdditionalDetailsModule, $('.additional-details-container') }
    paymentDetails { module OrderSummaryPaymentDetailsModule, $('.payment-details-container') }
  }
}
