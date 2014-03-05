package akatsuki.page.module

class OrderSummaryDetailsCertificateBaseModule extends FormModule {

  static content = {
    serviceType { $('.serviceType') }
    numberOfCopies { $('.numberOfCopies') }
    apostilledCopies { $('.apostilledCopies') }
    total { $('.total') }
  }
}
