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
      formAdditional.numberOfApostilledCopies.isError()
      formAdditional.address.address1.isError()
      formAdditional.address.city.isError()
      formAdditional.address.postcode.isError()
      formAdditional.address.phone.isError()
  }
}
