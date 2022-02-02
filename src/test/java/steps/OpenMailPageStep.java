package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.pages.GoogleMailPage;

public class OpenMailPageStep extends AbstractPage {
    private GoogleMailPage googleMailPage = new GoogleMailPage();

    @When("Switching to a new tab and creating temporary mail")
    public void transitionNewPage() {
        googleMailPage.transitionNewPage();
    }

    @Then("Click on the copy button address email")
    public void copyEmail() {
        googleMailPage.copyEmail();
    }

    @And("Return to the calculator page")
    public void returnPageBack() {
        googleMailPage.returnPageBack();
    }

    @When("Open the received email")
    public void openEmail() {
        googleMailPage.openEmail();
    }

    @And("Return to the email page")
    public void transitPageToEmail() {
        googleMailPage.transitPageToEmail();
    }

//    @And("")
//    public void checkCostResult(){
//        Assert.assertTrue(calculatorCost.contains(emailCost.getText()), "Invalid cost");
//    }

}
