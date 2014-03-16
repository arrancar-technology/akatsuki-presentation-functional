package akatsuki.page.module

class FormDetailsBaseModule extends FormModule {

  static content = {
    eventCountry { module InputDropdownModule, $('#event-country') }
    serviceType { module InputDropdownModule, $('#service-type') }
    numberOfCertificateCopies { module InputDropdownModule, $('#number-of-copies') }
    numberOfApostilledCopies { module InputDropdownModule, $('#number-of-apostilles') }
  }
}
