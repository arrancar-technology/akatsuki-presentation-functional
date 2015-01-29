package akatsuki.spec.rendering

import akatsuki.page.HomePage
import akatsuki.path.PathPresentation
import akatsuki.spec.BaseSpecification
import spock.lang.Ignore

class NavigationSpec extends BaseSpecification {

  def "Navigation should have correct links"() {
    given:
      to HomePage

    expect:
      navigation.urls[0].text() == "Birth Certificate"
      navigation.urls[0].@href.endsWith(PathPresentation.LANDING_BIRTH.path)
      navigation.urls[1].text() == "Marriage Certificate"
      navigation.urls[1].@href.endsWith(PathPresentation.LANDING_MARRIAGE.path)
      navigation.urls[2].text() == "Death Certificate"
      navigation.urls[2].@href.endsWith(PathPresentation.LANDING_DEATH.path)
      navigation.urls[3].text() == "Pricing"
      navigation.urls[3].@href.endsWith(PathPresentation.PRICING.path)
      navigation.urls[4].text() == "Blog"
      navigation.urls[4].@href.endsWith(PathPresentation.LANDING_BLOG.path)
      navigation.urls[5].text() == "Contact Us"
      navigation.urls[5].@href.endsWith(PathPresentation.CONTACT_US.path)
  }
}
