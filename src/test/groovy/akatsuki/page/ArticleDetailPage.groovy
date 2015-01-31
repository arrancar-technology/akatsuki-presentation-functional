package akatsuki.page

import akatsuki.path.PathPresentation

class ArticleDetailPage extends BasePage {

  static url = PathPresentation.LANDING_BLOG
  static at = {
    waitFor(10) { title == "What Do I Need A Birth Certificate For?" } // TODO: [DK] obvious, isn't it?
  }

  static content = {
    date { $('.date') }
    pageTitle { $('.title') }
    pageContent { $('.content') }
  }

}
