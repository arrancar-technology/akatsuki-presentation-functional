package akatsuki.spec.validation

import akatsuki.page.HomePage
import akatsuki.spec.BaseSpecification

class MaximumLengthValidationSpec extends BaseSpecification {

  def "apply form should have correct form validation"() {
    given:
      toAt HomePage

    when:
      panelBirth.applyButton.click()
      panelBirth.form.firstName = generatorName(51)

    then:
      panelBirth.form.firstName.value().size() == 50

    when:
      panelBirth.form.lastName = generatorName(51)

    then:
      panelBirth.form.lastName.value().size() == 50

    when:
      panelBirth.form.email = "lockon.stratos@${generatorName(250)}.com"

    then:
      panelBirth.form.email.value().size() == 254
  }

  // TODO: [DK] implement following tests
  def "birth form should have correct form validation"() {}
  def "marriage form should have correct form validation"() {}
  def "death form should have correct form validation"() {}
  def "additional information form should have correct form validation"() {}
  def "payment information form should have correct form validation"() {}

  def generatorName = { int n ->
    generator(('A'..'Z').join(), n)
  }

  def generator = { String alphabet, int n ->
    new Random().with {
      (1..n).collect { alphabet[ nextInt(alphabet.length()) ] }.join()
    }
  }

}