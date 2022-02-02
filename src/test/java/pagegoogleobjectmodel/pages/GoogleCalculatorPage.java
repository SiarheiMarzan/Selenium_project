package pagegoogleobjectmodel.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class GoogleCalculatorPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private By dataCenterLocation = By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]");

    @FindBy(xpath = "//iframe[contains(@src,'index')]")
    private WebElement iframeFirst;

    @FindBy(id = "myFrame")
    private WebElement iframeSecond;

    @FindBy(xpath = "//div[@class='name ng-binding'][text()='Compute Engine']")
    private WebElement buttonComputerEngine;

    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement fieldInstanceAndInput;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement valueInInstance;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement sectionAddGpu;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGpus;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'gpuType')]/div[contains(text(),'1')]")
    private WebElement valueNumberOfGpus;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement fieldTypeGpu;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement typeGpu;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement fieldLocalSsd;

    @FindBy(xpath = "//md-option/div[contains(text(),'2x375 GB')]")
    private WebElement valueLocalSsd;

    @FindBy(xpath = "//*[@placeholder='Datacenter location']")
    private WebElement fieldDataCenterLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement fieldCommitedUsage;

    @FindBy(xpath = "//*[@id='select_option_112']")
    private WebElement valueCommitedUsage;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement addToEstimate;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//body[@type='marketing']")
    private WebElement emptyFieldPage;

    @FindBy(xpath = "//input[contains(@class, 'ng-valid-email')]")
    private WebElement copyInFieldEmail;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement buttonSendMail;

    @FindBy(xpath = "//h2/b[@class='ng-binding']")
    private WebElement actualTotalEstimatedCost;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldForMailAddress;


    public GoogleCalculatorPage() {
        super();
    }

    @Step("Open Iframe")
    public GoogleCalculatorPage getIframe() {
        logger.info("open Iframe");
        driver.switchTo().frame(iframeFirst);
        driver.switchTo().frame(iframeSecond);
        return this;
    }

    @Step("Activate section 'Compute Engine'")
    public GoogleCalculatorPage activeComputerEngine() {
        logger.info("Activate section 'Compute Engine'");
        buttonComputerEngine.click();
        return this;
    }

    @Step("Click field 'Number of instance:' and input value")
    public GoogleCalculatorPage activeInstancesAndInput(String number) {
        logger.info("Click field 'Number of instance:' and input value");
        fieldInstanceAndInput.click();
        valueInInstance.sendKeys(number);
        return this;
    }

    @Step("Select the instance type value")
    public GoogleCalculatorPage choiceValue(String holder, String option) {
        logger.info("Select the instance type value");
        String first = String.format("//*[@placeholder = '%s']", holder);
        driver.findElement(By.xpath(first)).click();
        String second = String.format("//md-option[@value='%s']", option);
        driver.findElement(By.xpath(second)).click();
        return this;
    }

    @Step("Activate section 'Add GPUs'")
    public GoogleCalculatorPage checkGpu() {
        logger.info("Activate section 'Add GPUs'");
        sectionAddGpu.click();
        return this;
    }

    @Step("Click filed 'typeGPU' and select NVIDIA Tesla 100")
    public GoogleCalculatorPage typeGpu() {
        logger.info("Click filed 'typeGPU' and select NVIDIA Tesla 100");
        fieldTypeGpu.click();
        typeGpu.click();
        return this;
    }

    @Step("Click field 'Number of GPUs' and select value 'Number of GPUs'")
    public GoogleCalculatorPage choiseNumberOfGpus() {
        logger.info("Click field 'Number of GPUs' and select value 'Number of GPUs'");
        numberOfGpus.click();
        valueNumberOfGpus.click();
        return this;
    }

    @Step("Click field 'LocalSSD' and select value 2x375Gb")
    public GoogleCalculatorPage choiseLocalSsd() {
        logger.info("Click field 'LocalSSD' and select value 2x375Gb");
        fieldLocalSsd.click();
        valueLocalSsd.click();
        return this;
    }

    @Step("Click section 'Datacenter location' and select Frankfurt(europe-west3)")
    public GoogleCalculatorPage locationDataCenter() {
        logger.info("Click section 'Datacenter location' and select Frankfurt(europe-west3)");
        fieldDataCenterLocation.click();
        driver.findElements(dataCenterLocation).get(2).click();
        return this;
    }

    @Step("Click section 'Commited usage' and select value '1 Year'")
    public GoogleCalculatorPage commitedUsage() {
        logger.info("Click section 'Commited usage' and select value '1 Year'");
        fieldCommitedUsage.click();
        valueCommitedUsage.click();
        return this;
    }

    @Step("Click button 'Add to Estimate'")
    public GoogleCalculatorPage addToEstimate() {
        logger.info("Click button 'Add to Estimate'");
        addToEstimate.click();
        return this;
    }

    @Step("Click button 'Email Estimate'")
    public GoogleCalculatorPage choiseEmailEstimate() {
        logger.info("Click button 'Email Estimate'");
        buttonEmailEstimate.click();
        return this;
    }

    @Step("Saving the string value 'Total Estimated Cost'")
    public String calculatedTotalEstimatedCost() {
        logger.info("Saving the string value 'Total Estimated Cost'");
        return actualTotalEstimatedCost.getText();
    }

    @Step("Clicking on field for input email")
    public GoogleCalculatorPage emailEstimateClick() {
        logger.info("Clicking on field for input email");
        emptyFieldPage.click();
        driver.switchTo().frame(iframeFirst);
        driver.switchTo().frame(iframeSecond);
        WebElement button = buttonEmailEstimate;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.sendKeys(Keys.PAGE_UP);
        button.sendKeys(Keys.PAGE_UP);
        button.click();
        return this;
    }

    @Step("Inserting the copied email address from the created mail")
    public GoogleCalculatorPage inputCopyEmail() {
        logger.info("Inserting the copied email address from the created mail");
        WebElement fieldForAddress = fieldForMailAddress;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", fieldForAddress);
        fieldForAddress.sendKeys(Keys.PAGE_UP);
        fieldForAddress.click();
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).perform();
        builder.sendKeys("v").perform();
        builder.keyUp(Keys.CONTROL).perform();
        return this;
    }

    @Step("Click button 'Send Email'")
    public GoogleCalculatorPage sendMail() {
        logger.info("Click button 'Send Email'");
        buttonSendMail.click();
        return this;
    }
}