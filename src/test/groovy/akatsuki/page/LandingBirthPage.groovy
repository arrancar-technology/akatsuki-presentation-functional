package akatsuki.page

import akatsuki.page.module.PanelApplyFormModule
import akatsuki.path.PathPresentation

class LandingBirthPage extends BasePage {

  static url = PathPresentation.LANDING_BIRTH
  static at = { title == "Replacement Birth Certificate | Lost Birth Certificate" }

  static content = {
    panelBirth { module PanelApplyFormModule, $('#birth-section'), certificateType: 'birth' }
  }
}
