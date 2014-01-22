package akatsuki.spec.validation

import akatsuki.page.BirthCertificatePage
import akatsuki.spec.BaseSpecification

class BirthCertificateDetailsFormValidationSpec extends BaseSpecification {

  def "birth details form has correct validations"() {
    given:
      toAt BirthCertificatePage

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
      !formBirth.dateOfBirth.isError()
      !formBirth.dateOfBirth.day.isError()
      !formBirth.dateOfBirth.month.isError()
      !formBirth.dateOfBirth.year.isError()

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
      formBirth.lastNameAtBirth = 'Tieria'

    then:
      formBirth.lastNameAtBirth.isSuccess()

    when:
      formBirth.firstNameAtBirth.click()

    then:
      formBirth.firstNameAtBirth.error.message.text() == 'Please enter first name at birth'

    when:
      formBirth.firstNameAtBirth = 'Erde'

    then:
      formBirth.firstNameAtBirth.isSuccess()
  }
}
