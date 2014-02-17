package akatsuki.spec

import akatsuki.page.admin.AdminHomePage
import akatsuki.page.admin.AdminLoginPage
import akatsuki.page.admin.AdminStatusPage

class LoginSpec extends BaseSpecification {

  def "user can login and logout"() {
    when:
      to AdminStatusPage

    then:
      at AdminLoginPage

    when:
      page.login()

    then:
      at AdminStatusPage

    when: // preserves login
      to AdminHomePage

    then:
      at AdminHomePage

    when:
      logout()

    then:
      at AdminLoginPage
  }
}
