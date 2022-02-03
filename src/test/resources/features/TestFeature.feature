Feature: Google Cloud Platform Pricing Calculator

  Description: To calculate the cost of renting a cloud platform

  Scenario: Verification of the obtained result of the rental cost of the Google cloud platform through
            the calculation of the cost on Cloud Platform Pricing Calculator.
    Given Going through the search on the Cloud Platform Pricing Calculator
    When Fill in the calculator fields with test data
    And Add to Estimate by clicking the button
    And Saving the string value 'Total Estimated Cost'
    And Create a temporary mail and save the address
    And Return to the cloud calculator page
    And Send email and get the cost to a temporary email
    And Open the received email
    Then CheckCostResult

