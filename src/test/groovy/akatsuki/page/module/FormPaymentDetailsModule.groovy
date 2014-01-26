package akatsuki.page.module

class FormPaymentDetailsModule extends FormModule {
  static content = {
    email { module InputTextFieldModule, $('#email-address') }
    cardType { module InputDropdownModule, $('#card-type') }
    cardholderName { module InputTextFieldModule, $('#cardholder-name') }
    cardNumber { module InputTextFieldModule, $('#card-number') }
    expiryDate { module InputDateMonthYearModule, $('.expiry-date') }
    cardVerificationNumber { module InputTextFieldModule, $('#card-verification-number') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
