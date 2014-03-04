package akatsuki.page.module

class FormDetailsAdditionalModule extends FormModule {

  static content = {
    firstName { module InputTextFieldModule, $('#first-name') }
    lastName { module InputTextFieldModule, $('#last-name') }
    email { module InputTextFieldModule, $('#email') }
    address { module FormDetailsAddressModule, $('form[name="address_form"]') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
