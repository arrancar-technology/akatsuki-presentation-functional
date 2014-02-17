package akatsuki.path

import akatsuki.spec.BaseSpecification

enum PathPresentation {
  BASE(BaseSpecification.config.presentation.baseContext),
  ADMIN_STATUS("$BASE/admin/status"),
  ADMIN_LOGIN("$BASE/login/admin"),
  ADMIN_HOMEPAGE("$BASE/admin"),
  ADMIN_ORDERS_LIST("$BASE/admin/orders"),
  API_1_STATUS("$BASE/api/1/status"),
  CERTIFICATE_BIRTH("$BASE/certificate/birth")

  String path

  PathPresentation(String path) {
    this.path = path
  }

  @Override
  String toString() {
    this.path
  }
}
