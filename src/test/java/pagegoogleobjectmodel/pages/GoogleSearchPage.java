package pagegoogleobjectmodel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement stringSearchResult;

    public GoogleSearchPage() {
       super();
    }

    public GoogleSearchPage openPage() {
        logger.info("Start of the program");
        driver.get("https://cloud.google.com/");
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
        stringSearchResult.click();
        return this;
    }

}
