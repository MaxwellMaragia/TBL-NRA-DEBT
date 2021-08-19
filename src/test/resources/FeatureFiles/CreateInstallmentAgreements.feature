Feature: [SUC:08-03]-Create Installment Agreements, [SUC:08-04]-Approve Installment Agreements
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:08-03 @SUC:08-04 @UAT_M8-08-03-01 @UAT_M8-08-03-02 @UAT_M8-08-03-06 @UAT_M8-08-04-01 @UAT_M8-08-04-02 @backoffice
  Scenario: UAT_M8-08-03-02-Verify the process of add related documents-Verify the process of installment agreement-Organization
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "1000048802"
    Then Switch to default
    Then Select taxtype under outstanding debt "Pay As You Earn"
    Then Click add under outstanding debts
    Then Switch to backoffice frame
    Then Select return type under outstanding debts "Pay As You Earn Return"
    Then Select period and year under outstanding debts "9/2020"
    Then Enter value of debt as "200"
    Then Click ok under installment agreements
    Then Switch to default
    Then Enter number of installments as "1"
    Then Select payment frequency as "Weekly"
    Then Select first installment due date as today
    Then Select reason for installment "Cash Flow Problem"
    Then Select office as "Balaka"
    Then Enter notes for agreement
    ##adding additional documents
    Then Click add under related documents
    Then Switch to backoffice frame
    Then Select related document type as "PAYE Returns"
    Then Click search to search for document
    Then Verify data for return document "PAYE Returns" is populated in table
    Then Click calculate to calculate installment plan
    Then Verify calculation data is populated in table
    Then Click save to submit installment agreement
    Then Verify success message "Instalment Agreement with reference no"
    Then Obtain installment agreement ARN "Instalment Agreement with reference no"
    Then Open CRM and close modal
    Then Click on debt application link
    Then switch to frame0
    Then search for reference number
    Then Click on reference number
    Then switch to frame1
    Then approve transaction
    Then Click save CRM
    Then switch to frame1
    Then Debt installment status should be "Approved"

  @SUC:08-03 @UAT_M8-08-03-03 @backoffice
  Scenario: UAT_M8-08-03-03-Verify the process of installment agreement-Individual
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "C0023193"
    Then Switch to default
    Then Select taxtype under outstanding debt "Personal Income Tax"
    Then Click add under outstanding debts
    Then Switch to backoffice frame
    Then Select return type under outstanding debts "Personal Income Tax(PIT) Return"
    Then Select period and year under outstanding debts "1/2021"
    Then Enter value of debt as "2000"
    Then Click ok under installment agreements
    Then Switch to default
    Then Enter number of installments as "1"
    Then Select payment frequency as "Weekly"
    Then Select first installment due date as today
    Then Select reason for installment "Cash Flow Problem"
    Then Select office as "Balaka"
    Then Enter notes for agreement
    ##adding additional documents
    Then Click add under related documents
    Then Switch to backoffice frame
    Then Select related document type as "Personal Income Tax(PIT) Return"
    Then Click search to search for document
    Then Verify data for return document "Personal Income Tax(PIT) Return" is populated in table
    Then Click calculate to calculate installment plan
    Then Verify calculation data is populated in table
    Then Click save to submit installment agreement
    Then Verify success message "Instalment Agreement with reference no"
    Then Obtain installment agreement ARN "Instalment Agreement with reference no"
    Then Open CRM and close modal
    Then Click on debt application link
    Then switch to frame0
    Then search for reference number
    Then Click on reference number
    Then switch to frame1
    Then approve transaction
    Then Click save CRM
    Then switch to frame1
    Then Debt installment status should be "Approved"

  @SUC:08-04 @UAT_M8-08-04-03 @backoffice
  Scenario: UAT_M8-08-03-03-Verify the process of Reject installment agreement
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "C0023193"
    Then Switch to default
    Then Select taxtype under outstanding debt "Personal Income Tax"
    Then Click add under outstanding debts
    Then Switch to backoffice frame
    Then Select return type under outstanding debts "Personal Income Tax(PIT) Return"
    Then Select period and year under outstanding debts "1/2021"
    Then Enter value of debt as "2000"
    Then Click ok under installment agreements
    Then Switch to default
    Then Enter number of installments as "1"
    Then Select payment frequency as "Weekly"
    Then Select first installment due date as today
    Then Select reason for installment "Cash Flow Problem"
    Then Select office as "Balaka"
    Then Enter notes for agreement
    ##adding additional documents
    Then Click add under related documents
    Then Switch to backoffice frame
    Then Select related document type as "Personal Income Tax(PIT) Return"
    Then Click search to search for document
    Then Verify data for return document "Personal Income Tax(PIT) Return" is populated in table
    Then Click calculate to calculate installment plan
    Then Verify calculation data is populated in table
    Then Click save to submit installment agreement
    Then Verify success message "Instalment Agreement with reference no"
    Then Obtain installment agreement ARN "Instalment Agreement with reference no"
    Then Open CRM and close modal
    Then Click on debt application link
    Then switch to frame0
    Then search for reference number
    Then Click on reference number
    Then switch to frame1
    Then reject transaction after text "Instalment Agreement Number:" loads
    Then switch to frame1
    Then Enter Outcome Notes "Invalid"
    Then Enter Outcome Reason
    Then Click save CRM
    Then switch to frame1
    Then Debt installment status should be "Rejected"

  @SUC:08-03 @UAT_M8-08-03-04 @backoffice
  Scenario: UAT_M8-08-03-04-Verify the process of validation errors
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "C0023193"
    Then Switch to default
    Then Select taxtype under outstanding debt "Personal Income Tax"
    Then Click add under outstanding debts
    Then Switch to backoffice frame
    Then Select return type under outstanding debts "Personal Income Tax(PIT) Return"
    Then Select period and year under outstanding debts "1/2021"
    Then Enter value of debt as "2000"
    Then Click ok under installment agreements
    Then Switch to default
    Then Click save to submit installment agreement
    Then Verify error message "Number of Instalments: Validation Error: Value is required."
    Then Verify error message "Payment Frequency: Validation Error: Value is required."
    Then Verify error message "First Instalment Due Date: Validation Error: Value is required."
    Then Verify error message "Reason: Validation Error: Value is required."
    Then Verify error message "Office: Validation Error: Value is required."
    Then Verify error message "Notes: Validation Error: Value is required."

  @SUC:08-03 @UAT_M8-08-03-05 @backoffice
  Scenario: UAT_M8-08-03-05-Verify the process taxpayer not found
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "P0020677797"
    Then Verify no data is found in table

  @SUC:08-03 @UAT_M8-08-03-07 @backoffice
  Scenario: UAT_M8-08-03-07-Verify the process of view related documents
    And Click on debt management > Installment agreements > Create installment agreement
    Then Find taxpayer using tin "C0023193"
    Then Switch to default
    Then Select taxtype under outstanding debt "Personal Income Tax"
    Then Click add under outstanding debts
    Then Switch to backoffice frame
    Then Select return type under outstanding debts "Personal Income Tax(PIT) Return"
    Then Select period and year under outstanding debts "1/2021"
    Then Enter value of debt as "2000"
    Then Click ok under installment agreements
    Then Switch to default
    Then Enter number of installments as "1"
    Then Select payment frequency as "Weekly"
    Then Select first installment due date as today
    Then Select reason for installment "Cash Flow Problem"
    Then Select office as "Balaka"
    Then Enter notes for agreement
    ##adding additional documents
    Then Click add under related documents
    Then Switch to backoffice frame
    Then Select related document type as "Personal Income Tax(PIT) Return"
    Then Click search to search for document
    Then Verify data for return document "Personal Income Tax(PIT) Return" is populated in table
    Then Click return document table row
    Then Click view to view return document
    #depending on taxtype check if it goes to lodge or file
    Then Verify return document screen is displayed with readonly fields
    Then Click cancel to return to create installment screen
    Then Remove return document
    Then Verify success message "Record Deleted"


