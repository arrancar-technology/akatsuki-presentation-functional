package akatsuki.page

import akatsuki.page.module.PanelPrice
import akatsuki.path.PathPresentation

class PricingPage extends BasePage {

  static url = PathPresentation.PRICING
  static at = { title == "Simply Certificate - Pricing" }

  static content = {
    standardPricePanel { module PanelPrice, $('.panel.standard') }
  }
}
