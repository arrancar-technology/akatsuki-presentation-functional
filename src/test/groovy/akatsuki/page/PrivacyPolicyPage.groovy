package akatsuki.page

import akatsuki.path.PathPresentation

class PrivacyPolicyPage extends BasePage {

  static url = PathPresentation.PRIVACY_POLICY
  static at = { title == "Simply Certificate - Privacy Policy" }

}
