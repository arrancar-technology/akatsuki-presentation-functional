package akatsuki.page.module

class OrderSummaryPaymentDetailsModule extends FormModule {

  static content = {
    cardType { $('.cardType') }
    cardholderName { $('.cardholderName') }
    cardNumber { $('.cardNumber') }
    expiryDate { $('.expiryDate') }
    cardVerificationNumber { $('.cardVerificationNumber') }
  }
}
