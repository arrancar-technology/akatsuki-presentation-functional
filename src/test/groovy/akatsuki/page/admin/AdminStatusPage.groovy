package akatsuki.page.admin

import akatsuki.page.module.TableModule
import akatsuki.path.PathPresentation

class AdminStatusPage extends BaseAdminPage {

  static url = PathPresentation.ADMIN_STATUS
  static at = {
    title == "Admin - Status - UK Certificate"
    header.text() == "akatsuki presentation status"
  }

  static content = {
    header { $("h2") }

    status(required: false) { name -> module TableModule, $(".$name") }
  }
}
