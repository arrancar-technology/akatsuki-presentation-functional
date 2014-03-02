import geb.report.PageSourceReporter
import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

waiting {
  timeout = 2
}

baseUrl = "http://localhost:5000"
reportsDir = 'build/reports'
reporter = new PageSourceReporter()
autoClearCookies = false

def caps = new DesiredCapabilities(["javascriptEnabled": true,
                                    "takeScreenshot": true])
driver = {
  getChromeDriver()
}

driverRemote = {
  def driverUrl = System.getProperty("geb.driverUrl", "http://localhost")
  def driverPort = System.getProperty("geb.driverPort", "8910")
  new RemoteWebDriver(new URL("$driverUrl:$driverPort"), caps)
}

environments {
  remote {
    driver = driverRemote
  }

  func01 {
    baseUrl = "http://akatsuki-presentation-func01.herokuapp.com"
  }
}

public getChromeDriver() {
  def chromeDriver = new File('presentation-functional/src/test/drivers/chromedriver')
  def driverOs = 'mac32'
  def driverVersion = '2.8'

  if (driverOs == 'mac32') {
    downloadDriver(chromeDriver, "http://chromedriver.storage.googleapis.com/${driverVersion}/chromedriver_${driverOs}.zip")
  }

  System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
  def d = new ChromeDriver()
  d.manage().window().setSize(new Dimension(1920, 1200))
  d
}

private void downloadDriver(file, path) {
  if (!file.exists()) {
    def ant = new AntBuilder()
    ant.get(src: path, dest: 'driver.zip')
    ant.unzip(src: 'driver.zip', dest: file.parent)
    ant.delete(file: 'driver.zip')
    ant.chmod(file: file, perm: '700')
  }
}
