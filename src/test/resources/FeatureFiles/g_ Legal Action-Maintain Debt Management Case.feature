Feature: [SUC:08-02] Maintain Debt Management Case - Legal Action

  @Legal-Action
  Scenario: UAT_M8_08-02-07-UAT_M8_08-02-11-Verify the Process of Escalated Case - Legal Action -Debt Officer
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
    When user enters Enforcement Action "Referral to Legal" and Reason "Legal Action"
    And clicks Submit button
    Then Debt status should be "Legal Action Applied"
    And wait for plan to load "Total Tax Debt"
    When user clicks add Tax Debt Collected by Legal
    Then Debt status should be "Legal Action Applied"
    And wait for plan to load "Tax Type"
    When user enters Tax Type Period  and Debt Amount "200000"
    And Legal Action clicks Submit button
    Then switch to frame1
    Then Debt status should be "Pending Legal Action Approval By Tax Collector"

  @Legal-Action
  Scenario: UAT_M8_08-02-07-UAT_M8_08-02-11-Verify the Process of Escalated Case - Legal Action   -TaxCollector
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
    Then Debt status should be "Pending Legal Action Approval By Tax Collector"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "taxcollector"
    Then Click on Save button
    Then Debt status should be "Pending Legal Action Approval By Station Manager"

  @Legal-Action
  Scenario: UAT_M8_08-02-07-UAT_M8_08-02-11-Verify the Process of Escalated Case - Legal Action   -StationManager
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
    Then Debt status should be "Pending Legal Action Approval By Station Manager"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "stationmanager"
    Then Click on Save button
    Then Debt status should be "Pending Legal Action Approval By Deputy Commissioner Operations"

  @Legal-Action
  Scenario: UAT_M8_08-02-07-UAT_M8_08-02-11-Verify the Process of Escalated Case - Legal Action   -Deputy Commissioner Operations
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
    Then Debt status should be "Pending Legal Action Approval By Deputy Commissioner Operations"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "deputycommissioneroperations"
    Then Click on Save button
    Then Debt status should be "Pending Legal Action Approval By Domestic Taxes Commissioner"

  @Legal-Action
  Scenario: UAT_M8_08-02-07-UAT_M8_08-02-11-Verify the Process of Escalated Case - Legal Action   -Domestic Taxes Commissioner
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
    Then Debt status should be "Pending Legal Action Approval By Domestic Taxes Commissioner"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "domestictaxescommissioner"
    Then Click on Save button
    Then Debt status should be "Pending Legal Action Approval By Commissioner General"

  @Legal-Action
  Scenario: UAT_M8_08-02-07-UAT_M8_08-02-11-Verify the Process of Escalated Case - Legal Action  -Commissioner General
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
    Then Debt status should be "Pending Legal Action Approval By Commissioner General"
    And wait for plan to load "Total Tax Debt"
    Then switch to frame1
    And Select Approval outcome value to Approve "commissionergeneral"
    Then Click on Save button
    Then Debt status should be "Legal Action Approved By Commissioner General"

  @Legal-Action
  Scenario: UAT_M8_08-02-07-UAT_M8_08-02-11-Verify the Process of Continue Debt Management Case		 - Legal Action   -Debt Officer
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



