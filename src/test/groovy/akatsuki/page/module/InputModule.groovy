package akatsuki.page.module

import geb.Module

class InputModule extends Module {

  static content = {
    error { module ErrorModule, $().parent().parent() }
  }
}
