package akatsuki.spec.validation

import akatsuki.page.CertificateDeathPage
import akatsuki.spec.BaseSpecification

class CertificateDetailsDeathFormValidationSpec extends BaseSpecification {

  def "death details form has correct validations"() {
    given:
      toAt CertificateDeathPage

    when:
      formDeath.stepNavigation.nextButton.click()

    then:
      formDeath.dateOfDeath.isError()
      formDeath.dateOfDeath.day.isError()
      formDeath.dateOfDeath.month.isError()
      formDeath.dateOfDeath.year.isError()
      formDeath.dateOfBirth.isError()
      formDeath.dateOfBirth.day.isError()
      formDeath.dateOfBirth.month.isError()
      formDeath.dateOfBirth.year.isError()
      formDeath.placeOfDeath.isError()
      formDeath.lastNameAtDeath.isError()
      formDeath.firstNameAtDeath.isError()
      formDeath.eventCountry.isSuccess()
      formDeath.serviceType.isSuccess()
      formDeath.numberOfCertificateCopies.isSuccess()
      formDeath.numberOfApostilledCopies.isError()

    when:
      interact { moveToElement(formDeath.dateOfDeath) }
      formDeath.dateOfDeath.year.click()

    then:
      formDeath.dateOfDeath.year.error.message.text() == 'Please enter year of death in YYYY format'

    when:
      formDeath.dateOfDeath.day = '9'
      formDeath.dateOfDeath.month = 'September'
      formDeath.dateOfDeath.year = '2083'

    then:
      formDeath.dateOfDeath.isSuccess()
      formDeath.dateOfDeath.day.isSuccess()
      formDeath.dateOfDeath.month.isSuccess()
      formDeath.dateOfDeath.year.isSuccess()

    // TODO: change to birth date validation
    when:
      interact { moveToElement(formDeath.dateOfBirth) }
      formDeath.dateOfBirth.year.click()

    then:
      formDeath.dateOfBirth.year.error.message.text() == 'Please enter year of death in YYYY format'

    when:
      formDeath.dateOfBirth.day = '9'
      formDeath.dateOfBirth.month = 'September'
      formDeath.dateOfBirth.year = '2083'

    then:
      formDeath.dateOfBirth.isSuccess()
      formDeath.dateOfBirth.day.isSuccess()
      formDeath.dateOfBirth.month.isSuccess()
      formDeath.dateOfBirth.year.isSuccess()

    and:
      checkErrorMessageAndValidate(formDeath, 'placeOfDeath', 'Please enter place of death', 'London')
      checkErrorMessageAndValidate(formDeath, 'lastNameAtDeath', 'Please enter last name of deceased', 'Haptism')
      checkErrorMessageAndValidate(formDeath, 'firstNameAtDeath', 'Please enter first name of deceased', 'Allelujah')

    when:
      formDeath.numberOfApostilledCopies = '1'

    then:
      formDeath.numberOfApostilledCopies.isSuccess()
  }
}
