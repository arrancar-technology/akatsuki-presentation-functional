package akatsuki.spec.e2e

import akatsuki.page.*
import akatsuki.spec.BaseSpecification
import spock.lang.Unroll

class CertificateChargingSpec extends BaseSpecification {

  @Unroll
  def "payment fails for '#scenario' '#paymentValues' with message: '#errorMessage'"() {
    given:
      to CertificateBirthPage

    when:
      populateBirthDetails()
      formBirth.stepNavigation.nextButton.click()

    and:
      populateAdditionalDetails()
      formAdditional.stepNavigation.nextButton.click()

    and:
      populatePaymentDetails(paymentValues)
      formPayment.stepNavigation.paymentButton.click()

    then:
      formPayment.stepNavigation.paymentButton.disabled
      formPayment.stepNavigation.paymentButton.text() == 'Processing'

    and:
      waitFor { formPayment.error.text() == errorMessage }
      !formPayment.stepNavigation.paymentButton.disabled

    where:
      paymentValues                    | errorMessage                                          | scenario
      [cardNumber: '4242424242424241'] | 'Sorry, card number is incorrect'                     | 'incorrect_number'
      [cardNumber: '4000000000000069'] | 'Sorry, card is expired'                              | 'expired_card'
      [cardNumber: '4000000000000127'] | 'Sorry, CVC number is incorrect'                      | 'incorrect_cvc'
      [cardNumber: '4000000000000002'] | 'Sorry, card is declined'                             | 'card_declined'
      [cardNumber: '4000000000000119'] | 'Sorry. there was an error, click for payment again'  | 'processing_error'

      // TODO: [DK] test this scenarios if necessary
      // https://stripe.com/docs/testing
      // [: ''] | '' // invalid_expiry_month
      // [: ''] | '' // invalid_expiry_year
      // [: ''] | '' // invalid_cvc
      // [: ''] | '' // missing ???
  }

  def "payment successes after a failed one"() {
    given:
      to CertificateBirthPage

    when:
      populateBirthDetails()
      formBirth.stepNavigation.nextButton.click()

    and:
      populateAdditionalDetails()
      formAdditional.stepNavigation.nextButton.click()

    and:
      populatePaymentDetails([cardNumber: '4242424242424241'])
      formPayment.stepNavigation.paymentButton.click()

    then:
      formPayment.stepNavigation.paymentButton.disabled

    and:
      waitFor { formPayment.error.text() == 'Sorry, card number is incorrect' }
      !formPayment.stepNavigation.paymentButton.disabled

    when:
      populatePaymentDetails()
      formPayment.stepNavigation.paymentButton.click()

    then:
      waitFor { at OrderSuccessPage }
  }
}
