package akatsuki.page.admin

import akatsuki.page.BasePage
import akatsuki.page.module.PanelBirthModule
import akatsuki.path.PathPresentation

class AdminHomePage extends BasePage {

  static url = PathPresentation.ADMIN_HOMEPAGE
  static at = { title == "Admin - UK Certificate" }

}
