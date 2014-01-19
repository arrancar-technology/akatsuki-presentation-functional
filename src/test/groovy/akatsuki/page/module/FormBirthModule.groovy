package akatsuki.page.module

class FormBirthModule extends FormModule {
  static content = {
    dateOfBirth { module InputDateModule, $('.date-of-birth-container') }
    placeOfBirth { module InputTextFieldModule, $('#place-of-birth') }
    lastNameAtBirth { module InputTextFieldModule, $('#last-name-at-birth') }
    firstNameAtBirth { module InputTextFieldModule, $('#first-name-at-birth') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
