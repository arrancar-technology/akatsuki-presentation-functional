package akatsuki.spec.e2e

import akatsuki.page.*
import akatsuki.page.admin.AdminOrdersListPage
import akatsuki.spec.BaseSpecification
import spock.lang.Shared
import spock.lang.Unroll

@Unroll
class CertificateRequestSpec extends BaseSpecification {

  def setupSpec() {
    login()
  }

  def cleanupSpec() {
    logout()
  }

  @Shared def previousOrderReferenceNumber

  def "#certificateType certificate request is saved correctly"() {
    given:
      toAt HomePage

    when:
      page."panel${certificateType.capitalize()}".with {
        applyButton.click()
        form.firstName = 'Lockon'
        form.lastName = 'Stratos'
        form.email = 'lockon.stratos@example.com'
        form.processButton.click()
      }

    then:
      waitFor { at certificatePage }
      formAdditional.firstName.value() == 'Lockon'
      formAdditional.lastName.value() == 'Stratos'
      formAdditional.email.value() == 'lockon.stratos@example.com'

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
      successMessage.text() == "Thanks Lockon, we received your certificate order. You will get an email that contains your order details.\n" +
        "Please don't hesitate to contact us with any question you have.\n" +
        "\n" +
        "Simply Certificate Team"

    when:
      toAt AdminOrdersListPage

    then:
      waitFor { oderListPanel(certificateType).list.rows[0].cells*.text() == ['#', 'First Name', 'Last Name', 'Email', 'Phone', 'Status', 'Details'] }
      waitFor { oderListPanel(certificateType).list.rows[1].cells*.text().tail() == ['Lockon', 'Stratos', 'lockon.stratos@example.com', '07517158978', 'paid', 'Details'] }

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
