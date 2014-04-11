package akatsuki.types

class OrderBuilder {
  def overrideOrder

  def OrderBuilder(overrideOrder = [:]) {
    this.overrideOrder = overrideOrder
  }

  def build() {
    def order = defaultOrders[overrideOrder?.certificate?.type ?: 'birth']
    order.putAll(overrideOrder)
    return order
  }

  def defaultOrders = [
    birth: [
      "firstName": "Lockon",
      "lastName": "Stratos",
      "email": "lockon.stratos@example.com",
      "referenceNumber": "RC7102010969813",
      "status": "paid",
      "certificate": [
        "type": "birth",
        "serviceType": "rapid",
        "eventCountry": "Republic of Ireland",
        "numberOfCopies": 1,
        "day": 2,
        "month": "7",
        "year": "1981",
        "place": "London",
        "lastName": "Erde",
        "firstName": "Tieria",
        "mother": [
          "maidenName": "Regetta",
          "firstName": "Regene"
        ],
        "father": [
          "lastName": "Almark",
          "firstName": "Ribbons"
        ],
        "numberOfApostilles": 0
      ],
      "charge": [
        "token": "",
        "amount": 180
      ],
      "address": [
        "country": "JP",
        "address1": "Station Parade",
        "address2": "Kobe Road",
        "city": "Tokyo",
        "postcode": "W8 9DF",
        "phone": "07157158989"
      ]
    ]
  ]
}