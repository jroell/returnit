package com.example.returnit.controllers

import org.springframework.http.HttpEntity
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.AsyncRestTemplate
import org.springframework.web.client.RestTemplate

@RestController
class LabelController(){

    var restTemplate = RestTemplate()

    @GetMapping("/generate")
    fun generateLabel(): String {
        headers.set("Content-type", "application/json")
        headers.set("api-key", """ElJkhJuQIRoFq/kDEblco4LpZqRCdYNIoAVG7SywSXw""")
        val postForEntity = restTemplate.postForEntity("https://api.shipengine.com/v1/labels",
                HttpEntity(requestJSON, headers),
                String::class.java)

        return postForEntity.body.toString()
    }

    private var headers = LinkedMultiValueMap<String, String>()


    private var requestJSON = """{
  "shipment": {
    "service_code": "usps_priority_mail",
    "ship_to": {
      "name": "Mickey and Minnie Mouse",
      "phone": "+1 (714) 781-4565",
      "company_name": "The Walt Disney Company",
      "address_line1": "500 South Buena Vista Street",
      "city_locality": "Burbank",
      "state_province": "CA",
      "postal_code": "91521",
      "country_code": "US",
      "address_residential_indicator": "No"
    },
    "ship_from": {
      "name": "Dade Murphy",
      "phone": "512-485-4282",
      "company_name": "Zero Cool",
      "address_line1": "345 Chambers Street",
      "address_line2": "Suite 100",
      "city_locality": "New York City",
      "state_province": "NY",
      "postal_code": "10282",
      "country_code": "US",
      "address_residential_indicator": "no"
    },
    "packages": [
      {
        "weight": {
          "value": 1.0,
          "unit": "ounce"
        }
      }
    ]
  },
  "test_label": true
}' """

}