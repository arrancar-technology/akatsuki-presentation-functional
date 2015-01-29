package akatsuki.page.module

import geb.Module

class NavigationModule extends Module {

  static content = {
    urls { $('li a') }
  }

}
