package akatsuki.spec.e2e

import akatsuki.page.AdminOrdersListPage
import akatsuki.page.BirthCertificatePage
import akatsuki.spec.BaseSpecification

class CertificateRequestSpec extends BaseSpecification {

  def "certificate request is saved correctly"() {
    given:
      toAt BirthCertificatePage

    and:
      populateBirthDetails()
      formBirth.stepNavigation.nextButton.click()

    and:
      populateAdditionalDetails()
      formAdditional.stepNavigation.nextButton.click()

    and:
      populatePaymentDetails()
      formPayment.stepNavigation.paymentButton.click()

    when:
      toAt AdminOrdersListPage

    then:
      orders('birth').rows[0].cells*.text() == ['#', 'First Name', 'Last Name', 'Edit']
      orders('birth').rows[1].cells*.text() == ['1', 'Tieria', '', 'Edit']
  }
}
