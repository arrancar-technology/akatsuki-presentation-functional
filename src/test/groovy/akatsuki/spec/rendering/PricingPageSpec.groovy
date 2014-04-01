package akatsuki.spec.rendering

import akatsuki.page.PricingPage
import akatsuki.spec.BaseSpecification

class PricingPageSpec extends BaseSpecification {

  def setupSpec() {
      toAt PricingPage
  }

  def "Homepage renders correctly"() {
    expect:
      standardPricePanel.header.text() == "Standard"
      standardPricePanel.price.text() == "£25/cert"
      standardPricePanel.priceSub.text() == "+ £75/apostille (optional)"

    and:
      standardPricePanel.features[0].text() == "Dispatch in 10 working days"
      standardPricePanel.features[1].text() == "Email Tracking"
      standardPricePanel.features[2].text() == "-"

    and:
      standardPricePanel.certificateButtons[0].text() == "Birth"
      standardPricePanel.certificateButtons[1].text() == "Marriage"
      standardPricePanel.certificateButtons[2].text() == "Death"

    and:
      standardPricePanel.applyButton.text() == "Apply Now"
  }
}
