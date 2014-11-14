package akatsuki.page

import akatsuki.page.module.PanelApplyFormModule
import akatsuki.path.PathPresentation

class LandingMarriagePage extends BasePage {

  static url = PathPresentation.LANDING_MARRIAGE
  static at = { title == "Replacement Marriage Certificate | Marriage Certificate Copy" }

  static content = {
        panelMarriage { module PanelApplyFormModule, $('#marriage-section'), certificateType: 'marriage' }
  }
}
