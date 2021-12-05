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
import utilities.DateUtils;
import utilities.ReadConfigFiles;
import utilities.SqlConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateMortgageRateParameterized {

    private static final Logger LOGGER = LogManager.getLogger(CalculateMortgageRateParameterized.class);

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("-----------------Test Name: Calculate Monthly Payment------------------");

        String browserUrl = ReadConfigFiles.getPropertiesValues("Url");

        ActOn.browser(driver).openBrowser(browserUrl);

        //  ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");

    }

    @Test
    public void calculateMonthlyPayment() {

        String date = DateUtils.returnNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];

        ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
        try {
            while (rs.next())
                new NavigationBar(driver)
                        .navigateToHome()
                        .typeHomePrice(rs.getString("homevalue"))
                        .typeDownPayment(rs.getString("downpayment"))
                        .clickOnDownPaymentInDollar()
                        .typeLoanAmount(rs.getString("downpaymentoption"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTermYears(rs.getString("loanterm"))
                        .selectMonth(month)
                        .typeYear(year)
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePmi(rs.getString("pmi"))
                        .typeHoi(rs.getString("homeownerinsurance"))
                        .typeHoa(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefi(rs.getString("buyorrefi"))
                        .clickOnCalculateButton()
                        .validateTotalMonthlyPayment(rs.getString("expectedTotalMonthlyPayment"));
            } catch (SQLException e) {
                LOGGER.error("Sql connection error" +e.getMessage());
        }
    }

    @AfterMethod
    public void quitBrowser() {
        LOGGER.info("-------End Test Case");
        //ActOn.browser(driver).close();
    }
}
