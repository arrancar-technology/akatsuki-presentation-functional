package akatsuki.page

import akatsuki.page.module.NavigationModule
import akatsuki.path.PathPresentation

class HomePage extends BasePage {

  static url = PathPresentation.BASE
  static at = { title == "Welcome to Simply Certificate" }

  static content = {
    navigation { module NavigationModule, $('.navbar') }
  }

}
