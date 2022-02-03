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

    @Then("Create a temporary mail and save the address")
    public void createTemporaryMailAndSaveAddress() {

        googleMailPage.transitionNewPage();
        googleMailPage.copyEmail();
    }

    @And("Return to the cloud calculator page")
    public void returnPageBack() {
        googleMailPage.returnPageBack();
    }

    @Then("Open the received email")
    public void openEmail() {
        googleMailPage.openEmail();
    }

    @And("CheckCostResult")
    public void checkCostResult() {
        String calculatorCost = googleCalculatorPage.calculatedTotalEstimatedCost();
        Assert.assertTrue(calculatorCost.contains(googleMailPage.getCostFromEmail()), "Invalid cost");
    }

}
