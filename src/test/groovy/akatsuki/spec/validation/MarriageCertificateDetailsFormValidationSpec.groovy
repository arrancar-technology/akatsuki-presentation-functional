package akatsuki.spec.validation

import akatsuki.page.CertificateMarriagePage
import akatsuki.spec.BaseSpecification

class MarriageCertificateDetailsFormValidationSpec extends BaseSpecification {

  def "marriage details form has correct validations"() {
    given:
      toAt CertificateMarriagePage

    when:
      formMarriage.stepNavigation.nextButton.click()

    then:
      formMarriage.dateOfMarriage.isError()
      formMarriage.dateOfMarriage.day.isError()
      formMarriage.dateOfMarriage.month.isError()
      formMarriage.dateOfMarriage.year.isError()
      formMarriage.placeOfMarriage.isError()
      formMarriage.womanLastName.isError()
      formMarriage.womanFirstName.isError()
      formMarriage.manLastName.isError()
      formMarriage.manFirstName.isError()
      formMarriage.serviceType.isSuccess()
      formMarriage.numberOfCertificateCopies.isSuccess()
      formMarriage.numberOfApostilledCopies.isError()

    when:
      interact { moveToElement(formMarriage.dateOfMarriage) }
      formMarriage.dateOfMarriage.year.click()

    then:
      formMarriage.dateOfMarriage.year.error.message.text() == 'Please enter year of marriage in YYYY format'

    when:
      formMarriage.dateOfMarriage.day = '1'
      formMarriage.dateOfMarriage.month = 'July'
      formMarriage.dateOfMarriage.year = '1981'

    then:
      formMarriage.dateOfMarriage.isSuccess()
      formMarriage.dateOfMarriage.day.isSuccess()
      formMarriage.dateOfMarriage.month.isSuccess()
      formMarriage.dateOfMarriage.year.isSuccess()

    and:
      checkErrorMessageAndValidate(formMarriage, 'placeOfMarriage', 'Please enter place of marriage', 'London')
      checkErrorMessageAndValidate(formMarriage, 'womanLastName', 'Please enter last name of woman', 'Ismail')
      checkErrorMessageAndValidate(formMarriage, 'womanFirstName', 'Please enter first name of woman', 'Marina')
      checkErrorMessageAndValidate(formMarriage, 'manLastName', 'Please enter last name of man', 'Seiei')
      checkErrorMessageAndValidate(formMarriage, 'manFirstName', 'Please enter first name of man', 'Setsuna F.')

    when:
      formMarriage.numberOfApostilledCopies = '1'

    then:
      formMarriage.numberOfApostilledCopies.isSuccess()
  }
}
