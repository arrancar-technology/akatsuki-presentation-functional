package akatsuki.page.module

class OrderSummaryContainerModule extends FormModule {

  def certificateDetailsModule

  static content = {
    certificateDetails { module certificateDetailsModule, $('.certificate-details-container') }
    additionalDetails { module OrderSummaryDetailsAdditionalModule, $('.additional-details-container') }
    paymentDetails { module OrderSummaryDetailsPaymentModule, $('.payment-details-container') }
  }
}
