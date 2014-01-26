package akatsuki.page.module

class InputDateMonthYearModule extends InputModule {

  static content = {
    error { module ErrorModule, $() }

    month { module InputDropdownModule, $('.month'), errorContainerSelector: '.input-group-btn' }
    year { module InputDropdownModule, $('.year'), errorContainerSelector: '.input-group-btn' }
  }
}
