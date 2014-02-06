package akatsuki.page.module

class FormAdditionalDetailsModule extends FormModule {
  static content = {
    firstName { module InputTextFieldModule, $('#first-name') }
    lastName { module InputTextFieldModule, $('#last-name') }
    email { module InputTextFieldModule, $('#email') }
    address { module FormAddressDetailsModule, $('form[name="address_form"]') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
