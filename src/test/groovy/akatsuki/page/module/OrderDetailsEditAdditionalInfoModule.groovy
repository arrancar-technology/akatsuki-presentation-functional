package akatsuki.page.module

class OrderDetailsEditAdditionalInfoModule extends FormModule {

  static content = {
    firstName { module InputTextFieldModule, $('#first-name') }
    lastName { module InputTextFieldModule, $('#last-name') }
    email { module InputTextFieldModule, $('#email') }

    address1 { module InputTextFieldModule, $('#address-1') }
    address2 { module InputTextFieldModule, $('#address-2') }
    city { module InputTextFieldModule, $('#city') }
    postcode { module InputTextFieldModule, $('#postcode') }
    country { module InputTextFieldModule, $('#country') }
    phone { module InputTextFieldModule, $('#phone') }
  }
}
