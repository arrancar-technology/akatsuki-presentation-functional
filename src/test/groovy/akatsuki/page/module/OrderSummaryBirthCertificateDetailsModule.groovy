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
    serviceType { $('.serviceType') }
    numberOfCopies { $('.numberOfCopies') }
    apostilledCopies { $('.apostilledCopies') }
    total { $('.total') }
  }
}
