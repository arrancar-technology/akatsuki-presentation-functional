package akatsuki.page.module

class InputDateModule extends InputModule {

  static content = {
    error { module ErrorModule, $() }

    day { module InputDropdownModule, $('.date') }
    month { module InputDropdownModule, $('.month') }
    year { module InputTextFieldModule, $('.year') }
  }
}
