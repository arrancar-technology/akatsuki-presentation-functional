package akatsuki.page.module

class FormBirthDetailsModule extends FormModule {
  static content = {
    dateOfBirth { module InputDateModule, $('.date-of-birth-container') }
    placeOfBirth { module InputTextFieldModule, $('#place-of-birth') }
    lastNameAtBirth { module InputTextFieldModule, $('#last-name-at-birth') }
    firstNameAtBirth { module InputTextFieldModule, $('#first-name-at-birth') }
    motherMaidenName { module InputTextFieldModule, $('#mother-maiden-name') }
    motherFirstName { module InputTextFieldModule, $('#mother-first-name') }
    fatherLastName { module InputTextFieldModule, $('#father-last-name') }
    fatherFirstName { module InputTextFieldModule, $('#father-first-name') }
    numberOfCertificateCopies { module InputDropdownModule, $('#number-of-copies') }
    numberOfApostilledCopies { module InputDropdownModule, $('#number-of-apostilles') }

    stepNavigation { module StepNavigationModule, $('.step-navigation')}
  }
}
