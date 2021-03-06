package akatsuki.spec

import akatsuki.page.CertificateBirthPage

class ProgressTrackerSpec extends BaseSpecification {

  def "progress tracker shows correct state with each step"() {
    given:
      toAt CertificateBirthPage

    expect:
      progressTracker.certificateDetails.isTodo()
      progressTracker.additionalDetails.isTodo()
      progressTracker.paymentDetails.isTodo()

    when:
      populateBirthDetails()
      formBirth.stepNavigation.nextButton.click()

    then:
      progressTracker.certificateDetails.isDone()
      progressTracker.additionalDetails.isTodo()
      progressTracker.paymentDetails.isTodo()

    when:
      populateAdditionalDetails()
      formAdditional.stepNavigation.nextButton.click()

    then:
      progressTracker.certificateDetails.isDone()
      progressTracker.additionalDetails.isDone()
      progressTracker.paymentDetails.isTodo()
  }
}
