package akatsuki.spec

import akatsuki.page.AdminOrdersListPage
import akatsuki.page.BirthCertificatePage

class CertificateRequestSpec extends BaseSpecification {

  def "certificate request is saved correctly"() {
    given:
      toAt BirthCertificatePage

    and:
      populateBirthDetails()
      formBirth.stepNavigation.nextButton.clic()

    and:
      populateAdditionalDetails()
      formAdditional.stepNavigation.nextButton.clic()

    and:
      populatePaymentDetails()
      formPayment.stepNavigation.paymentButton.clic()

    when:
      toAt AdminOrdersListPage

    then:
      orders('birth').rows[0].cells*.text() == ['Tieria', 'Erde', '1981', 'July', '2']
  }
}
