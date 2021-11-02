package pagegoogleobjectmodel.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class GoogleMailPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//span[@class='copy_icon']")
    private WebElement buttonCopyEmail;

    @FindBy(xpath = "//span[@class='small_message_icon']")
    private WebElement buttonOpenEmail;

    @FindBy(xpath = "//tr[3]//td[2]//h3")
    private WebElement emailCost;

    public GoogleMailPage() {
        super();
    }

    public GoogleMailPage transitionNewPage() {
        logger.info("Switching to a new tab and creating temporary mail");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public GoogleMailPage copyEmail() {
        logger.info("Click on the copy button address email");
        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("c").build();
        keydown.perform();
        return this;
    }

    public GoogleMailPage returnPageBack() {
        logger.info("Return to the calculator page");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return this;
    }

    public GoogleMailPage transitPageToEmail() {
        logger.info("Return to the email page");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public GoogleMailPage openEmail() {
        logger.info("Open the received email");
        buttonOpenEmail.click();
        return this;
    }

    public String getCostFromEmail() {
        logger.info("Get cost from field email");
        return emailCost.getText();
    }
}
