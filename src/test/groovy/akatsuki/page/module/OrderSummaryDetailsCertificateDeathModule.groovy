package akatsuki.page.module

class OrderSummaryDetailsCertificateDeathModule extends OrderSummaryDetailsCertificateBaseModule {

  static content = {
    dateOfDeath { $('.dateOfDeath') }
    placeOfDeath { $('.placeOfDeath') }
    dateOfBirth { $('.dateOfBirth') }
    lastNameAtDeath { $('.lastNameAtDeath') }
    firstNameAtDeath { $('.firstNameAtDeath') }
  }
}
