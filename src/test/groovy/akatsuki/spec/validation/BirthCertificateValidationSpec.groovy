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
      formBirth.placeOfBirth.inError()
      formBirth.lastNameAtBirth.inError()
      formBirth.firstNameAtBirth.inError()
  }
}
