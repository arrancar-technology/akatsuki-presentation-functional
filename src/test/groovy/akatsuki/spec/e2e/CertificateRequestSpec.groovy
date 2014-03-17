package akatsuki.spec.e2e

import akatsuki.page.CertificateBirthPage
import akatsuki.page.CertificateDeathPage
import akatsuki.page.CertificateMarriagePage
import akatsuki.page.HomePage
import akatsuki.page.OrderSuccessPage
import akatsuki.page.admin.AdminOrdersListPage
import akatsuki.spec.BaseSpecification
import spock.lang.Unroll

class CertificateRequestSpec extends BaseSpecification {

  def setupSpec() {
    login()
  }

  def cleanupSpec() {
    logout()
  }

  @Unroll
  def "#certificateType certificate request is saved correctly"() {
    given:
      toAt HomePage

    when:
      page."panel${certificateType.capitalize()}".with {
        applyButton.click()
        form.firstName = 'Lockon'
        form.lastName = 'Stratos'
        form.email = 'lockon.stratos@gmail.com'
        form.processButton.click()
      }

    then:
      waitFor { at certificatePage }
      formAdditional.firstName.value() == 'Lockon'
      formAdditional.lastName.value() == 'Stratos'
      formAdditional.email.value() == 'lockon.stratos@gmail.com'

    when:
      "populate${certificateType.capitalize()}Details"()
      page."form${certificateType.capitalize()}".stepNavigation.nextButton.click()

    and:
      populateAdditionalDetails()
      formAdditional.stepNavigation.nextButton.click()

    and:
      populatePaymentDetails()
      formPayment.stepNavigation.paymentButton.click()

    then:
      waitFor { at OrderSuccessPage }

    and:
      successMessage.text() == "Thanks Lockon, we received your certificate order. You can find your order details below, and also you'll get an email that contains your order details. Please don't hesitate to contact us with any question you have. UK Official Certificate Team"

    when:
      toAt AdminOrdersListPage

    then:
      orders(certificateType).rows[0].cells*.text() == ['#', 'First Name', 'Last Name', 'Email', 'Phone', 'Status', 'Details']
      waitFor { orders(certificateType).rows[1].cells*.text() == ['1', 'Lockon', 'Stratos', 'lockon.stratos@gmail.com', '07157158989', 'paid', 'Details'] }

    when:
      showOrderDetails(certificateType, 1)

    then:
      getOrderDetailsModuleFor(certificateType).validateCertificateDetails()

    and:
      orderDetailsAdditionalInfo.lastName.text() == 'Last Name\nStratos'
      orderDetailsAdditionalInfo.firstName.text() == 'First Name\nLockon'
      orderDetailsAdditionalInfo.email.text() == 'Email Address\nlockon.stratos@gmail.com'
      orderDetailsAdditionalInfo.address1.text() == 'Address 1\nStation Parade'
      orderDetailsAdditionalInfo.address2.text() == 'Address 2\nKobe Road'
      orderDetailsAdditionalInfo.city.text() == 'City\nTokyo'
      orderDetailsAdditionalInfo.postcode.text() == 'Postcode\nW8 9DF'
      orderDetailsAdditionalInfo.country.text() == 'Country\nJP'
      orderDetailsAdditionalInfo.phone.text() == 'Phone\n07157158989'

    where:
      certificateType | certificatePage
      'birth'         | CertificateBirthPage
//      'marriage'      | CertificateMarriagePage
//      'death'         | CertificateDeathPage
  }
}
