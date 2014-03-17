package akatsuki.page.module

import geb.Module

class OrderDetailsEditDeathModule extends Module {

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
