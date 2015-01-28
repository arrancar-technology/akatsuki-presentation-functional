package akatsuki.page.module

import geb.Module

class ArticleModule extends Module {

  static content = {
    title { $('.title') }
    synopsis { $('.synopsis') }
    date { $('.date') }
    readMore { $('.read-more') }
  }

}
