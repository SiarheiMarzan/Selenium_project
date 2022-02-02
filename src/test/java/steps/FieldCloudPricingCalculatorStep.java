package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.pages.GoogleCalculatorPage;
import pagegoogleobjectmodel.util.DataReader;

public class FieldCloudPricingCalculatorStep extends AbstractPage {
    private GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage();

    @When("Open Iframe")
    public void getIframe() {
        googleCalculatorPage.getIframe();
    }

    @And("Activate section 'Compute Engine'")
    public void activeComputerEngine() {
        googleCalculatorPage.activeComputerEngine();
    }

    @Then("Click field 'Number of instance:' and input value")
    public void activeInstancesAndInput() {
        googleCalculatorPage.activeInstancesAndInput(DataReader.getTestData("testdata.number.of.instance"));
    }

    @Then("Select the field series value")
    public void choiceSeriesValue() {
        googleCalculatorPage.choiceValue(DataReader.getTestData("testdata.field.series")
                , DataReader.getTestData("testdata.list.series"));
    }

    @Then("Select the instance type value")
    public void choiceInstanceValue() {
        googleCalculatorPage.choiceValue(DataReader.getTestData("testdata.instance.type")
                , DataReader.getTestData("testdata.instance.options"));
    }

    @Then("Activate section 'Add GPUs'")
    public void checkGpu() {
        googleCalculatorPage.checkGpu();
    }

    @Then("Click filed 'typeGPU' and select NVIDIA Tesla 100")
    public void typeGpu() {
        googleCalculatorPage.typeGpu();
    }

    @Then("Click field 'Number of GPUs' and select value 'Number of GPUs'")
    public void choiseNumberOfGpus() {
        googleCalculatorPage.choiseNumberOfGpus();
    }

    @Then("Click field 'LocalSSD' and select value 2x375Gb")
    public void choiseLocalSsd() {
        googleCalculatorPage.choiseLocalSsd();
    }

    @Then("Click section Datacenter location and select Frankfurt europe-west3")
    public void locationDataCenter() {
        googleCalculatorPage.locationDataCenter();
    }

    @Then("Click section 'Committed usage' and select value '1 Year'")
    public void commitedUsage() {
        googleCalculatorPage.commitedUsage();
    }

    @Then("Click button 'Add to Estimate'")
    public void addToEstimate() {
        googleCalculatorPage.addToEstimate();
    }

    @Then("Saving the string value 'Total Estimated Cost'")
    public void saveCalculatorCost() {
        String calculatorCost = googleCalculatorPage.calculatedTotalEstimatedCost();
    }

    @Then("Click button 'Email Estimate'")
    public void choiseEmailEstimate() {
        googleCalculatorPage.choiseEmailEstimate();
    }


    @When("Clicking on field for input email")
    public void emailEstimateClick() {
        googleCalculatorPage.emailEstimateClick();
    }

    @Then("Inserting the copied email address from the created mail")
    public void inputCopyEmail() {
        googleCalculatorPage.inputCopyEmail();
    }

    @And("Click button 'Send Email'")
    public void sendMail() {
        googleCalculatorPage.sendMail();
    }

}
