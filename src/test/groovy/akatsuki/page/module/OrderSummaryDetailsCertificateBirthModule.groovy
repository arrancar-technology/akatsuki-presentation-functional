package akatsuki.page.module

class OrderSummaryDetailsCertificateBirthModule extends OrderSummaryDetailsCertificateBaseModule {

  static content = {
    dateOfBirth { $('.dateOfBirth') }
    placeOfBirth { $('.placeOfBirth') }
    lastNameAtBirth { $('.lastNameAtBirth') }
    firstNameAtBirth { $('.firstNameAtBirth') }
    motherMaidenName { $('.motherMaidenName') }
    motherFirstName { $('.motherFirstName') }
    fatherLastName { $('.fatherLastName') }
    fatherFirstName { $('.fatherFirstName') }
  }
}
