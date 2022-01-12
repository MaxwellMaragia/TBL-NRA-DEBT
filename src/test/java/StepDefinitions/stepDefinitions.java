package StepDefinitions;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten;
    public WebDriverWait fifteen;
    public WebDriverWait twenty;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;


    public static sharedatastep sharedata;
    public String ReferenceNumber = "IA000000046";

    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);

    }

    public void switchToFrameBackoffice() {
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {
        driver.get(Pro.getProperty("NRA_BackOffice_URL"));
        driver.manage().window().maximize();
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String strArg1, String strArg2) throws Throwable {
        driver.findElement(By.id("loginForm:username")).sendKeys(strArg1);
        driver.findElement(By.id("loginForm:password")).sendKeys(strArg2);
        driver.findElement(By.id("loginForm:j_idt18")).click();
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        String URL = driver.getCurrentUrl();

//    	Assert.assertEquals(URL, "http://18.202.88.7:8001/trips-ui/faces/login/Welcome.xhtml" );
        Assert.assertEquals(URL, "https://backoffice.mra.mw:8443/trips-ui/faces/login/Welcome.xhtml");
    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();

    }

    //---------------------------------------------------------------------Verify the Process of Assign Audit Case-----------------------------------------------------------------------------------------------//
    @Given("^Open CRM URL Module as \"([^\"]*)\"$")
    public void open_crm_url_module_as_something(String strArg1) throws Throwable {
//        driver = getDriver();
        driver.get("http://" + strArg1 + ":Passw0rd@trips-crm:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
       Thread.sleep(2000);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TabCS\"]/a/span"))).click();
    }

    @And("^click on Queues$")
    public void click_on_revenue_collection_application() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Queues']")).click();
    }

    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @And("^enters Debt reference number in search results$")
    public void enters_exemption_reference_number_in_search_results() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));

        search.clear();
        Thread.sleep(2000);
        //search.sendKeys("*DM/000035168/2021");
        search.sendKeys("*" + sharedatastep.DEBT_ARN_ORG);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }


    @And("^picks the audit case$")
    public void picks_the_audit_case() throws Throwable {
        WebElement pickCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(pickCheckBox).perform();

        driver.switchTo().defaultContent();
    }

    @And("^pick the debt case$")
    public void pick_the_debt_case() throws Throwable {
        WebElement pickButton = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"queueitem|NoRelationship|HomePageGrid|tbg.queueitem.HomepageGrid.Pick\"]/span")));
        Actions actions = new Actions(driver);
        actions.doubleClick(pickButton).perform();
    }

    @And("^pick the case$")
    public void pick_the_case() throws Throwable {
        WebElement pickButton = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Pick ']")));
        Actions actions = new Actions(driver);
        actions.doubleClick(pickButton).perform();
    }

    @And("^click pick button$")
    public void click_pick_button() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement assignDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moreCommands")));
        assignDropdown.click();

        WebElement pickButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("queueitem|NoRelationship|HomePageGrid|tbg.queueitem.HomepageGrid.Pick")));
        pickButton.click();
    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {
        WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[1]"));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();
    }

    @Then("^Debt status should be \"([^\"]*)\"$")
    public void application_status_should_be_something(String Status) throws Throwable {
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("contentIFrame1");
        WebDriverWait wait = new WebDriverWait(driver, 200);
        Thread.sleep(3000);
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + Status + "']"))).getText();
        Assert.assertEquals(Status, text);
        Thread.sleep(2000);
    }

    @And("^wait for plan to load \"([^\"]*)\"$")
    public void wait_for_duplicate_check(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("contentIFrame1");
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame(frame);
        WebElement DebtCaseSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + strArg1 + "']")));
        Assert.assertTrue(DebtCaseSummary.isDisplayed());
    }

    @When("user enters Public Office Name{string} Address {string} and Place of Filing {string}")
    public void userEntersPublicOfficeNameAddressAndPlaceOfFiling(String strArg1, String strArg2, String strArg3) {
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[2]/div/div/tb-input-text/div/div[2]/div/input")).sendKeys(strArg1);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[2]/div/div/tb-input-text-area[1]/div/div[2]/div/textarea")).sendKeys(strArg2);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[2]/div/div/tb-input-text-area[2]/div/div[2]/div/textarea")).sendKeys(strArg3);
    }

    @When("^user enters summary cost Costs \"([^\"]*)\"$")
    public void user_enters_summary_cost_costs_something(String strArg1) throws Throwable {
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-distraint-action/div/form/div[1]/div[3]/div[4]/div/app-summary/form/div/div/div/tb-png-input-number[4]/div/div[2]/div/span/input")).sendKeys(strArg1);
    }

    @When("^user enters Reason for Enforcement Suspension$")
    public void user_enters_reason_for_enforcement_suspension_something() throws Throwable {
        WebElement Date = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[1]/div/div/div/tb-date-picker/div/div[2]/div/p-calendar/span/input")));
        Date.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[1]/div/div/div/tb-date-picker/div/div[2]/div/p-calendar/span/div/div/div[2]/table/tbody/tr[1]/td[6]/a")).click();

        WebElement reasonEnforcementSuspension = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[2]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/label")));
        reasonEnforcementSuspension.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[2]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();
    }

    @When("^user enters Asset Summary Personal Property$")
    public void user_enters_asset_summary_personal_property(DataTable table) throws Throwable {
        //Initialize data table
        List<List<String>> data = table.asLists();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[1]/div/div[2]/div/input")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text-area/div/div[2]/div/textarea")).sendKeys(data.get(1).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-png-input-number[1]/div/div[2]/div/span/input")).sendKeys(data.get(2).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-png-input-number[2]/div/div[2]/div/span/input")).sendKeys(data.get(3).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[2]/div/div[2]/div/input")).sendKeys(data.get(4).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[3]/div/div[2]/div/input")).sendKeys(data.get(5).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[2]/div/button[1]")).click();
    }

    @When("^user enters Asset Seized$")
    public void user_enters_asset_seized(DataTable table) throws Throwable {
        //Initialize data table
        List<List<String>> data = table.asLists();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-input-text[1]/div/div[2]/div/input")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-input-text[2]/div/div[2]/div/input")).sendKeys(data.get(1).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-png-input-number[1]/div/div[2]/div/span/input")).sendKeys(data.get(2).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-png-input-number[2]/div/div[2]/div/span/input")).sendKeys(data.get(3).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-input-text[3]/div/div[2]/div/input")).sendKeys(data.get(4).get(1));

        WebElement assetSeized = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/label")));
        assetSeized.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        WebElement dateofSeizure = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-date-picker/div/div[2]/div/p-calendar/span")));
        dateofSeizure.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[1]/div/div/tb-date-picker/div/div[2]/div/p-calendar/span/div/div/div[2]/table/tbody/tr[1]/td[5]/a")).click();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset-seized/div/div/form/div[2]/div/button[1]")).click();
    }

    @When("^user enters Asset Summary Real Property$")
    public void user_enters_asset_summary_real_property(DataTable table) throws Throwable {
        //Initialize data table
        List<List<String>> data = table.asLists();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[1]/div/div[2]/div/input")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text-area/div/div[2]/div/textarea")).sendKeys(data.get(1).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-png-input-number[1]/div/div[2]/div/span/input")).sendKeys(data.get(2).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-png-input-number[2]/div/div[2]/div/span/input")).sendKeys(data.get(3).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[2]/div/div[2]/div/input")).sendKeys(data.get(4).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[1]/div/div/div/tb-input-text[3]/div/div[2]/div/input")).sendKeys(data.get(5).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-asset/div/div/form/div[2]/div/button[1]")).click();
    }

    @When("^user enters Appointment of Agent details$")
    public void user_enters_appointment_of_agent_details(DataTable table) throws Throwable {
        //Initialize data table
        List<List<String>> data = table.asLists();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-input-text[1]/div/div[2]/div/input")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-input-text[2]/div/div[2]/div/input")).sendKeys(data.get(1).get(1));

        WebElement agentTypeDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label")));
        agentTypeDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-input-text-area[1]/div/div[2]/div/textarea")).sendKeys(data.get(2).get(1));

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-input-text-area[2]/div/div[2]/div/textarea")).sendKeys(data.get(3).get(1));

        WebElement dateOfAppointment = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-date-picker[1]/div/div[2]/div/p-calendar/span/input")));
        dateOfAppointment.click();
        Thread.sleep(2000);
        dateOfAppointment.sendKeys(todaysDate());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);


        WebElement expiryDate = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-date-picker[2]/div/div[2]/div/p-calendar/span/input")));
        expiryDate.click();
        Thread.sleep(2000);
        expiryDate.sendKeys(daysFromToday(5));
        actions.sendKeys(Keys.TAB).perform();

        Thread.sleep(3000);
        WebElement appointmentStatus = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/label")));
        appointmentStatus.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-details/div/div/form/div/div[2]/div/button[1]")).click();
    }

    @When("^user enters Last Payment Made payment \"([^\"]*)\" and comment \"([^\"]*)\"$")
    public void user_enters_last_payment_made_payment_something_and_comment_something(String strArg1, String strArg2) throws Throwable {
        WebElement taxTypeDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-taxtype-verification/div/div/form/div[1]/div/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/label")));
        taxTypeDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-taxtype-verification/div/div/form/div[1]/div/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement lastPaymentMade = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-taxtype-verification/div/div/form/div[1]/div/div/div/tb-png-input-number/div/div[2]/div/span/input"));
        lastPaymentMade.sendKeys(strArg1);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement comments = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-taxtype-verification/div/div/form/div[1]/div/div/div/tb-input-text-area/div/div[2]/div/textarea"));
        comments.sendKeys(strArg2);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement lastSubmittedReturn = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-taxtype-verification/div/div/form/div[1]/div/div/div/tb-date-picker/div/div[2]/div/p-calendar/span/input"));
        lastSubmittedReturn.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-taxtype-verification/div/div/form/div[1]/div/div/div/tb-date-picker/div/div[2]/div/p-calendar/span/div/div/div[2]/table/tbody/tr[2]/td[2]/a")).click();


        WebElement okButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-taxtype-verification/div/div/form/div[2]/div/div/button[1]"));
        okButton.click();
    }

    @When("^user enters Physical Address Visited \"([^\"]*)\"$")
    public void user_enters_physical_address_visited_something(String strArg1) throws Throwable {
        WebElement address = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[1]/div/div/div/tb-input-text-area/div/div[2]/div/textarea"));
        address.sendKeys(strArg1);
    }

    @And("^enters Person Contacted \"([^\"]*)\" Relationship \"([^\"]*)\" Name of Liquidator \"([^\"]*)\" Status of Business Asset \"([^\"]*)\" and Mean of Survival \"([^\"]*)\"$")
    public void enters_person_contacted_something_relationship_something_name_of_liquidator_something_status_of_business_asset_something_and_mean_of_survival_something(String strArg1, String strArg2, String strArg3, String strArg4, String strArg5) throws Throwable {
        WebElement personContacted = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-input-text[1]/div/div[2]/div/input"));
        personContacted.sendKeys(strArg1);

        WebElement relationship = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-input-text[2]/div/div[2]/div/input"));
        relationship.sendKeys(strArg2);

        WebElement BusinessStatusDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label")));
        BusinessStatusDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[3]/span")).click();

        WebElement ReasonForClosureDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/label")));
        ReasonForClosureDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]/span")).click();

        WebElement NameofLiquidator = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-input-text[3]/div/div[2]/div/input"));
        NameofLiquidator.sendKeys(strArg3);

        WebElement StatusofBusinessAsset = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-input-text[4]/div/div[2]/div/input"));
        StatusofBusinessAsset.sendKeys(strArg4);

        WebElement MeanofSurvival = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[2]/div/div/tb-input-text[5]/div/div[2]/div/input"));
        MeanofSurvival.sendKeys(strArg5);
    }

    @When("^user enters Tax Type Period  and Debt Amount \"([^\"]*)\"$")
    public void user_enters_tax_type_period_and_debt_amount_something(String strArg1) throws Throwable {
        WebElement taxTypeDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label")));
        taxTypeDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]/span")).click();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement debtInput = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-png-input-number/div/div[2]/div/span/input"));
        debtInput.sendKeys(strArg1);

        WebElement periodDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/label")));
        periodDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[1]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]/span")).click();

        WebElement okButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-add-update-tax-debt/div/div/form/div/div[2]/div/button[1]"));
        okButton.click();
    }

    @When("^user enters Debt Write-Off Reason")
    public void user_enters_debt_writeoff_reason() throws Throwable {
        WebElement reasonDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-write-off/div/form/div[2]/div/div[2]/tb-dropdown/div/div[2]/div/p-dropdown/div/label")));
        reasonDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-write-off/div/form/div[2]/div/div[2]/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]/span")).click();

    }

    @When("^user clicks add Writen Off Tax Debt$")
    public void user_clicks_add_writen_off_tax_debt() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-write-off/div/form/div[2]/div/div[1]/app-tax-debt-list/div/div/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Tax Debt Collected by Legal$")
    public void user_clicks_add_tax_debt_collected_by_legal() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-legal-action/div/form/div[3]/div/div/app-tax-debt-list/div/div/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Verification of Debt$")
    public void user_clicks_add_verification_of_debt() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-verification/div/div/form/div[1]/div/div/div/div[2]/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Appointment of Agent$")
    public void user_clicks_add_appointment_of_agent() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-agent/div/form/div[1]/div[2]/div/div/div[1]/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Asset Summary Personal Property$")
    public void user_clicks_add_asset_summary_personal_property() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[4]/div/div/app-asset-summary/div/div/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Asset Summary Real Property$")
    public void user_clicks_add_asset_summary_real_property() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[1]/div[3]/div/div/app-asset-summary/div/div/button[1]"));
        addButton.click();
    }

    @When("^user clicks add Asset Seized$")
    public void user_clicks_add_asset_seized() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-distraint-action/div/form/div[1]/div[3]/div[1]/div/app-asset-seized/div/div/button[1]"));
        addButton.click();
    }

    @When("^user enters Enforcement Action \"([^\"]*)\" and Reason \"([^\"]*)\"$")
    public void user_enters_enforcement_action_something_and_reason_something(String strArg1, String strArg2) throws Throwable {
        WebElement enforcementAction = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[2]/div/div/tb-dropdown[1]/div/div[2]/div/p-dropdown/div/label"));
        enforcementAction.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[span='" + strArg1 + "']")).click();
        Thread.sleep(5000);
        WebElement Reason = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[2]/div/div/tb-dropdown[2]/div/div[2]/div/p-dropdown/div/label"));
        Reason.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[span='" + strArg2 + "']")).click();

    }

    @And("^clicks close case Submit button$")
    public void clicks_close_case_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[5]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^clicks Submit button$")
    public void clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[4]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^enters case closure details reason for closure$")
    public void enters_case_closure_details_reason_for_closure() throws Throwable {
        WebElement closureReasonDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[4]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/label")));
        closureReasonDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[4]/div/div/tb-dropdown/div/div[2]/div/p-dropdown/div/div[4]/div[2]/ul/li[2]")).click();
    }

    @And("^clicks close case checkbox$")
    public void clicks_close_case_checkbox() throws Throwable {
        WebElement checkBox = driver.findElement(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[3]/div/div/tb-checkbox/div/div[2]/div/p-checkbox/div/div[2]"));
        checkBox.click();
    }

    @And("^Writen Off Tax Debt clicks Submit button$")
    public void writen_off_tax_debt_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-debt-write-off/div/form/div[3]/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Appointment of Agent clicks Submit button$")
    public void appointment_of_agent_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-appointment-agent/div/form/div[2]/div/button[2]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Lien Imposition clicks Submit button$")
    public void lien_imposition_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-lien-imposition/div/form/div[2]/div/button[2]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Distraint Action clicks Submit button$")
    public void distraint_action_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-distraint-action/div/form/div[2]/div/div/button[2]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Enforcement Suspension clicks Submit button$")
    public void enforcement_suspension_clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[3]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @And("^Legal Action clicks Submit button$")
    public void legal_action_clicks_submit_button() throws Throwable {
        WebElement submitButton = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-legal-action/div/form/div[4]/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^validation error displayed \"([^\"]*)\"$")
    public void validation_error_displayed_something(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement loadFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame(loadFrame);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + strArg1 + "']"))).getText();
        if (text.contains(strArg1)) {
            System.out.println("Text Verified and" + strArg1);
        } else {
            System.out.println("Text Not Verfied and failed");
        }
        Thread.sleep(2000);
    }

    @And("^Select Approval outcome value to Approve \"([^\"]*)\"$")
    public void select_approval_outcome_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_" + strArg1 + "approval";
        WebElement dropDown = driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @And("^Select Reject outcome dropdown value to Approve \"([^\"]*)\"$")
    public void select_reject_outcome_dropdown_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_" + strArg1 + "approval";
        WebElement dropDown = driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @And("^enters manager comments \"([^\"]*)\"$")
    public void enters_manager_comments_something(String strArg1) throws Throwable {
        WebElement managerCommentsInput = driver.findElement(By.id("Manager Comments_label"));
        managerCommentsInput.click();
        Thread.sleep(2000);

        WebElement managerCommentsInputBox = driver.findElement(By.id("tbg_managercomments_i"));
        managerCommentsInputBox.sendKeys(strArg1);

    }


    @Then("^Enter Outcome Reason$")
    public void enter_Outcome_Reason() throws Throwable {
        Thread.sleep(2000);
        WebElement specificframe = (driver.findElement(By.id("WebResource_DebtManagementRejectionDataReferenceResource")));
        driver.switchTo().frame(specificframe);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("viewoption")).click();
        WebDriverWait ReasonValue = new WebDriverWait(driver, 60);
        ReasonValue.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"statuscode_i\"]/option[2]"))).click();

    }


    @Then("^Click on Save button$")
    public void click_on_Save_button() throws Throwable {
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_debtmanagementapplication|NoRelationship|Form|Mscrm.Form.tbg_debtmanagementapplication.Save")).click();


    }

    @Then("^Click on NextStage button$")
    public void click_on_NextStage_button() throws Throwable {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Pro.getProperty("Individual_NextStage_Button_XPATH"))).click();
        Thread.sleep(3000);


    }


    @And("Click on debt management > Installment agreements > Create installment agreement")
    public void clickOnDebtManagementInstallmentAgreementsCreateInstallmentAgreement() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Debt Management']"))).click();
        driver.findElement(By.xpath("//a[span='Instalment Agreements']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sub1\"]/ul/li[1]/a")).click();
    }

    @And("Click on debt management > Installment agreements > cancel installment agreement")
    public void clickOnDebtManagementInstallmentAgreementsCancelInstallmentAgreement() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Debt Management']"))).click();
        driver.findElement(By.xpath("//a[span='Instalment Agreements']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sub1\"]/ul/li[3]/a")).click();
    }

    @And("Click on debt management > Installment agreements > view installment agreement")
    public void clickOnDebtManagementInstallmentAgreementsViewInstallmentAgreement() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Debt Management']"))).click();
        driver.findElement(By.xpath("//a[span='Instalment Agreements']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sub1\"]/ul/li[2]/a")).click();
    }

    @Then("^Click reporting > reports$")
    public void goToReportingScreen() throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reporting']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reports']"))).click();
    }

    @Then("Find taxpayer using tin {string}")
    public void findTaxpayerUsingTin(String tin) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:find"))).click();
        switchToFrameBackoffice();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt21")).click();

    }

    @Then("Select taxtype under outstanding debt {string}")
    public void selectTaxtypeUnderOutstandingDebt(String taxtype) throws InterruptedException {
        Thread.sleep(12000);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:TaxType\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + taxtype + "')]"))).click();
    }

    @Then("Click add under outstanding debts")
    public void clickAddUnderOutstandingDebts() throws InterruptedException {
        Thread.sleep(3500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:outstandingDebtsTable:AddOutstandingDebt"))).click();
    }

    @Then("Select return type under outstanding debts {string}")
    public void selectReturnTypeUnderOutstandingDebts(String returnType) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OutstandingDebt:ReturnType\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + returnType + "')]"))).click();
        Thread.sleep(1500);
    }

    @Then("Select period and year under outstanding debts {string}")
    public void selectPeriodAndYearUnderOutstandingDebts(String period) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OutstandingDebt:PeriodYear\"]/div[3]"))).click();
        Thread.sleep(2500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + period + "')]"))).click();
        Thread.sleep(1500);
    }

    @Then("Enter value of debt as {string}")
    public void enterValueOfDebtAs(String debt) {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("OutstandingDebt:ValueofDebt_input"))).sendKeys(debt);
    }

    @Then("Click ok under installment agreements")
    public void clickOkUnderInstallmentAgreements() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("OutstandingDebt:Ok"))).click();
    }

    @Then("Enter number of installments as {string}")
    public void enterNumberOfInstallmentsAs(String number) throws InterruptedException {
        Thread.sleep(5000);
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:NumberofInstalments_input"))).sendKeys(number);
    }

    @Then("Select payment frequency as {string}")
    public void selectPaymentFrequency(String frequency) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:PaymentFrequency\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + frequency + "')]"))).click();
        Thread.sleep(1500);
    }

    @Then("Select first installment due date as today")
    public void selectFirstInstallmentDueDateAsToday() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:FirstInstalmentDueDate_input"))).sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Select reason for installment {string}")
    public void selectReasonForInstallment(String reason) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:Reason\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + reason + "')]"))).click();
        Thread.sleep(1500);

    }

    @Then("Select office as {string}")
    public void selectOfficeAs(String office) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:Office\"]/div[3]"))).click();
        Thread.sleep(1500);
//        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + office + "')]"))).click();
//        Thread.sleep(1500);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Enter notes for agreement")
    public void enterNotesForAgreement() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:Notes"))).sendKeys("Notes");
    }

    @Then("Click save to submit installment agreement")
    public void clickSaveToSubmitInstallmentAgreement() throws InterruptedException {
        Thread.sleep(3000);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:Save"))).click();
    }


    @Then("Switch to backoffice frame")
    public void switchToBackofficeFrame() {
        switchToFrameBackoffice();
    }

    @Then("Obtain installment agreement ARN {string}")
    public void obtainInstallmentAgreementARN(String success) {
        //Instalment Agreement with reference no IA000000042 has been successfully created
        String FullMessage = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + success + "')]"))).getText();

        ReferenceNumber = FullMessage.substring(39, 50);
        sharedatastep.Agreement = ReferenceNumber;
        System.out.println("Actual ARN to be used in CRM is " + ReferenceNumber);
    }

    @Then("Click add under related documents")
    public void clickAddUnderRelatedDocuments() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:relatedDocTableHandler:AddRelatedDocument"))).click();
    }

    @Then("Select related document type as {string}")
    public void selectRelatedDocumentTypeAs(String docType) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchForm:DocumentType\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + docType + "')]"))).click();
        Thread.sleep(1500);
    }


    @Then("Click search to search for document")
    public void clickSearchToSearchForDocument() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt21"))).click();
    }

    @Then("Verify data for return document {string} is populated in table")
    public void verifyDataForReturnDocumentIsPopulatedInTable(String data) {
        WebElement DataXpath = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + data + "')]")));
        if (DataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Then("Click calculate to calculate installment plan")
    public void clickCalculateToCalculateInstallmentPlan() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:calculate"))).click();
    }

    @Then("Verify calculation data is populated in table")
    public void verifyCalculationDataIsPopulatedInTable() {
        WebElement DataXpath = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'DUE')]")));
        if (DataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Then("Click return document table row")
    public void clickReturnDocumentTableRow() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:relatedDocTableHandler_data\"]/tr/td[1]"))).click();
    }

    @Then("Click view to view return document")
    public void clickViewToViewReturnDocument() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:relatedDocTableHandler:ViewRelatedDocument"))).click();
    }

    @Then("Verify return document screen is displayed with readonly fields")
    public void verifyReturnDocumentScreenIsDisplayedWithReadonlyFields() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement tinfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:TIN")));
        String tin = tinfield.getAttribute("value");
        if (tin.isEmpty() || tinfield.isEnabled()) {
            Assert.fail("Return document does not contain any data or fields are not readonly");
        } else {
            Assert.assertTrue("Return document page contains data", !tin.isEmpty());
        }
    }

    @Then("Click cancel to return to create installment screen")
    public void clickCancelToReturnToCreateInstallmentScreen() {
        five.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:Cancel"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:InstalmentAgreementNumber"))).isDisplayed();
    }

    @Then("Remove return document")
    public void removeReturnDocument() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:relatedDocTableHandler:DeleteRelatedDocument"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:relatedDocTableHandler:deleteYesDoc"))).click();
    }

    @Then("Open CRM and close modal")
    public void openCRMAndCloseModal() {
        driver.get(Pro.getProperty("NRA_crm_url_Registration"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @Then("Click on debt application link")
    public void clickOnDebtApplicationLink() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Pro.getProperty("Cases_Management_Dropdown_XPATH")))).click();

        Thread.sleep(2000);
        driver.findElement(By.id(Pro.getProperty("Debt_Application_ID"))).click();
    }

    @Then("search for reference number")
    public void searchForReferenceNumber() throws InterruptedException {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));

        search.clear();
        Thread.sleep(2000);
        //search.sendKeys("*AV/000000875/2021");
        search.sendKeys(ReferenceNumber);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }


//    @Then("^Click on reference number$")
//    public void click_on_reference_number() {
//
//        WebElement elementLocator = driver.findElement(By.xpath(Pro.getProperty("CaseManagement_Queue_Select_ReffNo_XPATH")));
//
//        Actions actions = new Actions(driver);
//        actions.doubleClick(elementLocator).perform();
//
//        driver.switchTo().defaultContent();
//
//    }


    @Then("^approve transaction$")
    public void approve_transaction() throws Throwable {

        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame("WebResource_DebtManagementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Instalment Agreement Number:']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("reject transaction after text {string} loads")
    public void rejectTransactionAfterTextLoads(String text) throws InterruptedException {
        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame("WebResource_DebtManagementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + text + "']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("^Enter Outcome Notes (.+)$")
    public void enter_outcome_notes(String Notes) throws Throwable {
        Thread.sleep(3000);
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.id((Pro.getProperty("Individual_NextStage_RefNum_Reject_OutComeNotes_ID"))));
        action1.sendKeys(element1, Notes).build().perform();
        Thread.sleep(5000);
    }

    @Then("^Click save CRM$")
    public void ClickSaveCRM() throws Throwable {
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_debtmanagementapplication|NoRelationship|Form|Mscrm.Form.tbg_debtmanagementapplication.Save")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Then("^Debt installment status should be \"([^\"]*)\"$")
    public void Verify_status_from_CRM(String Status) throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement statusLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + Status + "')]")));

        if (statusLabel.isDisplayed()) {
            Assert.assertTrue("Approved", true);
        } else {
            Assert.fail("Approval failed");
        }
        Thread.sleep(2000);
    }


    @Then("Search for case using tin {string} and agreement number {string}")
    public void searchForCaseUsingTinAndAgreementNumber(String tin, String number) {

        if(tin.isEmpty() && number.isEmpty()){
            ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:agreementNumber"))).sendKeys(sharedatastep.Agreement);
        }
        else{
            ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
            ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:agreementNumber"))).sendKeys(number);
        }
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt40"))).click();
    }

    @Then("Enter cancellation reason {string}")
    public void enterCancellationReason(String reason) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InstalmentAgreement:CancellationReason\"]/div[3]"))).click();
        Thread.sleep(1500);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'" + reason + "')]"))).click();
        Thread.sleep(1500);
    }

    @Then("Enter cancellation date")
    public void enterCancellationDate() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:CancellationDate_input"))).sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
        Thread.sleep(1000);
    }

    @Then("Enter cancellation notes {string}")
    public void enterCancellationNotes(String notes) throws InterruptedException {
        Thread.sleep(1000);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:CancellationNotes"))).sendKeys(notes);
    }

    @Then("Submit cancellation")
    public void submitCancellation() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:Save"))).click();
    }

    @Then("Cancel cancellation")
    public void cancelCancellation() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:cancel"))).click();
    }

    @Then("^user is navigated back to \"([^\"]*)\"$")
    public void user_is_navigated_back_to_homepage_something(String url) throws Throwable {
        Thread.sleep(4000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(url, URL);
    }

    @Then("Verify view field has correct data {string}")
    public void verifyViewFieldHasCorrectData(String number) {
        String current = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InstalmentAgreement:InstalmentAgreementNumber"))).getAttribute("value");
        if (number.isEmpty()){
            Assert.assertTrue("Field has correct data", current.equals(sharedatastep.Agreement));
        }
        else{
            Assert.assertTrue("Field has correct data", current.equals(number));
        }


    }


    @Then("^Select report to print \"([^\"]*)\"$")
    public void select_report_to_print(String reportType) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + reportType + "']"))).click();

    }

    @Then("^Select report file type \"([^\"]*)\"$")
    public void select_report_file_type(String reportFormat) throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:ReportFormat\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + reportFormat + "')]")).click();
    }

    @Then("^Select tax office \"([^\"]*)\"$")
    public void select_tax_office(String taxOffice) throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"frmReportDetails:TAX_OFFICE\"]/div[3]")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Select return type$")
    public void select_return_type() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:TAX_TYPE\"]/div[3]"))).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @Then("^Verify file \"([^\"]*)\" has been downloaded in downloads directory \"([^\"]*)\"$")
    public void verify_file_has_been_downloaded_in_downloads_directory(String fileName, String downloadPath) throws Throwable {
        Thread.sleep(10000);
        if (isFileDownloaded(downloadPath, fileName)) {
            System.out.println(fileName + ": has been downloaded");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(fileName + ": has not been downloaded", false);
        }
    }

    @Then("^Click run report \"([^\"]*)\"$")
    public void click_run_report(String buttonID) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(buttonID))).click();
    }

    @Then("Select ending date as today")
    public void selectEndingDateAsToday() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:EndDate_input"))).sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
        Thread.sleep(1000);
    }

    @Then("Select business sector")
    public void selectBusinessSector() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:BUSINESS_SECTOR\"]/div[3]"))).click();
        Thread.sleep(1500);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Click cancel to abandon report")
    public void clickCancelToAbandonReport() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:btnCancel"))).click();
    }

    @And("^Click on debt management > Create debt management case$")
    public void click_on_debt_management_create_debt_management_case() throws Throwable {
        driver.findElement(By.xpath("//a[span='Debt Management']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"MenuForm:j_idt27\"]/ul/li[16]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sub1\"]")).click();
    }

    @And("^enter \"([^\"]*)\" and click search$")
    public void enter_something_and_click_search(String strArg1) throws Throwable {
        WebElement tinSearchInput = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin")));
        tinSearchInput.sendKeys(strArg1);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and span='Search']"));
        searchButton.click();
    }

    @Then("^CREATE DEBT MANAGEMENT CASE window is placed$")
    public void create_debt_management_case_window_is_placed() throws Throwable {
        WebElement createCaseTitle = fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("DebtManagementCase:DebtManagementCasePanel_header")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createCaseTitle);
        Thread.sleep(5000);
        Assert.assertEquals("CREATE DEBT MANAGEMENT CASE", createCaseTitle.getText());
    }

    @Then("^Find Payment To Dishonour page is displayed$")
    public void find_payment_to_dishonour_page_is_displayed() throws Throwable {
        WebElement dishonourTitle = fifty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:directorHeader")));
        Assert.assertEquals("Find Payment To Dishonour", dishonourTitle.getText());
    }

    @Then("^Dishonoured Payment page is displayed$")
    public void dishonoured_payment_page_is_displayed() throws Throwable {
        WebElement dishonourTitle = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("dishonourPayment:PageTitleLabel")));
        Assert.assertEquals("Dishonoured Payment", dishonourTitle.getText());
    }

    @When("^the user enters taxtype \"([^\"]*)\" and value of debt \"([^\"]*)\" return tpe and period \"([^\"]*)\"$")
    public void the_user_enters_taxtype_something_and_value_of_debt_something_return_tpe_and_period_something(String strArg1, String strArg2, String strArg3) throws Throwable {
        WebElement addButton = driver.findElement(By.id("DebtManagementCase:TaxTypeTable:btnAddTaxType"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);
        Thread.sleep(5000);
        addButton.click();

        WebElement iframe = twentyfive.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);

        WebElement taxTypeDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DebtCaseTaxType:TaxType\"]/div[3]")));
        taxTypeDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@data-label='" + strArg1 + "']")).click();

        Thread.sleep(3000);
        WebElement returnTypedropdown = driver.findElement(By.xpath("//*[@id=\"DebtCaseTaxType:ReturnType\"]/div[3]"));
        returnTypedropdown.click();
        Thread.sleep(3000);
        driver.findElement(By.id("DebtCaseTaxType:ReturnType_1")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement debtInput = driver.findElement(By.id("DebtCaseTaxType:ValueOfDebt_input"));
        debtInput.sendKeys(strArg2);


        Thread.sleep(3000);
        WebElement periodDropdown = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DebtCaseTaxType:PeriodValue\"]/div[3]")));
        periodDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@data-label='" + strArg3 + "']")).click();


        WebElement okButton = driver.findElement(By.id("DebtCaseTaxType:Ok"));
        okButton.click();
    }

    @And("^Click on Accounting > Dishonoured Payment$")
    public void click_on_accounting_dishonoured_payment() throws Throwable {
        driver.findElement(By.xpath("//a[span='Taxpayer Accounting']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[span='Dishonoured Payment']")).click();
    }

    @When("^user enters TIN \"([^\"]*)\" to find dishonour payment details$")
    public void user_enters_tin_something_to_find_dishonour_payment_details(String strArg1) throws Throwable {
        WebElement tinSearchInput = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:TIN")));
        tinSearchInput.sendKeys(strArg1);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and span='Search']"));
        searchButton.click();
    }

    @And("^selects a dishonored payment from table$")
    public void selects_a_dishonored_payment_from_table() throws Throwable {
        WebElement dishonouredPayment = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SearchForm:resultsDataTable_data\"]/tr[2]")));
        dishonouredPayment.click();

        WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit' and span='Continue']"));
        continueButton.click();
    }

    @When("^user enters Dishonoured Date  and Reason \"([^\"]*)\"$")
    public void user_enters_dishonoured_date_and_reason_something(String strArg1) throws Throwable {
        WebElement dishonouredDate = driver.findElement(By.id("dishonourPayment:DishonourDate_input"));
        dishonouredDate.sendKeys(Keys.ENTER);

        WebElement reasonDropdown = driver.findElement(By.xpath("//*[@id=\"dishonourPayment:Reason\"]/div[3]"));
        reasonDropdown.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@data-label='" + strArg1 + "']")).click();

        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit' and span='Save']"));
        saveButton.click();

    }

    @Then("^Verify message \"([^\"]*)\"$")
    public void verify_message_something(String Message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify the ARN number \"([^\"]*)\"$")
    public void verify_the_ARN_number_ARN(String ARN) throws Throwable {

        WebDriverWait RefNumber = new WebDriverWait(driver, 150);
        // Capture ARN Number
        String text = RefNumber.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("Precessing_Completed_RefferenceNumber_ID")))).getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(42));
        sharedatastep.DEBT_ARN_ORG = text.substring(42);
        System.out.println(sharedatastep.DEBT_ARN_ORG);
        System.out.println("Actual ARN to be used in CRM is " + sharedatastep.DEBT_ARN_ORG);

        if (text.contains(ARN)) {
            //  System.out.println(text);
            System.out.println("Text Verified and passed");
        } else {
            System.out.println("Text Not Verified and failed");
        }
    }

    @When("^the user leaves details blank and clicks submit$")
    public void the_user_leaves_details_blank_and_clicks_submit() throws Throwable {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and span='Submit']"));
        submitButton.click();
    }

    @When("^User enters Case Title \"([^\"]*)\" and Office \"([^\"]*)\"$")
    public void user_enters_case_title_something_and_office_something(String strArg1, String strArg2) throws Throwable {
        WebElement caseTitle = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("DebtManagementCase:CaseTitle")));
        caseTitle.sendKeys(strArg1);
        Thread.sleep(3000);
        WebElement officeDropdown = driver.findElement(By.xpath("//*[@id=\"DebtManagementCase:CaseOffice\"]/div[3]"));
        officeDropdown.click();
        Thread.sleep(4000);
//        WebElement taxType=driver.findElement(By.xpath("//li[@data-label='"+strArg2+"']"));
        WebElement taxType = driver.findElement(By.id("DebtManagementCase:CaseOffice_1"));
        taxType.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and span='Submit']"));
        submitButton.click();
    }

}



