package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pagegoogleobjectmodel.pages.AbstractPage;
import pagegoogleobjectmodel.util.DataReader;

import java.util.ArrayList;

public class FieldCloudPricingCalculatorStep extends AbstractPage {

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
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement fieldTypeGpu;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement typeGpu;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGpus;
    @FindBy(xpath = "//md-option[contains(@ng-repeat,'gpuType')]/div[contains(text(),'1')]")
    private WebElement valueNumberOfGpus;
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement fieldLocalSsd;
    @FindBy(xpath = "//md-option/div[contains(text(),'2x375 GB')]")
    private WebElement valueLocalSsd;
    @FindBy(xpath = "//*[@placeholder='Datacenter location']")
    private WebElement fieldDataCenterLocation;
    private By dataCenterLocation = By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]");
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement fieldCommitedUsage;
    @FindBy(xpath = "//*[@id='select_option_112']")
    private WebElement valueCommitedUsage;
    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement addToEstimate;
    @FindBy(xpath = "//h2/b[@class='ng-binding']")
    private WebElement actualTotalEstimatedCost;
    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement buttonEmailEstimate;
    @FindBy(xpath = "//body[@type='marketing']")
    private WebElement emptyFieldPage;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldForMailAddress;
    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement buttonSendMail;


    @When("Open Iframe")
    public void getIframe() {
        driver.switchTo().frame(iframeFirst);
        driver.switchTo().frame(iframeSecond);
    }

    @And("Activate section 'Compute Engine'")
    public void activeComputerEngine() {
        buttonComputerEngine.click();
    }

    @Then("Click field 'Number of instance:' and input value")
    public void activeInstancesAndInput() {
        fieldInstanceAndInput.click();
        valueInInstance.sendKeys(DataReader.getTestData("testdata.number.of.instance"));
    }

    @Then("Select the field series value")
    public void choiceSeriesValue() {
        String first = String.format("//*[@placeholder = '%s']", DataReader.getTestData("testdata.field.series"));
        driver.findElement(By.xpath(first)).click();
        String second = String.format("//md-option[@value='%s']", DataReader.getTestData("testdata.list.series"));
        driver.findElement(By.xpath(second)).click();
    }

    @Then("Select the instance type value")
    public void choiceInstanceValue() {
        String first = String.format("//*[@placeholder = '%s']", DataReader.getTestData("testdata.instance.type"));
        driver.findElement(By.xpath(first)).click();
        String second = String.format("//md-option[@value='%s']", DataReader.getTestData("testdata.instance.options"));
        driver.findElement(By.xpath(second)).click();
    }

    @Then("Activate section 'Add GPUs'")
    public void checkGpu() {
        sectionAddGpu.click();
    }

    @Then("Click filed 'typeGPU' and select NVIDIA Tesla 100")
    public void typeGpu() {
        fieldTypeGpu.click();
        typeGpu.click();
    }

    @Then("Click field 'Number of GPUs' and select value 'Number of GPUs'")
    public void choiseNumberOfGpus() {
        numberOfGpus.click();
        valueNumberOfGpus.click();
    }

    @Then("Click field 'LocalSSD' and select value 2x375Gb")
    public void choiseLocalSsd() {
        fieldLocalSsd.click();
        valueLocalSsd.click();
    }

    @Then("Click section Datacenter location and select Frankfurt europe-west3")
    public void locationDataCenter() {
        fieldDataCenterLocation.click();
        driver.findElements(dataCenterLocation).get(2).click();
    }

    @Then("Click section 'Committed usage' and select value '1 Year'")
    public void commitedUsage() {
        fieldCommitedUsage.click();
        valueCommitedUsage.click();
    }

    @Then("Click button 'Add to Estimate'")
    public void addToEstimate() {
        addToEstimate.click();
    }

    @Then("Saving the string value 'Total Estimated Cost'")
    public void saveCalculatorCost() {
        String calculatorCost = actualTotalEstimatedCost.getText();
    }

    @Then("Click button 'Email Estimate'")
    public void choiseEmailEstimate() {
        buttonEmailEstimate.click();
    }


    @When("Clicking on field for input email")
    public void emailEstimateClick() {
        emptyFieldPage.click();
        driver.switchTo().frame(iframeFirst);
        driver.switchTo().frame(iframeSecond);
        WebElement button = buttonEmailEstimate;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.sendKeys(Keys.PAGE_UP);
        button.sendKeys(Keys.PAGE_UP);
        button.click();
    }

    @Then("Inserting the copied email address from the created mail")
    public void inputCopyEmail() {
        WebElement fieldForAddress = fieldForMailAddress;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", fieldForAddress);
        fieldForAddress.sendKeys(Keys.PAGE_UP);
        fieldForAddress.click();
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).perform();
        builder.sendKeys("v").perform();
        builder.keyUp(Keys.CONTROL).perform();
    }

    @And("Click button 'Send Email'")
    public void sendMail() {
        buttonSendMail.click();
    }

    @And("Return to the email page")
    public void transitPageToEmail() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
