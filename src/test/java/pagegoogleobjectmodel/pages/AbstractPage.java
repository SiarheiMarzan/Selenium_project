package pagegoogleobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagegoogleobjectmodel.driver.DriverSingleton;

public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
