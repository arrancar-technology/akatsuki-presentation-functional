package akatsuki.spec.validation

import akatsuki.page.HomePage
import akatsuki.spec.BaseSpecification

class ApplyFormValidationSpec extends BaseSpecification {

  def "apply form has correct validations"() {
    given:
      toAt HomePage

    when:
      panelBirth.applyButton.click()
      panelBirth.form.processButton.click()

    then:
      panelBirth.form.firstName.isError()
      panelBirth.form.lastName.isError()
      panelBirth.form.email.isError()

    when:
      panelBirth.form.firstName.click()

    then:
      panelBirth.form.firstName.error.message.text() == "Please enter your first name"

    when:
      panelBirth.form.firstName = "Lockon"

    then:
      panelBirth.form.firstName.isSuccess()

    when:
      panelBirth.form.lastName.click()

    then:
      panelBirth.form.lastName.error.message.text() == "Please enter your last name"

    when:
      panelBirth.form.lastName = "Stratos"

    then:
      panelBirth.form.lastName.isSuccess()

    when:
      panelBirth.form.email.click()

    then:
      panelBirth.form.email.error.message.text() == "Please enter your email address"

    when:
      panelBirth.form.email = "abc"

    then:
      panelBirth.form.email.isError()

    when:
      panelBirth.form.email = "lockon.stratos@gmail.com"

    then:
      panelBirth.form.email.isSuccess()
  }
}
