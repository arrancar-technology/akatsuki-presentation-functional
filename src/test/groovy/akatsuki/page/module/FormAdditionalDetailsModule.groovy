package akatsuki.page.module

class FormAdditionalDetailsModule extends FormModule {
  static content = {
    numberOfCertificateCopies { module InputDropdownModule, $('#number-of-copies') }
    numberOfApostilledCopies { module InputDropdownModule, $('#number-of-apostilles') }
    address { module FormAddressDetailsModule, $('form[name="address_form"]') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
