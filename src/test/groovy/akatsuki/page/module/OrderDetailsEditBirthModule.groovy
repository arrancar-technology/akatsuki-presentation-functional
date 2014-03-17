package akatsuki.page.module

class OrderDetailsEditBirthModule extends OrderDetailsEditBaseModule {

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

  def validateCertificateDetails() {
    waitFor { dateOfBirth.text() == 'Date of Birth\n2 / \n7 / \n1981' }
    assert placeOfBirth.text() == 'Place of Birth\nLondon'
    assert lastNameAtBirth.text() == 'Last Name at Birth\nErde'
    assert firstNameAtBirth.text() == 'First Name at Birth\nTieria'
    assert motherMaidenName.text() == "Mother's Maiden Name\nRegetta"
    assert motherFirstName.text() == "Mother's First Name\nRegene"
    assert fatherLastName.text() == "Father's Last Name\nAlmark"
    assert fatherFirstName.text() == "Father's First Name\nRibbons"
    assert eventCountry.text() == 'Country of Event\nRepublic of Ireland'
    assert serviceType.text() == 'Service Type\nrapid'
    assert numberOfCopies.text() == 'Number of Copies\n2'
    assert apostilledCopies.text() == 'Apostilled Copies\n--'

    return true
  }
}
