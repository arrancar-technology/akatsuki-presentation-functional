package akatsuki.page.admin

import geb.Page

class BaseAdminPage extends Page {

  static content = {
    logoutButton { $('a.logout') }
  }

  def logout() {
    logoutButton.click()
  }
}
