package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RealApr {

    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomeValueInputField = By.name("HomeValue");
    private final By DownPaymentInDollarRadioButton = By.id("DownPaymentSel0");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By InterestRateInputField = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong/../../td[2]/strong");

    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    public WebDriver driver;

    public RealApr(WebDriver driver) {
        this.driver = driver;
    }

    public RealApr waitForPageToLoad() {
        LOGGER.debug("Wait for the Real Apr page to load");
        ActOn.element(driver, CalculatorTab).waitForElementToBeVisible();
        return  this;
    }

    public RealApr typeHomePrice(String value) {
        LOGGER.debug("Typing the home price: " + value);
        ActOn.element(driver, HomeValueInputField).setValue(value);
        return this;
    }

    public RealApr clickDownPaymentInDollar() {
        LOGGER.debug("Clicking on the radio button of down payment in dollar sign");
        ActOn.element(driver, DownPaymentInDollarRadioButton).click();
        return this;
    }

    public RealApr typeDownPayment(String value) {
        LOGGER.debug("Typing the down payment: " + value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public RealApr typeInterestRate(String value) {
        LOGGER.debug("Typing the interest rate: " + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public RealApr clickOnCalculateButton() {
        LOGGER.debug("Clicking on the Calculate button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public RealApr validateRealApr(String expectedAprRate) {
        LOGGER.debug("Validate the Real Apr rate is: " + expectedAprRate);
        String actualRealAprRate = ActOn.element(driver, ActualAprRate).getTextValue();
        Assert.assertEquals(actualRealAprRate, "3.130%");
        return this;
    }
}
