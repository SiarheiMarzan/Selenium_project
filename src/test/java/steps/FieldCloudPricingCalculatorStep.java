package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.pages.GoogleCalculatorPage;
import pagegoogleobjectmodel.pages.GoogleMailPage;
import pagegoogleobjectmodel.util.DataReader;

public class FieldCloudPricingCalculatorStep extends AbstractPage {
    private GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage();
    private GoogleMailPage googleMailPage = new GoogleMailPage();

    @And("Fill in the calculator fields with test data")
    public void fillInTheFieldsWithTestData() {
        googleCalculatorPage.getIframe();
        googleCalculatorPage.activeComputerEngine();
        googleCalculatorPage.activeInstancesAndInput(DataReader.getTestData("testdata.number.of.instance"));
        googleCalculatorPage.choiceValue(DataReader.getTestData("testdata.field.series")
                , DataReader.getTestData("testdata.list.series"));
        googleCalculatorPage.choiceValue(DataReader.getTestData("testdata.instance.type")
                , DataReader.getTestData("testdata.instance.options"));
        googleCalculatorPage.checkGpu();
        googleCalculatorPage.typeGpu();
        googleCalculatorPage.choiseNumberOfGpus();
        googleCalculatorPage.choiseLocalSsd();
        googleCalculatorPage.locationDataCenter();
        googleCalculatorPage.commitedUsage();
    }

    @And("Add to Estimate by clicking the button")
    public void addToEstimate() {
        googleCalculatorPage.addToEstimate();
    }

    @And("Saving the string value 'Total Estimated Cost'")
    public void saveCalculatorCost() {
        String calculatorCost = googleCalculatorPage.calculatedTotalEstimatedCost();
    }

    @And("Send email and get the cost to a temporary email")
    public void insertAddressAndSendToTemporaryEmailCost() {
        googleCalculatorPage.choiseEmailEstimate();
        googleCalculatorPage.emailEstimateClick();
        googleCalculatorPage.inputCopyEmail();
        googleCalculatorPage.sendMail();
        googleMailPage.transitPageToEmail();
    }
}
