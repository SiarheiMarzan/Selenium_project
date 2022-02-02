package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.pages.GoogleCalculatorPage;
import pagegoogleobjectmodel.pages.GoogleMailPage;
import org.testng.Assert;

public class OpenMailPageStep extends AbstractPage {
    private GoogleMailPage googleMailPage = new GoogleMailPage();
    private GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage();

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

    @Then("CheckCostResult")
    public void checkCostResult(){
        String calculatorCost = googleCalculatorPage.calculatedTotalEstimatedCost();
        Assert.assertTrue(calculatorCost.contains(googleMailPage.getCostFromEmail()), "Invalid cost");
    }

}
