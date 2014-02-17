package akatsuki.page.admin

import akatsuki.page.BasePage
import akatsuki.path.PathPresentation
import akatsuki.types.Users

class AdminLoginPage extends BasePage {

  static url = PathPresentation.ADMIN_LOGIN
  static at = {
    title == "Admin - Login - UK Certificate"
  }

  static content = {
    email { $('#email') }
    password { $('#password') }
    loginButton { $('button') }
  }

  def login() {
    email = Users.ADMIN.email
    password = Users.ADMIN.password
    loginButton.click()
  }
}
