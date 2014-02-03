package akatsuki.page

import akatsuki.page.module.*
import akatsuki.path.PathPresentation

class AdminOrdersListPage extends BasePage {

  static url = PathPresentation.ADMIN_ORDERS_LIST
  static at = { title == "UK Certificate - Orders" }

  static content = {
    header { $("h2") }

    orders(required: false) { name -> module TableModule, $(".$name") }
  }

}
