package akatsuki.page.module

import geb.Module

class InputModule extends Module {

  def inError() {
    return $().parent().parent().hasClass('has-error')
  }
}
