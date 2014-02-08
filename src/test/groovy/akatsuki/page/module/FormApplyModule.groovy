package akatsuki.page.module

import geb.Module

class FormApplyModule extends Module {

  static content = {
    firstName { module InputTextFieldModule, $('#first-name') }
    lastName { module InputTextFieldModule, $('#last-name') }
    email { module InputTextFieldModule, $('#email') }
    processButton { $('button') }
  }
}
