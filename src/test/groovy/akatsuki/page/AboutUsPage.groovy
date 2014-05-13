package akatsuki.page

import akatsuki.path.PathPresentation

class AboutUsPage extends BasePage {

  static url = PathPresentation.ABOUT_US
  static at = { title == "Simply Certificate - About Us" }

}
