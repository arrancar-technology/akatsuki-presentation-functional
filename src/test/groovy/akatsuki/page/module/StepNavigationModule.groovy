package akatsuki.page.module

import geb.Module

class StepNavigationModule extends Module {

  static content = {
    previousButton(required: false) { $('.button-previous') }
    nextButton(required: false) { $('.button-next') }
    paymentButton(required: false) { $('.button-payment') }
  }
}
