package akatsuki.page.module

class OrderSummaryBirthCertificateDetailsModule extends FormModule {

  static content = {
    dateOfBirth { $('.dateOfBirth') }
    placeOfBirth { $('.placeOfBirth') }
    lastNameAtBirth { $('.lastNameAtBirth') }
    firstNameAtBirth { $('.firstNameAtBirth') }
    motherMaidenName { $('.motherMaidenName') }
    motherFirstName { $('.motherFirstName') }
    fatherLastName { $('.fatherLastName') }
    fatherFirstName { $('.fatherFirstName') }
    numberOfCopies { $('.numberOfCopies') }
    apostilledCopies { $('.apostilledCopies') }
  }
}
