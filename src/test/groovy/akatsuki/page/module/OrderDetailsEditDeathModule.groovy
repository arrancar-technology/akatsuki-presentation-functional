package akatsuki.page.module

class OrderDetailsEditDeathModule extends OrderDetailsEditBaseModule {

  static content = {
    status { module InputDateModule, $('.status') }
    dateOfDeath { module InputDateModule, $('.date-of-death-container') }
    placeOfDeath { module InputTextFieldModule, $('#place-of-death') }
    lastNameAtDeath { module InputTextFieldModule, $('#last-name-at-death') }
    firstNameAtDeath { module InputTextFieldModule, $('#first-name-at-death') }
  }

  def validateCertificateDetails() {
    waitFor { status.text() == 'paid' }
    dateOfDeath.text() == '11 / \n11 / \n2083'
    assert placeOfDeath.text() == 'London'
    assert lastNameAtDeath.text() == 'Haptism'
    assert firstNameAtDeath.text() == 'Allelujah'

    assert eventCountry.text() == 'Scotland'
    assert serviceType.text() == 'prime'
    assert numberOfCertificateCopies.text() == '3'
    assert numberOfApostilledCopies.text() == '1'

    return true
  }
}
