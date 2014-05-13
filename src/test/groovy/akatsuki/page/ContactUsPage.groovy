package akatsuki.page

import akatsuki.path.PathPresentation

class ContactUsPage extends BasePage {

  static url = PathPresentation.CONTACT_US
  static at = { title == "Simply Certificate - Contact Us" }

}
