package akatsuki.spec.rendering

import akatsuki.page.ArticleDetailPage
import akatsuki.page.ErrorNotFoundPage
import akatsuki.spec.BaseSpecification

class ArticleSpec extends BaseSpecification {

  def "article page renders the article correctly"() {
    given:
      def articleTitle = 'What Do I Need A Birth Certificate For?'
      toAt ArticleDetailPage, articleTitle.toLowerCase().replace(' ', '-').replace('?', "")

    expect:
      date.text() == "28th January, 2015"
      pageTitle.text() == articleTitle
      pageContent.text().contains("Birth certificates are a very handy document in terms of identification and applying for other legal documents")
  }

  def "article request with an invalid title should send user to 404"() {
    given:
      def articleTitle = 'This article does not exist'
      to ArticleDetailPage, articleTitle.toLowerCase().replace(' ', '-').replace('?', "")

    expect:
      at ErrorNotFoundPage
  }
}
