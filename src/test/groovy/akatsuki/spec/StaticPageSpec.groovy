package akatsuki.spec

import akatsuki.page.AboutUsPage
import akatsuki.page.ContactUsPage
import akatsuki.page.FaqPage
import akatsuki.page.HomePage
import akatsuki.page.OrderSuccessPage
import akatsuki.page.PrivacyPolicyPage
import akatsuki.page.TermsAndConditionsPage
import spock.lang.Unroll

class StaticPageSpec extends BaseSpecification {

  @Unroll
  def "static pages are rendered properly"() {
    given:
      to page

    expect:
      at page

    where:
      page << [TermsAndConditionsPage, AboutUsPage, PrivacyPolicyPage, ContactUsPage, FaqPage]
  }

  def "direct access to success page should redirect to homepage"() {
    given:
    to OrderSuccessPage

    expect:
    at HomePage
  }
}
