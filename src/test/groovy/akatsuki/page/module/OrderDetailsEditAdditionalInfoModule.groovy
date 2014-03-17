package akatsuki.page.module

class OrderDetailsEditAdditionalInfoModule extends OrderDetailsEditBaseModule {

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
