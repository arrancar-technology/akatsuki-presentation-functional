package akatsuki.page.module

class OrderSummaryPaymentDetailsModule extends FormModule {

  static content = {
    cardNumber { $('.cardNumber') }
    expiryDate { $('.expiryDate') }
    cardVerificationNumber { $('.cardVerificationNumber') }
  }
}
