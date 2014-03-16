package akatsuki.page.module

class OrderSummaryDetailsCertificateBaseModule extends FormModule {

  static content = {
    eventCountry { $('.eventCountry') }
    serviceType { $('.serviceType') }
    numberOfCopies { $('.numberOfCopies') }
    apostilledCopies { $('.apostilledCopies') }
    total { $('.total') }
  }
}
