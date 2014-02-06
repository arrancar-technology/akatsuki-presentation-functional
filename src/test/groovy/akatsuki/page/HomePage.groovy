package akatsuki.page

import akatsuki.page.module.PanelBirthModule
import akatsuki.path.PathPresentation

class HomePage extends BasePage {

  static url = PathPresentation.BASE
  static at = { title == "UK Certificates" }

  static content = {
    panelBirth { module PanelBirthModule, $('#birth-section') }
  }
}
