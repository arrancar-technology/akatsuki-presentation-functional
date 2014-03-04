package akatsuki.page.module

class FormDetailsMarriageModule extends FormDetailsBaseModule {
  
  static content = {
    dateOfMarriage { module InputDateModule, $('.date-of-marriage-container') }
    placeOfMarriage { module InputTextFieldModule, $('#place-of-marriage') }
    womanLastName { module InputTextFieldModule, $('#woman-last-name') }
    womanFirstName { module InputTextFieldModule, $('#woman-first-name') }
    manLastName { module InputTextFieldModule, $('#man-last-name') }
    manFirstName { module InputTextFieldModule, $('#man-first-name') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
