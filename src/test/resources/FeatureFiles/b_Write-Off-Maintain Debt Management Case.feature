Feature: [SUC:08-02] Maintain Debt Management Case - Write-Off

  @Debt-Officer
  Scenario:UAT_M8_08-02-10-Verify the Process of Validation Failed - Write-Off -Debt-Officer
    Given Open CRM URL Module as "tripscrmuser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "New"
    And wait for plan to load "Total Debt:"
#    When user enters Enforcement Action "Debt Write Off" and Reason "Debt Write Off"
    And clicks Submit button
    Then switch to frame1
    Then validation error displayed " This field can not be empty. "

  @Write-Off
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off -Debt-Officer
    Given Open CRM URL Module as "tripscrmuser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "New"
    And wait for plan to load "Total Debt:"
    When user enters Enforcement Action "Debt Write Off" and Reason "Debt Write-Off"
    And clicks Submit button
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Total Debt to be Written Off"
    And wait for plan to load "Total Written Off Tax Debt"
    When user clicks add Writen Off Tax Debt
    Then Debt status should be "Escalated - Write Off"
    And wait for plan to load "Tax Type"
    When user enters Tax Type Period  and Debt Amount "200000"
    Then switch to frame1
    And wait for plan to load "Total Written Off Tax Debt"
    When user enters Debt Write-Off Reason
    And Writen Off Tax Debt clicks Submit button
    Then switch to frame1
    Then Debt status should be "Pending Write Off Approval By Tax Collector"

  @taxCollector @Write-Off
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off -Tax Collector
    Given Open CRM URL Module as "tripscrmuser2"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Tax Collector"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "taxcollector"
    Then Click on Save button
    Then Debt status should be "Pending Write Off Approval By Station Manager"

  @stationmanager @Write-Off
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off -Station Manager
    Given Open CRM URL Module as "tripscrmuser3"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And pick the case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Station Manager"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "stationmanager"
    Then Click on Save button
    Then Debt status should be "Pending Write Off Approval By Deputy Commissioner Operations"

  @DeputyComOp @Write-Off
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off -Deputy Commissioner Operations
    Given Open CRM URL Module as "tripscrmuser4"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And pick the case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Deputy Commissioner Operations"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "deputycommissioneroperations"
    Then Click on Save button
    Then Debt status should be "Pending Write Off Approval By Domestic Taxes Commissioner"

  @DomTaxCom @Write-Off
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off -Domestic Taxes Commissioner
    Given Open CRM URL Module as "tripscrmuser5"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Domestic Taxes Commissioner"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "domestictaxescommissioner"
    Then Click on Save button
    Then Debt status should be "Pending Write Off Approval By Commissioner General"

  @ComGen @Write-Off
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off -Commissioner General
    Given Open CRM URL Module as "tripscrmuser6"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Write Off Approval By Commissioner General"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    And Select Approval outcome value to Approve "commissionergeneral"
    Then Click on Save button
    Then Debt status should be "Write Off Approved"

  @debtofficer @Write-Off
  Scenario: UAT_M8_08-02-01-UAT_M8_08-02-02-Verify the Process of Escalated Case - Write-Off -DebtOfficer
    Given Open CRM URL Module as "tripscrmuser1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Write Off Approved"
    And wait for plan to load "Total Debt to be Written Off"
    Then switch to frame1
    Then Debt status should be "Write Off Approved"



