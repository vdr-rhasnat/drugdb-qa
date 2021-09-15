package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class DrugDBStep {
    private String token;
    private Integer statusCode;
    private String drugName;
    private String color;
    private String packageSize;

    @Given("A valid token with auth url {string}, client id {string}, client secret {string}, audience {string} and grand type {string}")
    public void aValidTokenWithAuthUrlClientIdClientSecretAudienceAndGrandType(String authUrl, String clientId, String clientSecret, String audience, String grandType) {
        token = Tokenizer.getToken(authUrl, clientId, clientSecret, audience, grandType);
        Assert.assertNotNull(token);
    }

    @When("I hit the endpoint {string}")
    public void iHitTheEndpoint(String endpoint) {
        Response res = DrugDBRequest.GetByNdc(endpoint, token);
        statusCode = res.statusCode();
        drugName = res.then().extract().jsonPath().get("drugName");
        color = res.then().extract().jsonPath().get("color");
        packageSize = res.then().extract().jsonPath().get("packageSize");
    }

    @Then("I should receive status code {string}")
    public void iShouldReceiveStatusCode(String argStatus) {
        Assert.assertEquals(argStatus, statusCode.toString());
    }

    @And("I should receive drug name {string}")
    public void iShouldReceiveDrugName(String argDrugName) {
        Assert.assertEquals(argDrugName, drugName);
    }

    @And("I should receive color {string}")
    public void iShouldReceiveColor(String argColor) {
        Assert.assertEquals(argColor, color);
    }

    @And("I should receive package size {string}")
    public void iShouldReceivePackageSize(String argPackageSize) {
        Assert.assertEquals(packageSize, argPackageSize);
    }
}
