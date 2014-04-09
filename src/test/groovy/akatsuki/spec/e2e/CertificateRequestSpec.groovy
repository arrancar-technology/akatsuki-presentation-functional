package akatsuki.spec.e2e

import akatsuki.page.CertificateBirthPage
import akatsuki.page.CertificateDeathPage
import akatsuki.page.CertificateMarriagePage
import akatsuki.page.HomePage
import akatsuki.page.OrderSuccessPage
import akatsuki.page.admin.AdminOrdersListPage
import akatsuki.spec.BaseSpecification
import spock.lang.Shared
import spock.lang.Unroll

class CertificateRequestSpec extends BaseSpecification {

  def setupSpec() {
    login()
  }

  def cleanupSpec() {
    logout()
  }

  @Shared def previousOrderReferenceNumber

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
      successMessage.text() == "Thanks Lockon, we received your certificate order. You can find your order details below, and also you'll get an email that contains your order details. Please don't hesitate to contact us with any question you have. Simply Certificate Team"

    when:
      toAt AdminOrdersListPage

    then:
      waitFor { oderListPanel(certificateType).list.rows[0].cells*.text() == ['#', 'First Name', 'Last Name', 'Email', 'Phone', 'Status', 'Details'] }
      waitFor { oderListPanel(certificateType).list.rows[1].cells*.text().tail() == ['Lockon', 'Stratos', 'lockon.stratos@gmail.com', '07157158989', 'paid', 'Details'] }

    and:
      def currentOrderReferenceNumber = oderListPanel(certificateType).list.rows[1].cells*.text().head()
      if(previousOrderReferenceNumber) {
        previousOrderReferenceNumber[0..2] == currentOrderReferenceNumber[0..2]
        (previousOrderReferenceNumber[3..9] as Integer) + 1 == currentOrderReferenceNumber[3..9] as Integer
      }

    when:
      previousOrderReferenceNumber = currentOrderReferenceNumber
      showOrderDetails(certificateType, 1)

    then:
      page."orderDetails${certificateType.capitalize()}".validateCertificateDetails()
      page."orderDetails${certificateType.capitalize()}".validateAdditionalInfoDetails()

    where:
      certificateType | certificatePage
      'birth'         | CertificateBirthPage
      'marriage'      | CertificateMarriagePage
      'death'         | CertificateDeathPage
  }

  // TODO: [DK] write test for editing order on admin console
}
