package akatsuki.page.module

class OrderSummaryDetailsCertificateDeathModule extends OrderSummaryDetailsCertificateBaseModule {

  static content = {
    dateOfDeath { $('.dateOfDeath') }
    placeOfDeath { $('.placeOfDeath') }
    lastNameAtDeath { $('.lastNameAtDeath') }
    firstNameAtDeath { $('.firstNameAtDeath') }
  }
}
