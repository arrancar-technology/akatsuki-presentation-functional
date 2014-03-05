package akatsuki.page.module

class OrderSummaryDetailsCertificateMarriageModule extends OrderSummaryDetailsCertificateBaseModule {

  static content = {
    dateOfMarriage { $('.dateOfMarriage') }
    placeOfMarriage { $('.placeOfMarriage') }
    womanLastName { $('.womanLastName') }
    womanFirstName { $('.womanFirstName') }
    manLastName { $('.manLastName') }
    manFirstName { $('.manFirstName') }
  }
}
