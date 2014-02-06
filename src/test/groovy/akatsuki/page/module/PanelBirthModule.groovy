package akatsuki.page.module

class PanelBirthModule extends PanelModule {

  static content = {
    form { module FormApplyModule, $('form') }
    applyButton { $('.apply-button') }
  }
}
