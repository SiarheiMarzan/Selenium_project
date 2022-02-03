package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.pages.GoogleCalculatorPage;
import pagegoogleobjectmodel.pages.GoogleMailPage;

public class OpenMailPageStep extends AbstractPage {
    private GoogleMailPage googleMailPage = new GoogleMailPage();
    private GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage();

    @And("Create a temporary mail and save the address")
    public void createTemporaryMailAndSaveAddress() {

        googleMailPage.transitionNewPage();
        googleMailPage.copyEmail();
    }

    @And("Return to the cloud calculator page")
    public void returnPageBack() {
        googleMailPage.returnPageBack();
    }

    @And("Open the received email")
    public void openEmail() {
        googleMailPage.openEmail();
    }

    @Then("CheckCostResult")
    public void checkCostResult() {
        String calculatorCost = googleCalculatorPage.calculatedTotalEstimatedCost();
        Assert.assertTrue(calculatorCost.contains(googleMailPage.getCostFromEmail()), "Invalid cost");
    }

}
