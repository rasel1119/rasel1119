package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By SelectDownPaymentInDollar = By.name("param[downpayment_type]");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartingMonthDropDown = By.name("param[start_month]");
    private final By StartingYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PrivateMortgageInsurance = By.id("pmi");
    private final By YearlyHomeInsurance = By.id("hoi");
    private final By YearlyHomeOwnerAssociationFee = By.id("hoa");
    private final By SelectLoanTypeDropDown = By.name("param[milserve]");
    private final By CompareLoanTypeSelection = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    WebDriver driver;
    public Home (WebDriver driver) {
        this.driver = driver;
    }

    public Home typeHomePrice( String value) {
        LOGGER.debug("Typing the home price: " + value);
        ActOn.element(driver, HomeValueInputField).setValue(value);
        return this;
    }

    public Home typeDownPayment(String value) {
        LOGGER.debug("Typing the down payment: " + value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public Home clickOnDownPaymentInDollar() {
        LOGGER.debug("Clicking on the $ radio button");
        ActOn.element(driver, SelectDownPaymentInDollar).click();
        return this;
    }

    public Home typeLoanAmount(String value) {
        LOGGER.debug("Typing g the loan amount: " + value);
        ActOn.element(driver, LoanAmountInputField).setValue(value);
        return this;
    }

    public Home typeInterestRate(String value) {
        LOGGER.debug("Typing the interest rate: " + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public Home typeLoanTermYears(String value) {
        LOGGER.debug("Typing the loan term years: " + value);
        ActOn.element(driver, LoanTermInputField).setValue(value);
        return this;
    }

    public Home selectMonth(String value) {
        LOGGER.debug("Selecting the start month: " + value);
        ActOn.element(driver, StartingMonthDropDown).selectValue(value);
        return this;
    }

    public Home typeYear(String value) {
        LOGGER.debug("Typing the start year: " + value);
        ActOn.element(driver, StartingYearInputField).setValue(value);
        return this;
    }

    public Home typePropertyTax(String value) {
        LOGGER.debug("Typing the property tax: " + value);
        ActOn.element(driver, PropertyTaxInputField).setValue(value);
        return this;
    }

    public Home typePmi(String value) {
        LOGGER.debug("Typing the PMI: " + value);
        ActOn.element(driver, PrivateMortgageInsurance).setValue(value);
        return this;
    }

    public Home typeHoi(String value) {
        LOGGER.debug("Typing the HOI");
        ActOn.element(driver, YearlyHomeInsurance).setValue(value);
        return this;
    }

    public Home typeHoa(String value) {
        LOGGER.debug("Typing the HOA: " + value);
        ActOn.element(driver, YearlyHomeOwnerAssociationFee).setValue(value);
        return this;
    }

    public Home selectLoanType(String value) {
        LOGGER.debug("Selecting loan type: " + value);
        ActOn.element(driver, SelectLoanTypeDropDown).selectValue(value);
        return this;
    }

    public Home selectBuyOrRefi(String value) {
        LOGGER.debug("Selecting the BuyOrRefi option: " + value);
        ActOn.element(driver, CompareLoanTypeSelection).selectValue(value);
        return this;
    }

    public Home clickOnCalculateButton() {
        LOGGER.debug("Clicking on the calculate button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public Home validateTotalMonthlyPayment(String expectedTotalMonthlyPayment) {
        String formattedXpath = String.format("//h3[contains(text(),'$%s')]", expectedTotalMonthlyPayment);
        By monthlyPayment = By.xpath(formattedXpath);

        LOGGER.debug("Validating total monthly payment is: " + expectedTotalMonthlyPayment);
        AssertThat.elementAssertions(driver, monthlyPayment).elementIsDisplayed();
        return this;
    }

}
