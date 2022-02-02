package pagegoogleobjectmodel.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagegoogleobjectmodel.driver.DriverSingleton;
import pagegoogleobjectmodel.pages.GoogleCalculatorPage;
import pagegoogleobjectmodel.pages.GoogleMailPage;
import pagegoogleobjectmodel.pages.GoogleSearchPage;
import pagegoogleobjectmodel.util.DataReader;
import pagegoogleobjectmodel.util.TestListener;

@Listeners({TestListener.class})
@Epic("Checking tests")
@Feature("GoogleCloudTest")
public class GoogleCloudTest {

    private GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage();
    private GoogleMailPage googleMailPage = new GoogleMailPage();
    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Test(priority = 0, description = "")
    public void googleCalculatorHardTest() {

        googleSearchPage.openPage().cloudGoogleSearch(DataReader.getTestData("testdata.value.field.find"))
                .moveSearhResult();
        googleCalculatorPage.getIframe().activeComputerEngine()
                .activeInstancesAndInput(DataReader.getTestData("testdata.number.of.instance"))
                .choiceValue(DataReader.getTestData("testdata.field.series"), DataReader.getTestData("testdata.list.series"))
                .choiceValue(DataReader.getTestData("testdata.instance.type"), DataReader.getTestData("testdata.instance.options"))
                .checkGpu()
                .typeGpu()
                .choiseNumberOfGpus()
                .choiseLocalSsd()
                .locationDataCenter()
                .commitedUsage()
                .addToEstimate();
        String calculatorCost = googleCalculatorPage.calculatedTotalEstimatedCost();
        googleCalculatorPage.choiseEmailEstimate();
        googleMailPage.transitionNewPage()
                .copyEmail()
                .returnPageBack();
        googleCalculatorPage.emailEstimateClick()
                .inputCopyEmail()
                .sendMail();
        googleMailPage.transitPageToEmail()
                .openEmail();
        String emailCost = googleMailPage.getCostFromEmail();
        Assert.assertTrue(calculatorCost.contains(emailCost), "Invalid cost");
        DriverSingleton.closeDriver();

    }

}

