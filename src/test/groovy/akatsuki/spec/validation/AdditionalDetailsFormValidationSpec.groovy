package akatsuki.spec.validation

import akatsuki.page.CertificateBirthPage
import akatsuki.spec.BaseSpecification

class AdditionalDetailsFormValidationSpec extends BaseSpecification {

  def "additional details form has correct validations"() {
    given:
      toAt CertificateBirthPage

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

    and:
      checkErrorMessageAndValidate(formAdditional, 'firstName', 'Please enter your first name', 'Lockon')
      checkErrorMessageAndValidate(formAdditional, 'lastName', 'Please enter your last name', 'Stratos')

    when:
      formAdditional.email.click()

    then:
      waitFor { formAdditional.email.error.message.text() == "Please enter your email address" }

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
      waitFor { formAdditional.address.address1.error.message.text() == "Please enter your address" }

    when:
      formAdditional.address.address1 = "Station Parade"

    then:
      formAdditional.address.address1.isSuccess()

    when:
      formAdditional.address.city.click()

    then:
      waitFor { formAdditional.address.city.error.message.text() == "Please enter your city" }

    when:
      formAdditional.address.city = "London"

    then:
      formAdditional.address.city.isSuccess()

    when:
      formAdditional.address.postcode.click()

    then:
      waitFor { formAdditional.address.postcode.error.message.text() == "Please enter your postcode" }

    when:
      formAdditional.address.postcode = "W8 9DF"

    then:
      formAdditional.address.postcode.isSuccess()

    when:
      formAdditional.address.phone.click()

    then:
      waitFor { formAdditional.address.phone.error.message.text() == "Please enter your phone number" }

    when:
      formAdditional.address.phone = "07157158989"

    then:
      formAdditional.address.phone.isSuccess()
  }
}
