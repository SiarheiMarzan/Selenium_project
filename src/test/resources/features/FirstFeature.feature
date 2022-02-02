Feature: Google Cloud Platform Pricing Calculator

  Description: To calculate the cost of renting a cloud platform

  Scenario: Search Google Cloud Platform Pricing Calculator in Google
    When Open start google page
    Then Enter message in the search text box
    And Select the first result

    When Open Iframe
    And Activate section 'Compute Engine'
    Then Click field 'Number of instance:' and input value
    Then Select the field series value
    Then Select the instance type value
    Then Activate section 'Add GPUs'
    Then Click filed 'typeGPU' and select NVIDIA Tesla 100
    Then Click field 'Number of GPUs' and select value 'Number of GPUs'
    Then Click field 'LocalSSD' and select value 2x375Gb
    Then Click section Datacenter location and select Frankfurt europe-west3
    Then Click section 'Committed usage' and select value '1 Year'
    Then Click button 'Add to Estimate'
    Then Saving the string value 'Total Estimated Cost'
    Then Click button 'Email Estimate'

    When Switching to a new tab and creating temporary mail
    Then Click on the copy button address email
    And Return to the calculator page

    When Clicking on field for input email
    Then Inserting the copied email address from the created mail
    And Click button 'Send Email'
    And Return to the email page

    When Open the received email
