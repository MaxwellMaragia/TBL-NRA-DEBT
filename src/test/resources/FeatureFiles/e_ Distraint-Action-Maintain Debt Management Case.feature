Feature: [SUC:08-02] Maintain Debt Management Case - Distraint Action

  @Distraint-Action @Distraint-Action-reject 
  Scenario: UAT_M8_08-02-05-Verify the Process of Escalated Case - Distraint Action -Debt Officer
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
    When user enters Enforcement Action "Distraint Action" and Reason "Distraint Action"
    And clicks Submit button
    Then Debt status should be "Distraint Action"
    And wait for plan to load "Total Tax Debt"
    When user clicks add Asset Seized
    And wait for plan to load "Asset Name"
    When user enters Asset Seized
      | Asset Name          | testName        |
      | Asset Description   | testDescription |
      | Book Value          | 1000            |
      | Market Value        | 1000            |
      | Title Owner         | testOwner       |
    Then switch to frame1
    And wait for plan to load "Total Tax Debt"
    When user enters summary cost Costs "1000"
    And Distraint Action clicks Submit button
    Then switch to frame1
    Then Debt status should be "Pending Distraint Action Approval By Tax Collector"


  @Distraint-Action-reject
  Scenario: UAT_M8_08-02-09-Verify the Process of Rejection of Request - Distraint Action -TaxCollector
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
    Then Debt status should be "Pending Distraint Action Approval By Tax Collector"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Reject outcome dropdown value to Approve "taxcollector"
    Then switch to frame1
    And enters manager comments "Manager test comment"
    Then Enter Outcome Notes "Invalid documentation"
    Then Enter Outcome Reason
    And Click on Save button
    Then Debt status should be "Debt Distraint Action Rejected"


  @Distraint-Action
  Scenario: UAT_M8_08-02-05-Verify the Process of Escalated Case - Distraint Action -TaxCollector
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
    Then Debt status should be "Pending Distraint Action Approval By Tax Collector"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "taxcollector"
    Then Click on Save button
    Then Debt status should be "Pending Distraint Action Approval By Station Manager"

  @Distraint-Action
  Scenario: UAT_M8_08-02-05-Verify the Process of Escalated Case - Distraint Action -StationManager
    Given Open CRM URL Module as "tripscrmuser3"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Distraint Action Approval By Station Manager"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "stationmanager"
    Then Click on Save button
    Then Debt status should be "Pending Distraint Action Approval By Deputy Commissioner Operations"

  @Distraint-Action
  Scenario: UAT_M8_08-02-05-Verify the Process of Escalated Case - Distraint Action -Deputy Commissioner Operations
    Given Open CRM URL Module as "tripscrmuser4"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
    And click pick button
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Distraint Action Approval By Deputy Commissioner Operations"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "deputycommissioneroperations"
    Then Click on Save button
    Then Debt status should be "Pending Distraint Action Approval By Domestic Taxes Commissioner"

  @Distraint-Action
  Scenario: UAT_M8_08-02-05-Verify the Process of Escalated Case - Distraint Action -Domestic Taxes Commissioner
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
    Then Debt status should be "Pending Distraint Action Approval By Domestic Taxes Commissioner"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "domestictaxescommissioner"
    Then Click on Save button
    Then Debt status should be "Pending Distraint Action Approval By Commissioner General"
#
  @Distraint-Action
  Scenario: UAT_M8_08-02-05-Verify the Process of Escalated Case - Distraint Action -Commissioner General
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
    Then Debt status should be "Pending Distraint Action Approval By Commissioner General"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "commissionergeneral"
    Then Click on Save button
    Then Debt status should be "Distraint Action Approved"
#
  @Distraint-Action
  Scenario: UAT_M8_08-02-05-Verify the Process of Escalated Case - Distraint Action -Debt Officer
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
    Then Debt status should be "Distraint Action Approved"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    Then Debt status should be "Distraint Action Approved"



