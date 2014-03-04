package akatsuki.page.module

class FormApplyModule extends FormModule {

  static content = {
    firstName { module InputTextFieldModule, $('#first-name') }
    lastName { module InputTextFieldModule, $('#last-name') }
    email { module InputTextFieldModule, $('#email') }
    processButton { $('button') }
  }
}
