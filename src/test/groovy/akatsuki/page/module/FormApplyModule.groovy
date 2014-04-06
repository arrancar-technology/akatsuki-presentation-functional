package akatsuki.page.module

class FormApplyModule extends FormModule {

  def certificateType

  static content = {
    firstName { module InputTextFieldModule, $("#first-name-${certificateType}") }
    lastName { module InputTextFieldModule, $("#last-name-${certificateType}") }
    email { module InputTextFieldModule, $("#email-${certificateType}") }
    processButton { $('button') }
  }
}
