package akatsuki.page.module

class FormDetailsPaymentModule extends FormModule {

  static content = {
    cardNumber { module InputTextFieldModule, $('#card-number') }
    expiryDate { module InputDateMonthYearModule, $('.expiry-date') }
    cardVerificationNumber { module InputTextFieldModule, $('#card-verification-number') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
