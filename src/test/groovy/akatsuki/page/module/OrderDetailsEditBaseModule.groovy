package akatsuki.page.module

class OrderDetailsEditBaseModule extends FormModule {

  static content = {
    eventCountry { $('.eventCountry') }
    serviceType { $('.serviceType') }
    numberOfCopies { $('.numberOfCopies') }
    apostilledCopies { $('.apostilledCopies') }
  }
}
