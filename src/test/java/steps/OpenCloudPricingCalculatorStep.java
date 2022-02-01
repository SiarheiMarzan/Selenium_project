package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.util.DataReader;

public class OpenCloudPricingCalculatorStep extends AbstractPage{

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement buttonSearch;
    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement stringSearchResult;
    @FindBy(xpath = "//*[@id=\"cloud-site\"]/div//a[@href='/products/calculator']")
    private WebElement clickLinkPricingCalculator;

    @When("Open start google page")
    public void openPage() {
        driver.get(DataReader.getTestData("testdata.web.address"));
    }

    @Then("Enter message in the search text box")
    public void cloudGoogleSearch() {
        buttonSearch.click();
        buttonSearch.sendKeys(DataReader.getTestData("testdata.value.field.find") + Keys.ENTER);
    }

    @And("Select the first result")
    public void moveSearhResult() {
        stringSearchResult.click();
    }

}
