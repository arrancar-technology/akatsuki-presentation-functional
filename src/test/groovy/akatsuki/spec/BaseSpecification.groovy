package akatsuki.spec

import akatsuki.page.admin.AdminLoginPage
import akatsuki.path.PathFixture
import com.gmongo.GMongo
import com.mongodb.DB
import geb.spock.GebReportingSpec
import groovyx.net.http.RESTClient

class BaseSpecification extends GebReportingSpec {
  static ConfigObject config = initializeConfig()
  static RESTClient stubulator = new RESTClient(config.stubulator.baseUrl)
  static RESTClient presentation = new RESTClient(config.presentation.baseUrl)
  static DB db = new GMongo().getDB("test")

  private static ConfigObject initializeConfig() {
    return new ConfigSlurper(System.getProperty('test.env')).parse(configFileUrl)
  }

  private static URL getConfigFileUrl() {
    File file = new File('./src/test/groovy/akatsuki/Config.groovy')
    if (!file.exists()) { // This check is done for tests run on IDE
      file = new File('./presentation-functional/src/test/groovy/akatsuki/Config.groovy')
    }

    return file.toURI().toURL()
  }

  def setupSpec() {
    presentation.get(path: PathFixture.RESET)
  }

  def login() {
    to AdminLoginPage
    page.login()
  }

  def logout() {
    to AdminLoginPage
    page.logout()
  }

  def checkErrorMessageAndValidate(form, field, errorMessage, validValue) {
    form."$field".click()
    waitFor { form."$field".error.message.text() == errorMessage }

    form."$field" = validValue
    form."$field".isSuccess()

    return true
  }
}
