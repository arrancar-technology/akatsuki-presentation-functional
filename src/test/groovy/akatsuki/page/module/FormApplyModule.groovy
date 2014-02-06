package akatsuki.page.module

import geb.Module

class FormApplyModule extends Module {

  static content = {
    firstName { $('#first-name') }
    lastName { $('#last-name') }
    email { $('#email') }
    processButton { $('button') }
  }
}
