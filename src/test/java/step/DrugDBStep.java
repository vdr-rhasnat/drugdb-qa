package step;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DrugDBStep {
    @When("I hit the test method")
    public void iHitTheTestMethod() {
    }

    @Then("I should receive {string}")
    public void iShouldReceive(String name) {
        System.out.println(name);
    }
}
