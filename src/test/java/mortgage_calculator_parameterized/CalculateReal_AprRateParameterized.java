package mortgage_calculator_parameterized;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.DataProviderClass;
import utilities.ReadConfigFiles;

public class CalculateReal_AprRateParameterized {

    //private final By RatesLink = By.linkText("Rates");
    //private final By RealAprLink = By.linkText("Real APR");

    private static final Logger LOGGER = LogManager.getLogger(CalculateReal_AprRateParameterized.class);

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        String url = "https://www.mortgagecalculator.org/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("-----------------Test Name: Calculating Real Apr------------------");

        String browserUrl = ReadConfigFiles.getPropertiesValues("Url");

        ActOn.browser(driver).openBrowser(browserUrl);
        //ActOn.browser(driver).openBrowser(url);
    }

//    private void navigateToRealAprPage() {
//
//        // Mouse Hover to Rates Link
//        ActOn.element(driver, RatesLink).mouseHover();
//
//        // Click on Real APR Link
//        ActOn.element(driver, RealAprLink).click();
//
//        // Wait for the Page to Load
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorTab));
//    }

//    private void enterData() {
//
//        ActOn.element(driver, HomeValueInputField).setValue("200000");
//
//        ActOn.element(driver, DownPaymentInDollarRadioButton).click();
//        ActOn.element(driver, DownPaymentInputField).setValue("15000");
//
//        ActOn.element(driver, InterestRateInputField).setValue("3%");
//
//    }

    @Test(dataProvider = "CalculateReal_AprRate", dataProviderClass = DataProviderClass.class)
    public void calculateRealApr(String homePrice, String downPayment, String interestRate, String expectedApr) {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice(homePrice)
                .clickDownPaymentInDollar()
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculateButton()
                .validateRealApr(expectedApr);
//        //ActOn.element(driver, CalculateButton).click();
    }

    @AfterMethod
    public void closeBrowser() {
        LOGGER.info("-------End Test Case: Calculate Real Apr-------");
        ActOn.browser(driver).close();
    }
}





