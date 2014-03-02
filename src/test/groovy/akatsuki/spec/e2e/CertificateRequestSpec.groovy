package akatsuki.spec.e2e

import akatsuki.page.OrderSuccessPage
import akatsuki.page.admin.AdminOrdersListPage
import akatsuki.page.BirthCertificatePage
import akatsuki.page.HomePage
import akatsuki.spec.BaseSpecification

class CertificateRequestSpec extends BaseSpecification {

  def setupSpec() {
    login()
  }

  def cleanupSpec() {
    logout()
  }

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

    then:
      at OrderSuccessPage

    and:
      successMessage.text() == "Thanks Lockon, we received your certificate order. You can find your order details below, and also you'll get an email that contains your order details. Please don't hesitate to contact us with any question you have. UK Official Certificate Team"

    when:
      toAt AdminOrdersListPage

    then:
      orders('birth').rows[0].cells*.text() == ['#', 'First Name', 'Last Name', 'Email', 'Phone', 'Status', 'Details']
      waitFor { orders('birth').rows[1].cells*.text() == ['1', 'Lockon', 'Stratos', 'lockon.stratos@gmail.com', '07157158989', 'paid', 'Details'] }
  }
}
