package akatsuki.spec

import akatsuki.page.admin.AdminOrdersListPage
import akatsuki.types.OrderBuilder
import spock.lang.Shared
import spock.lang.Unroll

import java.text.SimpleDateFormat

@Unroll
class OrderSearchSpec extends BaseSpecification {

  @Shared def createDate

  def setupSpec() {
    createDate = new SimpleDateFormat("yyyy.MM.dd-h:mm").format(new Date()).toString()
    db.orders.save(new OrderBuilder([firstName: 'Graham', lastName: 'Aker', email: 'graham.aker@example.com', postcode: 'w15ld', referenceNumber: 'RC7102010969813']).build())
    db.orders.save(new OrderBuilder([firstName: 'Ribbons', lastName: 'Almark', email: 'ribbons.almark@example.com', postcode: 'tw8f5', referenceNumber: 'RZ4104077969813']).build())
    db.orders.save(new OrderBuilder([firstName: 'Shirin', lastName: 'Bakhtiar', email: 'shirin.bakhtiar@example.com', postcode: 'n8df1', referenceNumber: 'RJ0133011969801']).build())
    db.orders.save(new OrderBuilder([firstName: 'Sumeragi', lastName: 'Lee Noriega', email: 'sumeragi.leenoriega@example.com', postcode: 'sw4h11', referenceNumber: 'RM5132111843257']).build())

    login()
  }

  def cleanupSpec() {
    logout()
  }

  def "admin can search for an order #scenario"() {
    when:
    to AdminOrdersListPage

    then:
    waitFor { oderListPanel('birth').list.rows[0].cells*.text() == ['#', 'First Name', 'Last Name', 'Email', 'Phone', 'Status', 'Create Date', 'Details'] }

    when:
    oderListPanel('birth').searchField = searchText

    then:
    waitFor { oderListPanel('birth').list.rows[1].cells*.text() == expectedSearchResult + ['07157158989', 'paid',  createDate, 'Details'] }

    where:
    searchText                        | expectedSearchResult                                                              | scenario
    'sumeragi'                        | ['RM5132111843257', 'Sumeragi', 'Lee Noriega', 'sumeragi.leenoriega@example.com'] | 'by first name'
    'bakhtiar'                        | ['RJ0133011969801', 'Shirin', 'Bakhtiar', 'shirin.bakhtiar@example.com']          | 'by last name'
    'w15ld'                           | ['RC7102010969813', 'Graham', 'Aker', 'graham.aker@example.com']                  | 'by postcode'
    'sumeragi.leenoriega@example.com' | ['RM5132111843257', 'Sumeragi', 'Lee Noriega', 'sumeragi.leenoriega@example.com'] | 'by email'
    'RZ4104077969813'                 | ['RZ4104077969813', 'Ribbons', 'Almark', 'ribbons.almark@example.com']            | 'by reference number'
  }
}
