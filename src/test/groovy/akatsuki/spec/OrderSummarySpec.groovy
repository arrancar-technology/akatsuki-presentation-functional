package akatsuki.spec

import akatsuki.page.BirthCertificatePage

class OrderSummarySpec extends BaseSpecification {

  def "order summary displays correct information"() {
    given:
      toAt BirthCertificatePage

    expect:
      orderSummary.certificateDetails.dateOfBirth.text() == "Date of Birth\n: -- / -- / --"
      orderSummary.certificateDetails.placeOfBirth.text() == "Place of Birth\n: --"
      orderSummary.certificateDetails.lastNameAtBirth.text() == "Last Name at Birth\n: --"
      orderSummary.certificateDetails.firstNameAtBirth.text() == "First Name at Birth\n: --"
      orderSummary.certificateDetails.motherMaidenName.text() == "Mother's Maiden Name\n: --"
      orderSummary.certificateDetails.motherFirstName.text() == "Mother's First Name\n: --"
      orderSummary.certificateDetails.fatherLastName.text() == "Father's Last Name\n: --"
      orderSummary.certificateDetails.fatherFirstName.text() == "Father's First Name\n: --"
      orderSummary.certificateDetails.serviceType.text() == "Service Type\n: Standard"
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 1"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: --"
      orderSummary.certificateDetails.total.text() == "Total\n: £25"

    and:
      orderSummary.additionalDetails.firstName.text() == "First Name\n: --"
      orderSummary.additionalDetails.lastName.text() == "Last Name\n: --"
      orderSummary.additionalDetails.email.text() == "Email Address\n: --"
      orderSummary.additionalDetails.phone.text() == "Phone\n: --"
      orderSummary.additionalDetails.address1.text() == "Address 1\n: --"
      orderSummary.additionalDetails.address2.text() == "Address 2\n: --"
      orderSummary.additionalDetails.city.text() == "City\n: --"
      orderSummary.additionalDetails.postcode.text() == "Postcode\n: --"
      orderSummary.additionalDetails.country.text() == "Country\n: United Kingdom"

    and:
      orderSummary.paymentDetails.cardNumber.text() == "Card Number\n: --"
      orderSummary.paymentDetails.expiryDate.text() == "Expiry Date\n: -- / --"
      orderSummary.paymentDetails.cardVerificationNumber.text() == "Card Verification (CVC)\n: --"

    when:
      populateBirthDetails()

    then:
      orderSummary.certificateDetails.dateOfBirth.text() == "Date of Birth\n: 2 / July / 1981"
      orderSummary.certificateDetails.placeOfBirth.text() == "Place of Birth\n: London"
      orderSummary.certificateDetails.lastNameAtBirth.text() == "Last Name at Birth\n: Erde"
      orderSummary.certificateDetails.firstNameAtBirth.text() == "First Name at Birth\n: Tieria"
      orderSummary.certificateDetails.motherMaidenName.text() == "Mother's Maiden Name\n: Regetta"
      orderSummary.certificateDetails.motherFirstName.text() == "Mother's First Name\n: Regene"
      orderSummary.certificateDetails.fatherLastName.text() == "Father's Last Name\n: Almark"
      orderSummary.certificateDetails.fatherFirstName.text() == "Father's First Name\n: Ribbons"
      orderSummary.certificateDetails.serviceType.text() == "Service Type\n: Rapid"
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 2"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: 1"
      orderSummary.certificateDetails.total.text() == "Total\n: £155"

    when:
      formBirth.stepNavigation.nextButton.click()
      populateAdditionalDetails()

    then:
      orderSummary.additionalDetails.firstName.text() == "First Name\n: Lockon"
      orderSummary.additionalDetails.lastName.text() == "Last Name\n: Stratos"
      orderSummary.additionalDetails.email.text() == "Email Address\n: lockon.stratos@gmail.com"
      orderSummary.additionalDetails.address1.text() == "Address 1\n: Station Parade"
      orderSummary.additionalDetails.address2.text() == "Address 2\n: Kobe Road"
      orderSummary.additionalDetails.city.text() == "City\n: Tokyo"
      orderSummary.additionalDetails.postcode.text() == "Postcode\n: W8 9DF"
      orderSummary.additionalDetails.country.text() == "Country\n: Japan"
      orderSummary.additionalDetails.phone.text() == "Phone\n: 07157158989"

    when:
      formAdditional.stepNavigation.nextButton.click()
      populatePaymentDetails()

    then:
      orderSummary.paymentDetails.cardNumber.text() == "Card Number\n: 4242424242424242"
      orderSummary.paymentDetails.expiryDate.text() == "Expiry Date\n: July / 2020"
      orderSummary.paymentDetails.cardVerificationNumber.text() == "Card Verification (CVC)\n: 123"
  }

  def "order summary displays correct price information"() {
    // TODO: [DK] Implement this test...
  }
}
