package akatsuki.page.module

class InputDropdownModule extends InputModule {

  def text() {
    $().find('option', value: $().value()).text()
  }
}
