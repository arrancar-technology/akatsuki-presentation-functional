package akatsuki.page.admin

import akatsuki.page.BasePage
import akatsuki.page.module.*
import akatsuki.path.PathPresentation

class AdminOrdersListPage extends BasePage {

  static url = PathPresentation.ADMIN_ORDERS_LIST
  static at = { title == "Admin - Orders - UK Certificate" }

  static content = {
    header { $("h2") }

    orders(required: false) { name -> module TableModule, $(".$name") }
  }

}
