package akatsuki.page

import akatsuki.path.PathPresentation

class HomePage extends BasePage {

  static url = PathPresentation.BASE
  static at = { title == "Welcome to Simply Certificate" }

//  static content = {
//    panelBirth { module PanelApplyFormModule, $('#birth-section'), certificateType: 'birth' }
//    panelMarriage { module PanelApplyFormModule, $('#marriage-section'), certificateType: 'marriage' }
//    panelDeath { module PanelApplyFormModule, $('#death-section'), certificateType: 'death' }
//  }
}
