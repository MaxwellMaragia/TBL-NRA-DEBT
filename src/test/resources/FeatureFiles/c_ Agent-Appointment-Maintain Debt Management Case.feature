Feature: [SUC:08-02] Maintain Debt Management Case

  @Agent-Appointment-close
  Scenario: UAT_M8_08-02-12-Verify the Process of Close Debt Management Case - Agent Appointment- Debt Officer
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
    When user enters Enforcement Action "Appointment of Agent" and Reason "Appointment of Agent"
    And clicks close case checkbox
    And enters case closure details reason for closure
    And clicks close case Submit button
    Then Debt status should be "closed"

  @Agent-Appointment
  Scenario: UAT_M8_08-02-03-UAT_M8_08-02-16-UAT_M8_08-02-17-UAT_M8_08-02-18-Verify the Process of Escalated Case - Agent Appointment- Debt Officer
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
    When user enters Enforcement Action "Appointment of Agent" and Reason "Appointment of Agent"
    And clicks Submit button
    Then Debt status should be "Appointment of Agent"
    And wait for plan to load "Appointment of Agent Number"
    When user clicks add Appointment of Agent
    Then Debt status should be "Appointment of Agent"
    And wait for plan to load "Agent Name"
    When user enters Appointment of Agent details
      | Agent Name       | testAgent   |
      | Agent TIN        | P0020804    |
      | Postal Address   | testAddress |
      | Physical Address | testAddress |
    Then switch to frame1
    And wait for plan to load "Appointment of Agent Number"
    And Appointment of Agent clicks Submit button
    Then switch to frame1
    Then Debt status should be "Pending Agent Approval By Tax Collector"

  @taxCollector @Agent-Appointment
  Scenario: UAT_M8_08-02-03-UAT_M8_08-02-16-UAT_M8_08-02-17-UAT_M8_08-02-18-Verify the Process of Escalated Case - Agent Appointment -TaxCollector
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
    Then Debt status should be "Pending Agent Approval By Tax Collector"
    And wait for plan to load "Appointment of Agent Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "taxcollector"
    Then Click on Save button
    Then Debt status should be "Pending Agent Approval By Station Manager"

  @stationmanager @Agent-Appointment
  Scenario: UAT_M8_08-02-03-UAT_M8_08-02-16-UAT_M8_08-02-17-UAT_M8_08-02-18-Verify the Process of Escalated Case - Agent Appointment -StationManager
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
    Then Debt status should be "Pending Agent Approval By Station Manager"
    And wait for plan to load "Appointment of Agent Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "stationmanager"
    Then Click on Save button
    Then Debt status should be "Pending Agent Approval By Deputy Commissioner Operations"

  @DeputyComOp @Agent-Appointment
  Scenario: UAT_M8_08-02-03-UAT_M8_08-02-16-UAT_M8_08-02-17-UAT_M8_08-02-18-Verify the Process of Escalated Case - Agent Appointment -Deputy Commissioner Operations
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
    Then Debt status should be "Pending Agent Approval By Deputy Commissioner Operations"
    And wait for plan to load "Appointment of Agent Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "deputycommissioneroperations"
    Then Click on Save button
    Then Debt status should be "Pending Agent Approval By Domestic Taxes Commissioner"

  @DomTaxCom @Agent-Appointment
  Scenario: UAT_M8_08-02-03-UAT_M8_08-02-16-UAT_M8_08-02-17-UAT_M8_08-02-18-Verify the Process of Escalated Case - Agent Appointment -Domestic Taxes Commissioner
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
    Then Debt status should be "Pending Agent Approval By Domestic Taxes Commissioner"
    And wait for plan to load "Appointment of Agent Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "domestictaxescommissioner"
    Then Click on Save button
    Then Debt status should be "Pending Agent Approval By Commissioner General"

  @ComGen @Agent-Appointment
  Scenario: UAT_M8_08-02-03-UAT_M8_08-02-16-UAT_M8_08-02-17-UAT_M8_08-02-18-Verify the Process of Escalated Case - Agent Appointment -Commissioner General
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
    Then Debt status should be "Pending Agent Approval By Commissioner General"
    And wait for plan to load "Appointment of Agent Number"
    Then switch to frame1
    And Select Approval outcome value to Approve "commissionergeneral"
    Then Click on Save button
    Then Debt status should be "Agent Approved By Commissioner General"

  @debtofficer @Agent-Appointment
  Scenario: UAT_M8_08-02-03-UAT_M8_08-02-16-UAT_M8_08-02-17-UAT_M8_08-02-18-Verify the Process of Escalated Case - Agent Appointment -Debt Officer
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
    Then Debt status should be "Agent Approved By Commissioner General"
    And wait for plan to load "Appointment of Agent Number"
    Then switch to frame1
    Then Debt status should be "Agent Approved By Commissioner General"



