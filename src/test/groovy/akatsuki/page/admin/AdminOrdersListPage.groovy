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

    orderDetailsBirth { module OrderDetailsEditBirthModule, $('.modal.birth') }
    orderDetailsMarriage { module OrderDetailsEditMarriageModule, $('.modal.marriage') }
    orderDetailsDeath { module OrderDetailsEditDeathModule, $('.modal.death') }

    orderDetailsAdditionalInfo { module OrderDetailsEditAdditionalInfoModule }
  }

  def showOrderDetails(orderType, rowNumber) {
    orders(orderType).rows[rowNumber].cells[6].find('button')click()
  }

  def getOrderDetailsModuleFor(certificateType) {
    def orderDetailsModule
    switch (certificateType) {
      case 'birth':
        orderDetailsModule = orderDetailsBirth
        break
      case 'marriage':
        orderDetailsModule = orderDetailsMarriage
        break
      case 'death':
        orderDetailsModule = orderDetailsDeath
        break
    }

    return orderDetailsModule
  }
}
