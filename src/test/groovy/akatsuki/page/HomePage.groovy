package akatsuki.page

import akatsuki.page.module.PanelBirthModule
import akatsuki.path.PathPresentation

class HomePage extends BasePage {

  static url = PathPresentation.BASE
  static at = { title == "Simply Certificate" }

  static content = {
    panelBirth { module PanelBirthModule, $('#birth-section') }
    panelMarriage { module PanelBirthModule, $('#marriage-section') }
    panelDeath { module PanelBirthModule, $('#death-section') }
  }
}
