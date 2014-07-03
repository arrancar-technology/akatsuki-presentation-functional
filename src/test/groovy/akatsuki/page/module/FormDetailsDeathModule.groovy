package akatsuki.page.module

class FormDetailsDeathModule extends FormDetailsBaseModule {

  static content = {
    dateOfDeath { module InputDateModule, $('.date-of-death-container') }
    placeOfDeath { module InputTextFieldModule, $('#place-of-death') }
    dateOfBirth { module InputDateModule, $('.date-of-birth-container') }
    lastNameAtDeath { module InputTextFieldModule, $('#last-name-at-death') }
    firstNameAtDeath { module InputTextFieldModule, $('#first-name-at-death') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
