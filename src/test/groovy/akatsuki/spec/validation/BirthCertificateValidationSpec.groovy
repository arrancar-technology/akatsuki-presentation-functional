package akatsuki.spec.validation

import akatsuki.page.BirthCertificatePage
import akatsuki.spec.BaseSpecification

class BirthCertificateValidationSpec extends BaseSpecification {

  def "birth certificate form has correct validations"() {
    given:
      toAt BirthCertificatePage

    when:
      formBirth.stepNavigation.nextButton.click()

    then:
      formBirth.dateOfBirth.error.isTrue()
      formBirth.dateOfBirth.day.error.isTrue()
      formBirth.dateOfBirth.month.error.isTrue()
      formBirth.dateOfBirth.year.error.isTrue()
      formBirth.placeOfBirth.error.isTrue()
      formBirth.lastNameAtBirth.error.isTrue()
      formBirth.firstNameAtBirth.error.isTrue()

    when:
      interact { moveToElement(formBirth.dateOfBirth) }
      formBirth.dateOfBirth.year.click()

    then:
      formBirth.dateOfBirth.year.error.message.text() == 'Please enter year of birth in YYYY format'

    when:
      formBirth.dateOfBirth.day = '3'
      formBirth.dateOfBirth.month = 'July'
      formBirth.dateOfBirth.year = '1981'

    then:
      !formBirth.dateOfBirth.error.isTrue()
      !formBirth.dateOfBirth.day.error.isTrue()
      !formBirth.dateOfBirth.month.error.isTrue()
      !formBirth.dateOfBirth.year.error.isTrue()

    when:
      formBirth.placeOfBirth.click()

    then:
      formBirth.placeOfBirth.error.message.text() == 'Please enter place of birth'

    when:
      formBirth.lastNameAtBirth.click()

    then:
      formBirth.lastNameAtBirth.error.message.text() == 'Please enter last name at birth'

    when:
      formBirth.firstNameAtBirth.click()

    then:
      formBirth.firstNameAtBirth.error.message.text() == 'Please enter first name at birth'
  }
}
