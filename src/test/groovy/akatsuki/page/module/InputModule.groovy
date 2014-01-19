package akatsuki.page.module

import geb.Module

class InputModule extends Module {
  def errorContainerSelector

  static content = {
    error { module ErrorModule, $().closest(errorContainerSelector ?: '.form-group') }
  }
}
