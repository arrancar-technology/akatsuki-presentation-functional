package akatsuki.spec

import akatsuki.page.ErrorInternalServerPage
import akatsuki.page.ErrorNotFoundPage

class ErrorPageSpec extends BaseSpecification {

  def "user sees custom error pages for error http status codes"() {
    when:
      go '/some/rubbish/path'

    then:
      at ErrorNotFoundPage
      pageContent.text() == "Simply Certificate\n404 - Please try again\nCould not found what you are looking for..."

    when:
      to ErrorInternalServerPage

    then:
      at ErrorInternalServerPage
      pageContent.text() == "Simply Certificate\nThere was an error\nWe will deal with it immediately..."
  }
}
