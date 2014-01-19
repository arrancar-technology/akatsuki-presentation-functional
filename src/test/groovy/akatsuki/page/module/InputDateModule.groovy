package akatsuki.page.module

class InputDateModule extends InputModule {

  static content = {
    error { module ErrorModule, $() }

    day { module InputDropdownModule, $('.day'), errorContainerSelector: '.input-group-btn' }
    month { module InputDropdownModule, $('.month'), errorContainerSelector: '.input-group-btn' }
    year { module InputTextFieldModule, $('.year'), errorContainerSelector: '.input-group-btn' }
  }
}
