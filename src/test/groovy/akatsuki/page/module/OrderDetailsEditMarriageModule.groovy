package akatsuki.page.module

class OrderDetailsEditMarriageModule extends OrderDetailsEditBaseModule {

  static content = {
    status { module InputDateModule, $('.status') }
    dateOfMarriage { module InputDateModule, $('.date-of-marriage-container') }
    placeOfMarriage { module InputTextFieldModule, $('#place-of-marriage') }
    womanLastName { module InputTextFieldModule, $('#woman-last-name') }
    womanFirstName { module InputTextFieldModule, $('#woman-first-name') }
    manLastName { module InputTextFieldModule, $('#man-last-name') }
    manFirstName { module InputTextFieldModule, $('#man-first-name') }
  }

  def validateCertificateDetails() {
    waitFor { status.text() == 'paid' }
    dateOfMarriage.text() == '2 / \n7 / \n1980'
    assert placeOfMarriage.text() == 'London'
    assert womanLastName.text() == 'Ismail'
    assert womanFirstName.text() == 'Marina'
    assert manLastName.text() == "Seiei"
    assert manFirstName.text() == "Setsuna F."

    assert eventCountry.text() == 'North Ireland'
    assert serviceType.text() == 'prime'
    assert numberOfCertificateCopies.text() == '3'
    assert numberOfApostilledCopies.text() == '1'

    return true
  }
}
