package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.pages.GoogleSearchPage;
import pagegoogleobjectmodel.util.DataReader;

public class OpenCloudPricingCalculator extends AbstractPage {
    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("Going through the search on the Cloud Platform Pricing Calculator")
    public void openPage() {
        googleSearchPage.openPage();
        googleSearchPage.cloudGoogleSearch(DataReader.getTestData("testdata.value.field.find"));
        googleSearchPage.moveSearhResult();
    }
}
