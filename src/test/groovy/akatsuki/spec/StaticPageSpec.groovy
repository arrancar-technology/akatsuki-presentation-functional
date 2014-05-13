package akatsuki.spec

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
      page << [TermsAndConditionsPage]
  }
}
