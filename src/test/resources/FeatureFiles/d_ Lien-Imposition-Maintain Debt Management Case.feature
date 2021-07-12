Feature: [SUC:08-02] Maintain Debt Management Case

  @Lien-Imposition-cancel
  Scenario: UAT_M8_08-02-04-UAT_M8_08-02-08Verify the Process of Escalated Case -Lien Imposition -Debt Officer
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
    When user enters Enforcement Action "Cancel Lien" and Reason "Lien Imposition"
    And clicks Submit button
    Then switch to frame1
    Then Debt status should be "Lien Imposition Cancelled"

  @Lien-Imposition
  Scenario: UAT_M8_08-02-04-UAT_M8_08-02-08Verify the Process of Escalated Case -Lien Imposition -Debt Officer
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
    When user enters Enforcement Action "Lien Imposition" and Reason "Lien Imposition"
    And clicks Submit button
    Then Debt status should be "Lien Imposition"
    And wait for plan to load "Lien Number"
    When user clicks add Asset Summary Personal Property
    Then Debt status should be "Lien Imposition"
    And wait for plan to load "Asset Name"
    When user enters Asset Summary Personal Property
      | Asset Name          | testName        |
      | Asset Description   | testDescription |
      | Book Value          | 1000            |
      | Market Value        | 1000            |
      | Registration Number | 11111           |
      | Title Owner         | testOwner       |
    When user clicks add Asset Summary Real Property
    Then Debt status should be "Lien Imposition"
    And wait for plan to load "Asset Name"
    When user enters Asset Summary Real Property
      | Asset Name        | testName        |
      | Asset Description | testDescription |
      | Book Value        | 1000            |
      | Market Value      | 1000            |
      | Plot Number       | 11111           |
      | Title Owner       | testOwner       |
    Then switch to frame1
    And wait for plan to load "Total Debt"
    When user enters Public Office Name"testoffice" Address "testaddress" and Place of Filing "testLocation"
    And Lien Imposition clicks Submit button
    Then switch to frame1
    Then Debt status should be "Pending Lien Imposition Approval By Tax Collector"

  @Lien-Imposition
  Scenario: UAT_M8_08-02-04-UAT_M8_08-02-08Verify the Process of Escalated Case -Lien Imposition -TaxCollector
    Given Open CRM URL Module as "tripscrmuser2"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Debt reference number in search results
    And picks the audit case
#    And pick the debt case
    Then switch to frame0
    Then Click on reference number
    Then Debt status should be "Pending Lien Imposition Approval By Tax Collector"
    And wait for plan to load "Lien Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "taxcollector"
    Then Click on Save button
    Then Debt status should be "Pending Lien Imposition Approval By Station Manager"

  @Lien-Imposition
  Scenario: UAT_M8_08-02-04-UAT_M8_08-02-08Verify the Process of Escalated Case -Lien Imposition -StationManager
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
    Then Debt status should be "Pending Lien Imposition Approval By Station Manager"
    And wait for plan to load "Lien Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "stationmanager"
    Then Click on Save button
    Then Debt status should be "Pending Lien Imposition Approval By Deputy Commissioner Operations"

  @Lien-Imposition
  Scenario: UAT_M8_08-02-04-UAT_M8_08-02-08Verify the Process of Escalated Case -Lien Imposition -Deputy Commissioner Operations
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
    Then Debt status should be "Pending Lien Imposition Approval By Deputy Commissioner Operations"
    And wait for plan to load "Lien Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "deputycommissioneroperations"
    Then Click on Save button
    Then Debt status should be "Pending Lien Imposition Approval By Domestic Taxes Commissioner"

  @Lien-Imposition
  Scenario: UAT_M8_08-02-04-UAT_M8_08-02-08Verify the Process of Escalated Case -Lien Imposition -Domestic Taxes Commissioner
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
    Then Debt status should be "Pending Lien Imposition Approval By Domestic Taxes Commissioner"
    And wait for plan to load "Lien Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "domestictaxescommissioner"
    Then Click on Save button
    Then Debt status should be "Pending Lien Imposition Approval By Commissioner General"

  @Lien-Imposition
  Scenario: UAT_M8_08-02-04-UAT_M8_08-02-08Verify the Process of Escalated Case -Lien Imposition -Commissioner General
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
    Then Debt status should be "Pending Lien Imposition Approval By Commissioner General"
    And wait for plan to load "Lien Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "commissionergeneral"
    Then Click on Save button
    Then Debt status should be "Lien Imposition Approved By Commissioner General"

  @Lien-Imposition
  Scenario: UAT_M8_08-02-04-UAT_M8_08-02-0-Verify the Process of Approval Required -Debt Officer
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
    Then Debt status should be "Lien Imposition Approved By Commissioner General"
    And wait for plan to load "Lien Number"
    Then switch to frame1
    Then Debt status should be "Lien Imposition Approved By Commissioner General"



