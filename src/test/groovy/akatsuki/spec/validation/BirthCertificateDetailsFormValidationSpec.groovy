package akatsuki.spec.validation

import akatsuki.page.BirthCertificatePage
import akatsuki.spec.BaseSpecification

class BirthCertificateDetailsFormValidationSpec extends BaseSpecification {

  def "birth details form has correct validations"() {
    given:
      toAt BirthCertificatePage

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

    when:
      formBirth.placeOfBirth.click()

    then:
      formBirth.placeOfBirth.error.message.text() == 'Please enter place of birth'

    when:
      formBirth.placeOfBirth = 'London'

    then:
      formBirth.placeOfBirth.isSuccess()

    when:
      formBirth.lastNameAtBirth.click()

    then:
      formBirth.lastNameAtBirth.error.message.text() == 'Please enter last name at birth'

    when:
      formBirth.lastNameAtBirth = 'Erde'

    then:
      formBirth.lastNameAtBirth.isSuccess()

    when:
      formBirth.firstNameAtBirth.click()

    then:
      formBirth.firstNameAtBirth.error.message.text() == 'Please enter first name at birth'

    when:
      formBirth.firstNameAtBirth = 'Tieria'

    then:
      formBirth.firstNameAtBirth.isSuccess()

    when:
      formBirth.numberOfApostilledCopies = '1'

    then:
      formBirth.numberOfApostilledCopies.isSuccess()
  }
}
