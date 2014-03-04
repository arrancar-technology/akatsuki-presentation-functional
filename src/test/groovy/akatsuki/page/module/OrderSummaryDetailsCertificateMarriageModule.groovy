package akatsuki.page.module

class OrderSummaryDetailsCertificateMarriageModule extends FormModule {

  static content = {
    dateOfMarriage { $('.dateOfMarriage') }
    placeOfMarriage { $('.placeOfMarriage') }
    womanLastName { $('.womanLastName') }
    womanFirstName { $('.womanFirstName') }
    manLastName { $('.manLastName') }
    manFirstName { $('.manFirstName') }
    serviceType { $('.serviceType') }
    numberOfCopies { $('.numberOfCopies') }
    apostilledCopies { $('.apostilledCopies') }
    total { $('.total') }
  }
}
