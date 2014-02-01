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

    when:
      formBirth.dateOfBirth.day = '1' // 0 indexed
      formBirth.dateOfBirth.month = 'July'
      formBirth.dateOfBirth.year = '1981'
      formBirth.placeOfBirth = 'London'
      formBirth.lastNameAtBirth = 'Erde'
      formBirth.firstNameAtBirth = 'Tieria'
      formBirth.motherMaidenName = 'Regetta'
      formBirth.motherFirstName = 'Regene'
      formBirth.fatherLastName = 'Almark'
      formBirth.fatherFirstName = 'Ribbons'

    then:
      orderSummary.certificateDetails.dateOfBirth.text() == "Date of Birth\n: 2 / July / 1981"
      orderSummary.certificateDetails.placeOfBirth.text() == "Place of Birth\n: London"
      orderSummary.certificateDetails.lastNameAtBirth.text() == "Last Name at Birth\n: Erde"
      orderSummary.certificateDetails.firstNameAtBirth.text() == "First Name at Birth\n: Tieria"
      orderSummary.certificateDetails.motherMaidenName.text() == "Mother's Maiden Name\n: Regetta"
      orderSummary.certificateDetails.motherFirstName.text() == "Mother's First Name\n: Regene"
      orderSummary.certificateDetails.fatherLastName.text() == "Father's Last Name\n: Almark"
      orderSummary.certificateDetails.fatherFirstName.text() == "Father's First Name\n: Ribbons"

    when:
      formBirth.stepNavigation.nextButton.click()
      formAdditional.numberOfCertificateCopies = '2' // 0 indexed
      formAdditional.numberOfApostilledCopies = '1'
      formAdditional.address.address1 = 'Station Parade'
      formAdditional.address.address2 = 'Kobe Road'
      formAdditional.address.city = 'Tokyo'
      formAdditional.address.postcode = 'W8 9DF'
      formAdditional.address.country = 'Japan'
      formAdditional.address.phone = '07157158989'

    then:
      orderSummary.additionalDetails.numberOfCopies.text() == "Number of Copies\n: 3"
      orderSummary.additionalDetails.apostilledCopies.text() == "Apostilled Copies\n: 1"
      orderSummary.additionalDetails.address1.text() == "Address 1\n: Station Parade"
      orderSummary.additionalDetails.address2.text() == "Address 2\n: Kobe Road"
      orderSummary.additionalDetails.city.text() == "City\n: Tokyo"
      orderSummary.additionalDetails.postcode.text() == "Postcode\n: W8 9DF"
      orderSummary.additionalDetails.country.text() == "Country\n: Japan"
      orderSummary.additionalDetails.phone.text() == "Phone\n: 07157158989"

    when:
      formAdditional.stepNavigation.nextButton.click()
      formPayment.email = "tieria.erde@email.com"
      formPayment.cardType = "Visa Debit"
      formPayment.cardholderName = "M T Erde"
      formPayment.cardNumber = "4444333322221111"
      formPayment.expiryDate.month = 'July'
      formPayment.expiryDate.year = '2020'
      formPayment.cardVerificationNumber = '123'

    then:
      orderSummary.paymentDetails.emailAddress.text() == "Email Address\n: tieria.erde@email.com"
      orderSummary.paymentDetails.cardType.text() == "Card Type\n: Visa Debit"
      orderSummary.paymentDetails.cardholderName.text() == "Cardholder Name\n: M T Erde"
      orderSummary.paymentDetails.cardNumber.text() == "Card Number\n: 4444333322221111"
      orderSummary.paymentDetails.expiryDate.text() == "Expiry Date\n: July / 2020"
      orderSummary.paymentDetails.cardVerificationNumber.text() == "Card Verification (CVC)\n: 123"
  }
}
