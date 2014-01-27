package akatsuki.page.module

class ProgressTrackerModule extends FormModule {
  static content = {
    certificateDetails { module ProgressTrackerItemModule, $('.progtrckr li')[0] }
    additionalDetails { module ProgressTrackerItemModule, $('.progtrckr li')[1] }
    paymentDetails { module ProgressTrackerItemModule, $('.progtrckr li')[2] }
  }
}
