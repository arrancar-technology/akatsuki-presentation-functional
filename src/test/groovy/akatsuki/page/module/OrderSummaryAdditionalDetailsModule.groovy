package akatsuki.page.module

class OrderSummaryAdditionalDetailsModule extends FormModule {

  static content = {
    numberOfCopies { $('.numberOfCopies') }
    apostilledCopies { $('.apostilledCopies') }
    phone { $('.phone') }
    address1 { $('.address-1') }
    address2 { $('.address-2') }
    city { $('.city') }
    postcode { $('.postcode') }
    country { $('.country') }
  }
}
