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

    and:
      checkErrorMessageAndValidate(panelBirth.form, 'firstName', 'Please enter your first name', 'Lockon')
      checkErrorMessageAndValidate(panelBirth.form, 'lastName', 'Please enter your last name', 'Stratos')

    when:
      panelBirth.form.email.click()

    then:
      waitFor { panelBirth.form.email.error.message.text() == "Please enter your email address" }

    when:
      panelBirth.form.email = "abc"

    then:
      panelBirth.form.email.isError()

    when:
      panelBirth.form.email = "lockon.stratos@example.com"

    then:
      panelBirth.form.email.isSuccess()
  }
}
