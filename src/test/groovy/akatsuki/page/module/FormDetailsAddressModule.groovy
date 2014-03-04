package akatsuki.page.module

class FormDetailsAddressModule extends FormModule {

  static content = {
    address1 { module InputTextFieldModule, $('#address-1') }
    address2 { module InputTextFieldModule, $('#address-2') }
    city { module InputTextFieldModule, $('#city') }
    postcode { module InputTextFieldModule, $('#postcode') }
    country { module InputDropdownModule, $('#country') }
    phone { module InputTextFieldModule, $('#phone') }
  }
}
