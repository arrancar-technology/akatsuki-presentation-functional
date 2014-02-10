package akatsuki.spec.e2e

import akatsuki.page.AdminOrdersListPage
import akatsuki.page.BirthCertificatePage
import akatsuki.page.HomePage
import akatsuki.spec.BaseSpecification

class CertificateRequestSpec extends BaseSpecification {

  def "certificate request is saved correctly"() {
    given:
      toAt HomePage

    when:
      panelBirth.applyButton.click()
      panelBirth.form.firstName = 'Lockon'
      panelBirth.form.lastName = 'Stratos'
      panelBirth.form.email = 'lockon.stratos@gmail.com'
      panelBirth.form.processButton.click()

    then:
      waitFor { at BirthCertificatePage }
      formAdditional.firstName.value() == 'Lockon'
      formAdditional.lastName.value() == 'Stratos'
      formAdditional.email.value() == 'lockon.stratos@gmail.com'

    when:
      populateBirthDetails()
      formBirth.stepNavigation.nextButton.click()

    and:
      populateAdditionalDetails()
      formAdditional.stepNavigation.nextButton.click()

    and:
      populatePaymentDetails()
      formPayment.stepNavigation.paymentButton.click()

    and:
      toAt AdminOrdersListPage

    then:
      orders('birth').rows[0].cells*.text() == ['#', 'First Name', 'Last Name', 'Email', 'Phone', 'Status', 'Details']
      waitFor { orders('birth').rows[1].cells*.text() == ['1', 'Lockon', 'Stratos', 'lockon.stratos@gmail.com', '07157158989', 'received', 'Details'] }
  }
}
