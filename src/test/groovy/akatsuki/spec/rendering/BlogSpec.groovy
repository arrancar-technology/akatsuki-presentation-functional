package akatsuki.spec.rendering

import akatsuki.page.*
import akatsuki.spec.BaseSpecification

class BlogSpec extends BaseSpecification {

  def "blog landing page renders post information of articles"() {
    given:
      toAt BlogLandingPage
      def lastPostIndex = articles.size() - 1

    expect:
      pageTitle.text() == 'All Posts'

    and:
      articles[lastPostIndex].date.text() == "28th January, 2015"
      articles[lastPostIndex].title.text() == "What Do I Need A Birth Certificate For?"
      articles[lastPostIndex].synopsis.text() == "Birth certificates are a very handy document in terms of identification and applying for other legal documents. Make sure you register your child’s birth so that they have their birth certificate. If your own birth certificate has become lost or ..."
      articles[lastPostIndex].readMore.text() == "Read More"

    and:
      articles[lastPostIndex].title.@href.endsWith("/blog/what-do-i-need-a-birth-certificate-for")
      articles[lastPostIndex].readMore.@href.endsWith("/blog/what-do-i-need-a-birth-certificate-for")
  }
}
