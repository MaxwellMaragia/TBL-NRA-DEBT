Feature: [SUC:08-03]-Create Debt Management Case
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

#    make sure return is logged for user/indv taxtype

  @Write-Off
  @Agent-Appointment
  @Lien-Imposition
  @Distraint-Action
  @Distraint-Action-reject
  @Enforcement-Suspension
  @Legal-Action
  @Agent-Appointment-close
  @Verification_of_debt
  @SUC:08-01 @UAT_M8-08-01-01 @UAT_M8-08-01-02
  Scenario: UAT_M8-08-01-01-Verify the process of installment agreement-Organization
    And Click on debt management > Create debt management case
    And enter "1000066800" and click search
    Then CREATE DEBT MANAGEMENT CASE window is placed
    When the user enters taxtype "Pay As You Earn" and value of debt "1000" return tpe and period "1/2021"
#    Then CREATE DEBT MANAGEMENT CASE window is placed
    Then Switch to default
    When User enters Case Title "Case debt" and Office "BOMTO"
    Then Verify message "Processing Completed - Reference Number"
    Then  Verify the ARN number "<ARN>"


  @SUC:08-01 @UAT_M8-08-01-03
  Scenario: UAT_M8-08-01-01-Verify the process of installment agreement-Individual
    And Click on debt management > Create debt management case
    And enter "C0021739" and click search
    Then CREATE DEBT MANAGEMENT CASE window is placed
    When the user enters taxtype "Domestic Excise" and value of debt "1000000" return tpe and period ""

  @SUC:08-01 @UAT_M8-08-01-04
  Scenario: UAT_M8-08-01-01-Verify the process of System creates Debt Management Case
    And Click on Accounting > Dishonoured Payment
    Then Find Payment To Dishonour page is displayed
    When user enters TIN "%" to find dishonour payment details
    And selects a dishonored payment from table
    Then Dishonoured Payment page is displayed
    When user enters Dishonoured Date  and Reason "Instrument Dishonoured"
    Then Verify message "The Payment is dishonoured successfully for Receipt Id"

  @SUC:08-01 @UAT_M8-08-01-05
  Scenario: UAT_M8-08-01-01-Verify the process of Validation Field
    And Click on debt management > Create debt management case
    And enter "C0021739" and click search
    Then CREATE DEBT MANAGEMENT CASE window is placed
    When the user leaves details blank and clicks submit
    Then Verify message "Validation Error: Value is required"
#    When the user enters taxtype "Non Resident Tax(NRT)" and value of debt " "
    Then Verify message "Validation Error: Value is required"


