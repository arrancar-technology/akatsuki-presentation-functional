package akatsuki.types

enum Users {
  ADMIN('admin', 'password', 'admin@akatsuki.com')

  def username
  def password
  def email

  Users(username, password, email) {
    this.username = username
    this.password = password
    this.email = email
  }
}