package akatsuki.page.module

import geb.Module

class InputModule extends Module {
  def errorContainerSelector

  static content = {
    error { module ErrorModule, $().closest(errorContainerSelector ?: '.form-group') }
  }

  def isSuccess() {
    return error.hasClass('has-success')
  }

  def isError() {
    return error.hasClass('has-error')
  }
}
