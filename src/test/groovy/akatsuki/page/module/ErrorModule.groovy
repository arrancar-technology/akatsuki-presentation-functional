package akatsuki.page.module

import geb.Module

class ErrorModule extends Module {

  static content = {
    message(required: false) { $().closest('body').find('.popover') }
  }
}
