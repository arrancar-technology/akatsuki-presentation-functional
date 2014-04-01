package akatsuki.page.module

class PanelPrice extends PanelModule {

  static content = {
    header { $('h3.panel-title') }
    price { $('.the-price h1') }
    priceSub { $('.the-price small') }
    features { $('td.feature') }
    certificateButtons { $('button.certificate') }
    applyButton { $('a.apply-now') }
  }
}
