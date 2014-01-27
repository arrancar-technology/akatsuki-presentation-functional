package akatsuki.page.module

class ProgressTrackerItemModule extends FormModule {

  def isDone() {
    $().hasClass('progtrckr-done')
  }

  def isTodo() {
    !isDone()
  }
}
