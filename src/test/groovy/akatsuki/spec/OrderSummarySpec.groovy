package akatsuki.spec

import akatsuki.page.BirthCertificatePage

class OrderSummarySpec extends BaseSpecification {

  def "progress tracker shows correct state with each step"() {
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

    and:
      orderSummary.additionalDetails.numberOfCopies.text() == "Number of Copies\n: 1"
      orderSummary.additionalDetails.apostilledCopies.text() == "Apostilled Copies\n: --"
      orderSummary.additionalDetails.phone.text() == "Phone\n: --"
      orderSummary.additionalDetails.address1.text() == "Address 1\n: --"
      orderSummary.additionalDetails.address2.text() == "Address 2\n: --"
      orderSummary.additionalDetails.city.text() == "City\n: --"
      orderSummary.additionalDetails.postcode.text() == "Postcode\n: --"
      orderSummary.additionalDetails.country.text() == "Country\n: United Kingdom"

    and:
      orderSummary.paymentDetails.emailAddress.text() == "Email Address\n: --"
      orderSummary.paymentDetails.cardType.text() == "Card Type\n: Visa"
      orderSummary.paymentDetails.cardholderName.text() == "Cardholder Name\n: --"
      orderSummary.paymentDetails.cardNumber.text() == "Card Number\n: --"
      orderSummary.paymentDetails.expiryDate.text() == "Expiry Date\n: -- / --"
      orderSummary.paymentDetails.cardVerificationNumber.text() == "Card Verification (CVC)\n: --"
  }
}
