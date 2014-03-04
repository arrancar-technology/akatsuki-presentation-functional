package akatsuki.page.module

class OrderSummaryDetailsPaymentModule extends FormModule {

  static content = {
    cardNumber { $('.cardNumber') }
    expiryDate { $('.expiryDate') }
    cardVerificationNumber { $('.cardVerificationNumber') }
  }
}
