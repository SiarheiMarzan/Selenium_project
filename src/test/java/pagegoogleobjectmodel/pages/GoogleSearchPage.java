package pagegoogleobjectmodel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagegoogleobjectmodel.util.DataReader;

import java.util.concurrent.TimeUnit;

public class GoogleSearchPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement stringSearchResult;

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/div//a[@href='/products/calculator']")
    private WebElement clickLinkPricingCalculator;

    public GoogleSearchPage() {
        super();
    }

    public GoogleSearchPage openPage() {
        logger.info("Start of the program");
        driver.get(DataReader.getTestData("testdata.web.address"));
        return this;
    }

    public GoogleSearchPage cloudGoogleSearch(String message) {
        logger.info("Click the search button and enter the value");
        buttonSearch.click();
        buttonSearch.sendKeys(message + Keys.ENTER);
        return this;
    }

    public GoogleSearchPage moveSearhResult() {
        logger.info("Click on the link field to the found page");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        stringSearchResult.click();
        return this;
    }

    public GoogleSearchPage clickPricing() {
        clickLinkPricingCalculator.click();
        return this;
    }

}
