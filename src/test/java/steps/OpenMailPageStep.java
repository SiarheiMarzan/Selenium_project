package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pagegoogleobjectmodel.pages.AbstractPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OpenMailPageStep extends AbstractPage {

    @FindBy(xpath = "//span[@class='small_message_icon']")
    private WebElement buttonOpenEmail;
    @FindBy(xpath = "//tr[2]//td[2]//h3")
    private WebElement emailCost;

    @When("Switching to a new tab and creating temporary mail")
    public void transitionNewPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
    }

    @Then("Click on the copy button address email")
    public void copyEmail() {
        Actions actionProvider = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("c").build();
        keydown.perform();
    }

    @And("Return to the calculator page")
    public void returnPageBack() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().window(tabs.get(0));
    }

    @When("Open the received email")
    public void openEmail() {
        buttonOpenEmail.click();
    }

//    @And("")
//    public void checkCostResult(){
//        Assert.assertTrue(calculatorCost.contains(emailCost.getText()), "Invalid cost");
//    }


}
