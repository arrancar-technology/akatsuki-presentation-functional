package akatsuki.page.module

import geb.Module

class FormModule extends Module {

  static content = {
    error { $('.alert .error') }
  }
}
