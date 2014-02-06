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
      formAdditional.address.country.text() == 'United Kingdom'

    when:
      formAdditional.stepNavigation.nextButton.click()

    then:
      formAdditional.firstName.isError()
      formAdditional.lastName.isError()
      formAdditional.email.isError()
      formAdditional.address.address1.isError()
      formAdditional.address.city.isError()
      formAdditional.address.country.isSuccess()
      formAdditional.address.postcode.isError()
      formAdditional.address.phone.isError()

    when:
      formAdditional.firstName.click()

    then:
      formAdditional.firstName.error.message.text() == "Please enter your first name"

    when:
      formAdditional.firstName = "Lockon"

    then:
      formAdditional.firstName.isSuccess()

    when:
      formAdditional.lastName.click()

    then:
      formAdditional.lastName.error.message.text() == "Please enter your last name"

    when:
      formAdditional.lastName = "Stratos"

    then:
      formAdditional.lastName.isSuccess()

    when:
      formAdditional.email.click()

    then:
      formAdditional.email.error.message.text() == "Please enter your email address"

    when:
      formAdditional.email = "abc"

    then:
      formAdditional.email.isError()

    when:
      formAdditional.email = 'lockon.stratos@gmail.com'

    then:
      formAdditional.email.isSuccess()

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
