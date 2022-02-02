package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.pages.GoogleSearchPage;
import pagegoogleobjectmodel.util.DataReader;

public class OpenCloudPricingCalculator extends AbstractPage {
    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("Open start google page")
    public void openPage() {
        googleSearchPage.openPage();
    }

    @Then("Enter message in the search text box")
    public void cloudGoogleSearch() {
        googleSearchPage.cloudGoogleSearch(DataReader.getTestData("testdata.value.field.find"));
    }

    @And("Select the first result")
    public void moveSearhResult() {
        googleSearchPage.moveSearhResult();
    }

}
