package akatsuki.spec.validation

import akatsuki.page.CertificateBirthPage
import akatsuki.spec.BaseSpecification

class CertificateDetailsBirthFormValidationSpec extends BaseSpecification {

  def "birth details form has correct validations"() {
    given:
      toAt CertificateBirthPage

    expect: // Check defaults
      formBirth.numberOfCertificateCopies.text() == '1'
      formBirth.numberOfApostilledCopies.text() == '-- (£75 per stamp)'

    when:
      formBirth.stepNavigation.nextButton.click()

    then:
      formBirth.dateOfBirth.isError()
      formBirth.dateOfBirth.day.isError()
      formBirth.dateOfBirth.month.isError()
      formBirth.dateOfBirth.year.isError()
      formBirth.placeOfBirth.isError()
      formBirth.lastNameAtBirth.isError()
      formBirth.firstNameAtBirth.isError()
      formBirth.serviceType.isSuccess()
      formBirth.numberOfCertificateCopies.isSuccess()
      formBirth.numberOfApostilledCopies.isError()

    when:
      interact { moveToElement(formBirth.dateOfBirth) }
      formBirth.dateOfBirth.year.click()

    then:
      formBirth.dateOfBirth.year.error.message.text() == 'Please enter year of birth in YYYY format'

    when:
      formBirth.dateOfBirth.day = '1'
      formBirth.dateOfBirth.month = 'July'
      formBirth.dateOfBirth.year = '1981'

    then:
      formBirth.dateOfBirth.isSuccess()
      formBirth.dateOfBirth.day.isSuccess()
      formBirth.dateOfBirth.month.isSuccess()
      formBirth.dateOfBirth.year.isSuccess()

    and:
      checkErrorMessageAndValidate(formBirth, 'placeOfBirth', 'Please enter place of birth', 'London')
      checkErrorMessageAndValidate(formBirth, 'lastNameAtBirth', 'Please enter last name at birth', 'Erde')
      checkErrorMessageAndValidate(formBirth, 'firstNameAtBirth', 'Please enter first name at birth', 'Tieria')

    when:
      formBirth.numberOfApostilledCopies = '1'

    then:
      formBirth.numberOfApostilledCopies.isSuccess()
  }
}
