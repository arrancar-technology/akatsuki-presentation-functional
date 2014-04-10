package akatsuki.page.module

class OrderDetailsEditBirthModule extends OrderDetailsEditBaseModule {

  static content = {
    status { module InputDateModule, $('.status') }
    dateOfBirth { module InputDateModule, $('.date-of-birth-container') }
    placeOfBirth { module InputTextFieldModule, $('#place-of-birth') }
    lastNameAtBirth { module InputTextFieldModule, $('#last-name-at-birth') }
    firstNameAtBirth { module InputTextFieldModule, $('#first-name-at-birth') }
    motherMaidenName { module InputTextFieldModule, $('#mother-maiden-name') }
    motherFirstName { module InputTextFieldModule, $('#mother-first-name') }
    fatherLastName { module InputTextFieldModule, $('#father-last-name') }
    fatherFirstName { module InputTextFieldModule, $('#father-first-name') }
  }

  def validateCertificateDetails() {
    waitFor { status.text() == 'paid' }
    assert dateOfBirth.text() == '2 / \n7 / \n1981'
    assert placeOfBirth.text() == 'London'
    assert lastNameAtBirth.text() == 'Erde'
    assert firstNameAtBirth.text() == 'Tieria'
    assert motherMaidenName.text() == "Regetta"
    assert motherFirstName.text() == "Regene"
    assert fatherLastName.text() == "Almark"
    assert fatherFirstName.text() == "Ribbons"

    assert eventCountry.text() == 'Republic of Ireland'
    assert serviceType.text() == 'rapid'
    assert numberOfCertificateCopies.text() == '2'
    assert numberOfApostilledCopies.text() == '1'

    return true
  }
}
