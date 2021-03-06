package examples;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import static org.junit.Assert.fail;


public class MyStepdefs {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MyStepdefs() {
        driver = resolveGridOrLocalDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @Given("A login to a directory")
    public void aLoginToADirectory() {

    }

    @When("A combo box is selected")
    public void aComboBoxIsSelected() {

    }

    @Then("A text box is visible")
    public void aTextBoxIsVisible() {
        if (randomOutcome()) {
           // fail();
        }
    }

    @When("A texbox is filled in")
    public void aTexboxIsFilledIn() {

    }

    @Then("A submit button is active")
    public void aSubmitButtonIsActive() {
        if (randomOutcome()) {
           // fail();
        }
    }

    @Given("I navigate to a site")
    public void iNavigateToASite() {
        this.driver.get("https://www.google.com");
    }


    @When("and enter some search")
    public void andEnterSomeSearch() {

    }

    @Then("I get some results")
    public void iGetSomeResults() {
        if (randomOutcome()) {
            fail();
        }
    }

    @Given("I make a new Transaction")
    public void iMakeANewTransaction() {

    }

    @When("I click Confirm")
    public void iClickConfirm() {
    }

    @Then("The transaction is accepted")
    public void theTransactionIsAccepted() {
    }

    @Given("I locate a transaction")
    public void iLocateATransaction() {
    }

    @When("A request a rollback of the transaction")
    public void aRequestARollbackOfTheTransaction() {
    }

    @Then("The transaction is rolled back")
    public void theTransactionIsRolledBack() {
    }

    @Given("I navigate to the transaction screen")
    public void iNavigateToTheTransactionScreen() {
        this.driver.get("https://www.bbc.co.uk/");
    }

    @When("The transactions are loaded")
    public void theTransactionsAreLoaded() {
    }

    @Then("The active transactions are highlighted")
    public void theActiveTransactionsAreHighlighted() {
        if (randomOutcome()) {
            fail();
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(scnShot, "image/png", "screenshot");
            }
        } catch (Exception ignored) {

        } finally {
            driver.quit();
        }
    }

    private boolean randomOutcome() {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    private WebDriver resolveGridOrLocalDriver() {
        try {
            DesiredCapabilities dc = DesiredCapabilities.chrome();
            return new RemoteWebDriver(new URL(resolveGridHostPort()), dc);
        } catch (UnreachableBrowserException | MalformedURLException e) {
            return new ChromeDriver();
        }
    }

    private String resolveGridHostPort() {
        return "http://localhost:4444/wd/hub";
    }

}

