package akatsuki.spec.validation

import akatsuki.page.BirthCertificatePage
import akatsuki.spec.BaseSpecification

class PaymentDetailsFormValidationSpec extends BaseSpecification {

  def "payment details form has correct validations"() {
    given:
      toAt BirthCertificatePage

    and:
      populateBirthDetails()
      formBirth.stepNavigation.nextButton.click()

    and:
      populateAdditionalDetails()
      formAdditional.stepNavigation.nextButton.click()

    expect: // Check defaults
      formPayment.cardType.text() == 'Visa'

    when:
      formPayment.stepNavigation.paymentButton.click()

    then:
      formPayment.cardType.isSuccess()
      formPayment.cardholderName.isError()
      formPayment.cardNumber.isError()
      formPayment.expiryDate.isError()
      formPayment.expiryDate.month.isError()
      formPayment.expiryDate.year.isError()
      formPayment.cardVerificationNumber.isError()

    when:
      formPayment.cardholderName.click()

    then:
      formPayment.cardholderName.error.message.text() == "Please enter cardholder's name as it is displayed on the card"

    when:
      formPayment.cardholderName = "MR T Erde"

    then:
      formPayment.cardholderName.isSuccess()

    when:
      formPayment.cardNumber.click()

    then:
      formPayment.cardNumber.error.message.text() == "Please enter 16 digit card number"

    when:
      formPayment.cardNumber = "4444"

    then:
      formPayment.cardNumber.isError()

    when:
      formPayment.cardNumber = "44443333222211115555"

    then:
      formPayment.cardNumber.isSuccess()
      formPayment.cardNumber.value() == "4444333322221111"

    when:
      formPayment.expiryDate.month = 'July'
      formPayment.expiryDate.year = '2020'

    then:
      !formPayment.expiryDate.isError()
      formPayment.expiryDate.month.isSuccess()
      formPayment.expiryDate.year.isSuccess()

    when:
      formPayment.cardVerificationNumber.click()

    then:
      formPayment.cardVerificationNumber.error.message.text() == "Please enter last 3 digits as it is displayed on signature strip"

    when:
      formPayment.cardVerificationNumber = "abcd"

    then:
      formPayment.cardVerificationNumber.isError()

    when:
      formPayment.cardVerificationNumber = "1234"

    then:
      formPayment.cardVerificationNumber.isSuccess()
      formPayment.cardVerificationNumber.value() == "123"
  }
}
