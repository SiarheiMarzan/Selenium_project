package steps;

import io.cucumber.java.en.Given;
import io.qameta.allure.Attachment;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.pages.GoogleSearchPage;
import pagegoogleobjectmodel.util.DataReader;

public class OpenCloudPricingCalculator extends AbstractPage {
    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Given("Going through the search on the Cloud Platform Pricing Calculator")
    public void openPage() {
        googleSearchPage.openPage();
        googleSearchPage.cloudGoogleSearch(DataReader.getTestData("testdata.value.field.find"));
        googleSearchPage.moveSearhResult();
    }
}
