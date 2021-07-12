Feature: [SUC:08-07]-Generate debt management reports

  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login
    Then Click reporting > reports

  @SUC:08-07 @UAT_M8-08-07-01 @backoffice @reports
  Scenario: UAT_M8-08-07-01-Verify the process of print Report-Aged Arreas Analysis report
    Then Select report to print "Aged Arrears Analysis Report"
    Then Select report file type "PDF"
#    Then Select tax office "All"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Aged Arrears Analysis Report.pdf" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Aged Arrears Analysis Report.xls" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"

  @SUC:08-07 @UAT_M8-08-07-02 @backoffice @reports
  Scenario: UAT_M8-08-07-02-Verify the process of print Debt-recovery report
    Then Select report to print "Debt Recovery Report"
    Then Select report file type "PDF"
#    Then Select ending date as today
#    Then Select tax office "All"
#    Then Select return type
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Debt Recovery Report.pdf" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Debt Recovery Report.xls" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"

  @SUC:08-07 @UAT_M8-08-07-03 @backoffice @reports
  Scenario: UAT_M8-08-07-03-Verify the process of installment agreement summary report
    Then Select report to print "Instalment Agreement Summary Report"
    Then Select report file type "PDF"
    Then Select ending date as today
    Then Select tax office "All"
    Then Select return type
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Instalment Agreement Summary Report.pdf" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Instalment Agreement Summary Report.xls" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"

  @SUC:08-07 @UAT_M8-08-07-04 @backoffice @reports
  Scenario: UAT_M8-08-07-04-Verify the process of taxpayer debt report
    Then Select report to print "Taxpayer Debt Report"
    Then Select report file type "PDF"
#    Then Select ending date as today
#    Then Select return type
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Taxpayer Debt Report.pdf" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Taxpayer Debt Report.xls" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"

  @SUC:08-07 @UAT_M8-08-07-05 @backoffice @reports
  Scenario: UAT_M8-08-07-05-Verify the process of write off report
    Then Select report to print "Write Off Report"
    Then Select report file type "PDF"
    Then Select ending date as today
    Then Select tax office "All"
    Then Select return type
    Then Select business sector
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Write Off Report.pdf" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Write Off Report.xls" has been downloaded in downloads directory "C:\\Users\\Maxipain\\Downloads"

  @SUC:08-07 @UAT_M8-08-07-06 @backoffice @reports
  Scenario: UAT_M8-08-07-06-Verify the process of validation errors
    Then Select report to print "Write Off Report"
    Then Select report file type "PDF"
    Then Select ending date as today
    Then Click run report "frmReportDetails:RunReport"
    Then Verify error message "Tax Office: Validation Error: Value is required."
    Then Verify error message "Tax Type: Validation Error: Value is required."
    Then Verify error message "Business Sector: Validation Error: Value is required."

  @SUC:08-07 @UAT_M8-08-07-07 @backoffice @reports
  Scenario: UAT_M8-08-07-07-Verify the process of abandon report
    Then Select report to print "Write Off Report"
    Then Select report file type "PDF"
    Then Select ending date as today
    Then Click cancel to abandon report
    Then user is navigated back to "http://34.241.245.79:8080/trips-ui/faces/reports/ReportTree.xhtml"



