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
            driver.close();
            fail();
        }
    }

    @When("A texbox is filled in")
    public void aTexboxIsFilledIn() {

    }

    @Then("A submit button is active")
    public void aSubmitButtonIsActive() {
        if (randomOutcome()) {
            driver.close();
            fail();
        }
    }

    @Given("I navigate to a site")
    public void iNavigateToASite() {
        this.driver.get("https://www.google.com");
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
       // return String.format("http://%s/wd/hub", System.getProperty("gridHostPort") != null ? System.getProperty("gridHostPort") : "////");
    }

    @When("and enter some search")
    public void andEnterSomeSearch() {

    }

    @Then("I get some results")
    public void iGetSomeResults() {
        if (randomOutcome()) {
            driver.close();
            fail();
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("IN AFTER");
        try {
            if (scenario.isFailed()) {
                String scnShot;
                try {
                    scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                    String screenshot = "data:image/gif;base64, " + scnShot;
                    scenario.attach(screenshot, "gif;base64", "screenshot");
                } catch (Exception ignored) {

                }
            }
        } catch (Exception ignored) {

        } finally {
            driver.close();
        }
    }

}

