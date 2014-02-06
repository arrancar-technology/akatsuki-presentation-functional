package akatsuki.page.module

class OrderSummaryAdditionalDetailsModule extends FormModule {

  static content = {
    firstName { $('.firstName') }
    lastName { $('.lastName') }
    email { $('.email') }
    phone { $('.phone') }
    address1 { $('.address-1') }
    address2 { $('.address-2') }
    city { $('.city') }
    postcode { $('.postcode') }
    country { $('.country') }
  }
}
