package akatsuki.page

import akatsuki.page.module.PanelApplyFormModule
import akatsuki.path.PathPresentation

class LandingDeathPage extends BasePage {

  static url = PathPresentation.LANDING_DEATH
  static at = { title == "Death Certificate | Order Copy of Death Certificate" }

  static content = {
        panelDeath { module PanelApplyFormModule, $('#death-section'), certificateType: 'death' }
  }
}
