Feature: Google Cloud Platform Pricing Calculator

  Description: To calculate the cost of renting a cloud platform

  @severity=blocker
  @issue=<ISSUE-NUMBER>
  Scenario: Verification of the obtained result of the rental cost of the Google cloud platform through
            the calculation of the cost on Cloud Platform Pricing Calculator.

    When Going through the search on the Cloud Platform Pricing Calculator
    Then Fill in the calculator fields with test data
    And Add to Estimate by clicking the button
    When Saving the string value 'Total Estimated Cost'
    Then Create a temporary mail and save the address
    And Return to the cloud calculator page
    When Send email and get the cost to a temporary email
    Then Open the received email
    And CheckCostResult
