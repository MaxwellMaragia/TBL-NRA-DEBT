Feature: [SUC:08-02] Maintain Debt Management Case


  @Enforcement-Suspension
  Scenario: UAT_M8_08-02-06-Verify the Process of Escalated Case -Enforcement Suspension -Debt Officer
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
    When user enters Enforcement Action "Enforcement Suspension" and Reason "Enforcement Suspension"
    And clicks Submit button
    Then Debt status should be "Enforcement Suspension"
    And wait for plan to load "Total Tax Debt"
    When user enters Reason for Enforcement Suspension
    And Enforcement Suspension clicks Submit button
    Then switch to frame1
    Then Debt status should be "Pending Enforcement Suspension Approval By Tax Collector"


  @Enforcement-Suspension
  Scenario: UAT_M8_08-02-06-Verify the Process of Escalated Case -Enforcement Suspension  -TaxCollector
    Given Open CRM URL Module as "tripscrmuser2"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And pick the debt case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Enforcement Suspension Approval By Tax Collector"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "taxcollector"
    Then Click on Save button
    Then Debt status should be "Pending Enforcement Suspension Approval By Station Manager"


  @Enforcement-Suspension
  Scenario: UAT_M8_08-02-06-Verify the Process of Escalated Case -Enforcement Suspension  -StationManager
    Given Open CRM URL Module as "tripscrmuser3"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Enforcement Suspension Approval By Station Manager"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "stationmanager"
    Then Click on Save button
    Then Debt status should be "Pending Enforcement Suspension Approval By Deputy Commissioner Operations"

  @Enforcement-Suspension
  Scenario: UAT_M8_08-02-06-Verify the Process of Escalated Case -Enforcement Suspension  -Deputy Commissioner Operations
    Given Open CRM URL Module as "tripscrmuser4"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
#    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Enforcement Suspension Approval By Deputy Commissioner Operations"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "deputycommissioneroperations"
    Then Click on Save button
    Then Debt status should be "Pending Enforcement Suspension Approval By Domestic Taxes Commissioner"

  @Enforcement-Suspension
  Scenario: UAT_M8_08-02-06-Verify the Process of Escalated Case -Enforcement Suspension  -Domestic Taxes Commissioner
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
    Then Debt status should be "Pending Enforcement Suspension Approval By Domestic Taxes Commissioner"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "domestictaxescommissioner"
    Then Click on Save button
    Then Debt status should be "Pending Enforcement Suspension Approval By Commissioner General"
#
  @Enforcement-Suspension
  Scenario: UAT_M8_08-02-06-Verify the Process of Escalated Case -Enforcement Suspension  -Commissioner General
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
    Then Debt status should be "Pending Enforcement Suspension Approval By Commissioner General"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "commissionergeneral"
    Then Click on Save button
    Then Debt status should be "Enforcement Suspension Approved By Commissioner General"
#
  @Enforcement-Suspension
  Scenario: UAT_M8_08-02-06-Verify the Process of Escalated Case -Enforcement Suspension  -Debt Officer
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
    Then Debt status should be "Enforcement Suspension Approved By Commissioner General"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    Then Debt status should be "Enforcement Suspension Approved By Commissioner General"



