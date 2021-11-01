package pagegoogleobjectmodel.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagegoogleobjectmodel.driver.DriverSingleton;
import pagegoogleobjectmodel.pages.GoogleCalculatorPage;
import pagegoogleobjectmodel.pages.GoogleMailPage;
import pagegoogleobjectmodel.pages.GoogleSearchPage;
import pagegoogleobjectmodel.util.TestListener;

@Listeners({TestListener.class})

public class GoogleCloudTest {

    private GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage();
    private GoogleMailPage googleMailPage = new GoogleMailPage();
    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    private DriverSingleton driverSingleton = new DriverSingleton();

    @Test
    public void googleCalculatorHardTest() {

        googleSearchPage.openPage().cloudGoogleSearch("Google Cloud Platform Pricing Calculator").moveSearhResult();
        googleCalculatorPage.getIframe().activeComputerEngine()
                .activeInstancesAndInput("4")
                .choiceValue("Series", "n1")
                .choiceValue("Instance type", "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
                .checkGpu()
                .choiseNumberOfGpus()
                .choiseNumberOfGpus()
                .typeGpu()
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
        Assert.assertTrue(calculatorCost.contains(emailCost),"Invalid cost");
        driverSingleton.closeDriver();

    }

}

