package akatsuki.spec.rendering

import akatsuki.page.HomePage
import akatsuki.path.PathFixture
import akatsuki.spec.BaseSpecification

class HomePageSpec extends BaseSpecification {

  def "Homepage renders correctly"() {
    expect:
      toAt HomePage
  }
}
