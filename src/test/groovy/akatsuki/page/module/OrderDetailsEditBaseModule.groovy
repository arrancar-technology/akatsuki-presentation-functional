package akatsuki.page.module

class OrderDetailsEditBaseModule extends FormModule {

  static content = {
    eventCountry { module InputTextFieldModule, $('#event-country') }
    serviceType { module InputTextFieldModule, $('#service-type') }
    numberOfCertificateCopies { module InputTextFieldModule, $('#number-of-copies') }
    numberOfApostilledCopies { module InputTextFieldModule, $('#number-of-apostilles') }

    additionalInfoDetails { module OrderDetailsEditAdditionalInfoModule }
  }

  def validateAdditionalInfoDetails() {
    assert additionalInfoDetails.firstName.text() == 'Lockon'
    assert additionalInfoDetails.lastName.text() == 'Stratos'
    assert additionalInfoDetails.email.text() == 'lockon.stratos@gmail.com'
    assert additionalInfoDetails.address1.text() == 'Station Parade'
    assert additionalInfoDetails.address2.text() == 'Kobe Road'
    assert additionalInfoDetails.city.text() == 'Tokyo'
    assert additionalInfoDetails.postcode.text() == 'W8 9DF'
    assert additionalInfoDetails.country.text() == 'JP'
    assert additionalInfoDetails.phone.text() == '07157158989'

    return true
  }
}
