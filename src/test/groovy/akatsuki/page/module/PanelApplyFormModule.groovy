package akatsuki.page.module

class PanelApplyFormModule extends PanelModule {

  def certificateType

  static content = {
    form { module FormApplyModule, $("form.${certificateType}"), certificateType: certificateType }
    applyButton { $('.apply-button') }
  }
}
