package examples;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

import static org.junit.Assert.fail;

public class MyStepdefs {
    @Given("A login to a directory")
    public void aLoginToADirectory() {
    }

    @When("A combo box is selected")
    public void aComboBoxIsSelected() {
        
    }

    @Then("A text box is visible")
    public void aTextBoxIsVisible() {
        if (randomOutcome()) {
            fail();
        }
    }

    @When("A texbox is filled in")
    public void aTexboxIsFilledIn() {
        
    }

    @Then("A submit button is active")
    public void aSubmitButtonIsActive() {
        if (randomOutcome()) {
            fail();
        }
    }

    private boolean randomOutcome() {
        Random rd = new Random();
        return rd.nextBoolean();
    }
}
