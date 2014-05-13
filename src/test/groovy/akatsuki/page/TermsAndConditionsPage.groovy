package akatsuki.page

import akatsuki.path.PathPresentation

class TermsAndConditionsPage extends BasePage {

  static url = PathPresentation.TERMS_AND_CONDITIONS
  static at = { title == "Simply Certificate - Terms and Conditions" }

}
