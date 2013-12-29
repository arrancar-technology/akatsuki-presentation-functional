package akatsuki

presentation {
  baseUrl = "http://localhost:5000"
  baseContext = ""
}
stubulator {
  baseUrl = "http://localhost:5001"
  baseContext = ""
}

environments {
  func01 {
    presentation {
      baseUrl = "http://akatsuki-presentation-func01.herokuapp.com/"
      baseContext = ""
    }
    stubulator  {
      baseUrl = "http://akatsuki-presentation-stub01.herokuapp.com/"
      baseContext = ""
    }
  }
}
