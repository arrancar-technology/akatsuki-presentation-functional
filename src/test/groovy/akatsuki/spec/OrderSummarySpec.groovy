package akatsuki.spec

import akatsuki.page.CertificateBirthPage
import akatsuki.page.CertificateDeathPage
import akatsuki.page.CertificateMarriagePage

class OrderSummarySpec extends BaseSpecification {

  def "order summary displays correct information for birth certificate, additional and payment details"() {
    given:
      toAt CertificateBirthPage

    expect:
      orderSummary.certificateDetails.dateOfBirth.text() == "Date of Birth\n: -- / -- / --"
      orderSummary.certificateDetails.placeOfBirth.text() == "Place of Birth\n: --"
      orderSummary.certificateDetails.lastNameAtBirth.text() == "Last Name at Birth\n: --"
      orderSummary.certificateDetails.firstNameAtBirth.text() == "First Name at Birth\n: --"
      orderSummary.certificateDetails.motherMaidenName.text() == "Mother's Maiden Name\n: --"
      orderSummary.certificateDetails.motherFirstName.text() == "Mother's First Name\n: --"
      orderSummary.certificateDetails.fatherLastName.text() == "Father's Last Name\n: --"
      orderSummary.certificateDetails.fatherFirstName.text() == "Father's First Name\n: --"
      orderSummary.certificateDetails.eventCountry.text() == "Country of Event\n: England and Wales"
      orderSummary.certificateDetails.serviceType.text() == "Service Type\n: Standard"
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 1"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: --"
      orderSummary.certificateDetails.total.text() == "Total\n: £25"

    and:
      validateDefaultOrderSummaryForAdditionalDetails()
      validateDefaultOrderSummaryForPaymentDetails()

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
      orderSummary.certificateDetails.eventCountry.text() == "Country of Event\n: Republic of Ireland"
      orderSummary.certificateDetails.serviceType.text() == "Service Type\n: Rapid"
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 2"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: 1"
      orderSummary.certificateDetails.total.text() == "Total\n: £180"

    when:
      formBirth.stepNavigation.nextButton.click()
      populateAdditionalDetails()

    then:
      validateOrderSummaryForAdditionalDetails()

    when:
      formAdditional.stepNavigation.nextButton.click()
      populatePaymentDetails()

    then:
      validateOrderSummaryForPaymentDetails()
  }

  def "order summary displays correct information for marriage certificate, additional and payment details"() {
    given:
      to CertificateMarriagePage

    expect:
      orderSummary.certificateDetails.dateOfMarriage.text() == "Date of Marriage\n: -- / -- / --"
      orderSummary.certificateDetails.placeOfMarriage.text() == "Place of Marriage\n: --"
      orderSummary.certificateDetails.womanLastName.text() == "Woman Last Name\n: --"
      orderSummary.certificateDetails.womanFirstName.text() == "Woman First Name\n: --"
      orderSummary.certificateDetails.manLastName.text() == "Man Last Name\n: --"
      orderSummary.certificateDetails.manFirstName.text() == "Man First Name\n: --"
      orderSummary.certificateDetails.eventCountry.text() == "Country of Event\n: England and Wales"
      orderSummary.certificateDetails.serviceType.text() == "Service Type\n: Standard"
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 1"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: --"
      orderSummary.certificateDetails.total.text() == "Total\n: £25"

    and:
      validateDefaultOrderSummaryForAdditionalDetails()
      validateDefaultOrderSummaryForPaymentDetails()

    when:
      populateMarriageDetails()

    then:
      orderSummary.certificateDetails.dateOfMarriage.text() == "Date of Marriage\n: 2 / July / 1980"
      orderSummary.certificateDetails.placeOfMarriage.text() == "Place of Marriage\n: London"
      orderSummary.certificateDetails.womanLastName.text() == "Woman Last Name\n: Ismail"
      orderSummary.certificateDetails.womanFirstName.text() == "Woman First Name\n: Marina"
      orderSummary.certificateDetails.manLastName.text() == "Man Last Name\n: Seiei"
      orderSummary.certificateDetails.manFirstName.text() == "Man First Name\n: Setsuna F."
      orderSummary.certificateDetails.eventCountry.text() == "Country of Event\n: North Ireland"
      orderSummary.certificateDetails.serviceType.text() == "Service Type\n: Prime"
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 3"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: 1"
      orderSummary.certificateDetails.total.text() == "Total\n: £330"

    when:
      formMarriage.stepNavigation.nextButton.click()
      populateAdditionalDetails()

    then:
      validateOrderSummaryForAdditionalDetails()

    when:
      formAdditional.stepNavigation.nextButton.click()
      populatePaymentDetails()

    then:
      validateOrderSummaryForPaymentDetails()
  }

  def "order summary displays correct information for death certificate, additional and payment details"() {
    given:
      toAt CertificateDeathPage

    expect:
      orderSummary.certificateDetails.dateOfDeath.text() == "Date of Death\n: -- / -- / --"
      orderSummary.certificateDetails.placeOfDeath.text() == "Place of Death\n: --"
      orderSummary.certificateDetails.lastNameAtDeath.text() == "Last Name of Deceased\n: --"
      orderSummary.certificateDetails.firstNameAtDeath.text() == "First Name of Deceased\n: --"
      orderSummary.certificateDetails.eventCountry.text() == "Country of Event\n: England and Wales"
      orderSummary.certificateDetails.serviceType.text() == "Service Type\n: Standard"
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 1"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: --"
      orderSummary.certificateDetails.total.text() == "Total\n: £25"

    and:
      validateDefaultOrderSummaryForAdditionalDetails()
      validateDefaultOrderSummaryForPaymentDetails()

    when:
      populateDeathDetails()

    then:
      orderSummary.certificateDetails.dateOfDeath.text() == "Date of Death\n: 11 / November / 2083"
      orderSummary.certificateDetails.placeOfDeath.text() == "Place of Death\n: London"
      orderSummary.certificateDetails.lastNameAtDeath.text() == "Last Name of Deceased\n: Haptism"
      orderSummary.certificateDetails.firstNameAtDeath.text() == "First Name of Deceased\n: Allelujah"
      orderSummary.certificateDetails.eventCountry.text() == "Country of Event\n: Scotland"
      orderSummary.certificateDetails.serviceType.text() == "Service Type\n: Prime"
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 3"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: 1"
      orderSummary.certificateDetails.total.text() == "Total\n: £330"

    when:
      formDeath.stepNavigation.nextButton.click()
      populateAdditionalDetails()

    then:
      validateOrderSummaryForAdditionalDetails()

    when:
      formAdditional.stepNavigation.nextButton.click()
      populatePaymentDetails()

    then:
      validateOrderSummaryForPaymentDetails()
  }

  def "order summary displays correct price information"() {
    given:
      toAt CertificateBirthPage

    expect:
      orderSummary.certificateDetails.numberOfCopies.text() == "Number of Copies\n: 1"
      orderSummary.certificateDetails.apostilledCopies.text() == "Apostilled Copies\n: --"
      orderSummary.certificateDetails.total.text() == "Total\n: £25"

    when:
      formBirth.numberOfCertificateCopies = '1' // 2 copies

    then:
      orderSummary.certificateDetails.total.text() == "Total\n: £50"

    when:
      formBirth.numberOfCertificateCopies = '2' // 3 copies
      formBirth.numberOfApostilledCopies = '1'  // 1 apostilled

    then:
      orderSummary.certificateDetails.total.text() == "Total\n: £150"

    when:
      formBirth.serviceType = 'rapid'             // Rapid
      formBirth.numberOfCertificateCopies = '1'   // 2 copies
      formBirth.numberOfApostilledCopies = '1'    // 1 apostilled

    then:
      orderSummary.certificateDetails.total.text() == "Total\n: £180"

    when:
      formBirth.serviceType = 'prime'             // Prime
      formBirth.numberOfCertificateCopies = '1'   // 2 copies
      formBirth.numberOfApostilledCopies = '2'    // 2 apostilled

    then:
      orderSummary.certificateDetails.total.text() == "Total\n: £420"
  }
  def validateDefaultOrderSummaryForAdditionalDetails() {
    assert orderSummary.additionalDetails.firstName.text() == "First Name\n: --"
    assert orderSummary.additionalDetails.lastName.text() == "Last Name\n: --"
    assert orderSummary.additionalDetails.email.text() == "Email Address\n: --"
    assert orderSummary.additionalDetails.phone.text() == "Phone\n: --"
    assert orderSummary.additionalDetails.address1.text() == "Address 1\n: --"
    assert orderSummary.additionalDetails.address2.text() == "Address 2\n: --"
    assert orderSummary.additionalDetails.city.text() == "City\n: --"
    assert orderSummary.additionalDetails.postcode.text() == "Postcode\n: --"
    assert orderSummary.additionalDetails.country.text() == "Country\n: United Kingdom"

    return true
  }

  def validateDefaultOrderSummaryForPaymentDetails() {
    assert orderSummary.paymentDetails.cardNumber.text() == "Card Number\n: --"
    assert orderSummary.paymentDetails.expiryDate.text() == "Expiry Date\n: -- / --"
    assert orderSummary.paymentDetails.cardVerificationNumber.text() == "Card Verification (CVC)\n: --"

    return true
  }

  def validateOrderSummaryForAdditionalDetails() {
    assert orderSummary.additionalDetails.firstName.text() == "First Name\n: Lockon"
    assert orderSummary.additionalDetails.lastName.text() == "Last Name\n: Stratos"
    assert orderSummary.additionalDetails.email.text() == "Email Address\n: lockon.stratos@gmail.com"
    assert orderSummary.additionalDetails.address1.text() == "Address 1\n: Station Parade"
    assert orderSummary.additionalDetails.address2.text() == "Address 2\n: Kobe Road"
    assert orderSummary.additionalDetails.city.text() == "City\n: Tokyo"
    assert orderSummary.additionalDetails.postcode.text() == "Postcode\n: W8 9DF"
    assert orderSummary.additionalDetails.country.text() == "Country\n: Japan"
    assert orderSummary.additionalDetails.phone.text() == "Phone\n: 07157158989"

    return true
  }

  def validateOrderSummaryForPaymentDetails() {
    assert orderSummary.paymentDetails.cardNumber.text() == "Card Number\n: 4242424242424242"
    assert orderSummary.paymentDetails.expiryDate.text() == "Expiry Date\n: July / 2020"
    assert orderSummary.paymentDetails.cardVerificationNumber.text() == "Card Verification (CVC)\n: 123"

    return true
  }
}
