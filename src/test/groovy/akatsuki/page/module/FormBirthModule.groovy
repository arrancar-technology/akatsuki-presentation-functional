package akatsuki.page.module

class FormBirthModule extends FormModule {
  static content = {
    placeOfBirth { module InputTextFieldModule, $('#place-of-birth') }
    lastNameAtBirth { module InputTextFieldModule, $('#last-name-at-birth') }
    firstNameAtBirth { module InputTextFieldModule, $('#first-name-at-birth') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
