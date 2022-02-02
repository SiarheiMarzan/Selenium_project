package pagegoogleobjectmodel.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GoogleMailPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//span[@class='copy_icon']")
    private WebElement buttonCopyEmail;

    @FindBy(xpath = "//span[@class='small_message_icon']")
    private WebElement buttonOpenEmail;

    @FindBy(xpath = "//tr[2]//td[2]//h3")
    private WebElement emailCost;

    public GoogleMailPage() {
        super();
    }

    @Step("Switching to a new tab and creating temporary mail")
    public GoogleMailPage transitionNewPage() {
        logger.info("Switching to a new tab and creating temporary mail");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        return this;
    }

    @Step("Click on the copy button address email")
    public GoogleMailPage copyEmail() {
        logger.info("Click on the copy button address email");
        Actions actionProvider = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("c").build();
        keydown.perform();
        return this;
    }

    @Step("Return to the calculator page")
    public GoogleMailPage returnPageBack() {
        logger.info("Return to the calculator page");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().window(tabs.get(0));
        return this;
    }

    @Step("Return to the email page")
    public GoogleMailPage transitPageToEmail() {
        logger.info("Return to the email page");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    @Step("Open the received email")
    public GoogleMailPage openEmail() {
        logger.info("Open the received email");
        buttonOpenEmail.click();
        return this;
    }

    @Step("Get cost from field email")
    public String getCostFromEmail() {
        logger.info("Get cost from field email");
        return emailCost.getText();
    }
}
