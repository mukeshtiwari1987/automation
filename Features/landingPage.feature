Feature: Search in Landing Page

  Scenario:  Search IPhone in Flipkart Home Page and capture the device details less than 40000
    Given User Launch "Chrome" browser
    When User opens URL "https://www.flipkart.com"
    And User closes the login popup
    When User search "IPhone"
    Then Sort the page result from low to high
    Then navigate to and Capture all details
    Then Write Product details to XML File
