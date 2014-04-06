package akatsuki.spec.rendering

import akatsuki.page.CertificateBirthPage
import akatsuki.page.PricingPage
import akatsuki.spec.BaseSpecification
import spock.lang.Unroll

@Unroll
class PricingPageSpec extends BaseSpecification {

  def setup() {
      toAt PricingPage
  }

  def "Pricing page renders correctly"() {
    expect:
      page."$pricePanel".header.text() == header
      page."$pricePanel".price.text() == price
      page."$pricePanel".priceSub.text() == priceSub

    and:
      page."$pricePanel".features[0].text() == features[0]
      page."$pricePanel".features[1].text() == features[1]
      page."$pricePanel".features[2].text() == features[2]

    and:
      page."$pricePanel".certificateButtons[0].text() == "Birth"
      page."$pricePanel".certificateButtons[1].text() == "Marriage"
      page."$pricePanel".certificateButtons[2].text() == "Death"

    and:
      page."$pricePanel".applyButton.text() == "Apply Now"

    where:
    pricePanel            | header     | price       | priceSub                       | features
    'standardPricePanel'  | "Standard" | "£25/cert"  | "+ £75/apostille (optional)"   | ["Dispatch in 10 working days", "Free delivery", "Support response in 48 hours", "Email Tracking", "-", "-"]
    'rapidPricePanel'     | "Rapid"    | "£40/cert"  | "+ £100/apostille (optional)"  | ["Dispatch in 5 working days", "Free delivery", "Support response in 24 hours", "Email Tracking", "SMS Tracking", "-"]
    'primePricePanel'     | "Prime"    | "£60/cert"  | "+ £150/apostille (optional)"  | ["Dispatch in 1 working day", "Free delivery", "Support response in 4 hours", "Email Tracking", "SMS Tracking", "Scan and email documents"]
  }

  def "When certificate type is selected and apply button is clicked, user is taken to the correct page"() {
    when:
      page."$pricePanel".certificateButtons[0].click() // 'birth' certificate and 'rapid' service type
      page."$pricePanel".applyButton.click()

    then:
      at CertificateBirthPage

    and:
      formBirth.serviceType.value() == serviceType

    where:
      pricePanel        | serviceType
      "rapidPricePanel" | "rapid"
      "primePricePanel" | "prime"
  }
}
