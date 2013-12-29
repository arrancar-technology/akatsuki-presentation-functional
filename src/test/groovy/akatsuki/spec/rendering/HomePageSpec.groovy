package akatsuki.spec.rendering

import akatsuki.page.HomePage
import akatsuki.path.PathFixture
import akatsuki.spec.BaseSpecification

class HomePageSpec extends BaseSpecification {

  def "Homepage renders correctly"() {
    given:
      presentation.get(path: PathFixture.RESET)

    when:
      toAt HomePage

    then:
      locationField.displayed
      locationField.@placeholder == 'Enter your town/postcode'
  }
}
