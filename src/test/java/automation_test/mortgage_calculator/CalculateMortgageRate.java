package automation_test.mortgage_calculator;

import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.DateUtils;

public class CalculateMortgageRate  extends BaseClassUITests {

    @Test
    public void calculateMonthlyPayment() {

        String date = DateUtils.returnNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];

        new NavigationBar(driver)
                .navigateToHome()
                .typeHomePrice("300000")
                .typeDownPayment("60000")
                .clickOnDownPaymentInDollar()
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYears("30")
                .selectMonth(month)
                .typeYear(year)
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHoi("1000")
                .typeHoa("100")
                .selectLoanType("FHA")
                .selectBuyOrRefi("Buy")
                .clickOnCalculateButton()
                .validateTotalMonthlyPayment("1,611.85");
    }

}
