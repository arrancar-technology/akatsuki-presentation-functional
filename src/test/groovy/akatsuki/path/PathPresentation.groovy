package akatsuki.path

import akatsuki.spec.BaseSpecification

enum PathPresentation {
  BASE(BaseSpecification.config.presentation.baseContext),
  STATUS("$BASE/admin/status"),
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
