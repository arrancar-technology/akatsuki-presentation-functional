package akatsuki.page.module

class PanelOrderList extends PanelModule {

  def certificateType

  static content = {
    searchField { $(".${certificateType} .search-field") }
    list(required: false) { module TableModule, $(".$certificateType") }
  }
}
