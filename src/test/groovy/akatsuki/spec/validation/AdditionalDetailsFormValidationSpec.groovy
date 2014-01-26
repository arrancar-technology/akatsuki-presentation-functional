package akatsuki.spec.validation

import akatsuki.page.BirthCertificatePage
import akatsuki.spec.BaseSpecification

class AdditionalDetailsFormValidationSpec extends BaseSpecification {

  def "additional details form has correct validations"() {
    given:
      toAt BirthCertificatePage

    and:
      populateBirthDetails()
      formBirth.stepNavigation.nextButton.click()

    expect: // Check defaults
      formAdditional.numberOfCertificateCopies.text() == '1'
      formAdditional.numberOfApostilledCopies.text() == '-'
      formAdditional.address.country.text() == 'United Kingdom'

    when:
      formAdditional.stepNavigation.nextButton.click()

    then:
      formAdditional.numberOfCertificateCopies.isSuccess()
      formAdditional.numberOfApostilledCopies.isError()
      formAdditional.address.address1.isError()
      formAdditional.address.city.isError()
      formAdditional.address.country.isSuccess()
      formAdditional.address.postcode.isError()
      formAdditional.address.phone.isError()

    when:
      formAdditional.numberOfApostilledCopies = '1'

    then:
      formAdditional.numberOfApostilledCopies.isSuccess()

    when:
      formAdditional.address.address1.click()

    then:
      formAdditional.address.address1.error.message.text() == "Please enter your address"

    when:
      formAdditional.address.address1 = "Station Parade"

    then:
      formAdditional.address.address1.isSuccess()

    when:
      formAdditional.address.city.click()

    then:
      formAdditional.address.city.error.message.text() == "Please enter your city"

    when:
      formAdditional.address.city = "London"

    then:
      formAdditional.address.city.isSuccess()

    when:
      formAdditional.address.postcode.click()

    then:
      formAdditional.address.postcode.error.message.text() == "Please enter your postcode"

    when:
      formAdditional.address.postcode = "W8 9DF"

    then:
      formAdditional.address.postcode.isSuccess()

    when:
      formAdditional.address.phone.click()

    then:
      formAdditional.address.phone.error.message.text() == "Please enter your phone number"

    when:
      formAdditional.address.phone = "07157158989"

    then:
      formAdditional.address.phone.isSuccess()
  }
}
