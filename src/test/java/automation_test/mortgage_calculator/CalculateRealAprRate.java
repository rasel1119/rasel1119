package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class CalculateRealAprRate extends BaseClassUITests {

    //private final By RatesLink = By.linkText("Rates");
    //private final By RealAprLink = By.linkText("Real APR");

    public WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        String url = "https://www.mortgagecalculator.org/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(url);
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

    @Test
    public void calculateRealApr() {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice("200000")
                .clickDownPaymentInDollar()
                .typeDownPayment("15000")
                .typeInterestRate("3")
                .clickOnCalculateButton()
                .validateRealApr("3.310");
//        //ActOn.element(driver, CalculateButton).click();
    }
    @AfterMethod
    public void closeBrowser() {

        ActOn.browser(driver).close();
    }
}





