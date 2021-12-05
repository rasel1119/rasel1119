package utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    //@DataProvider(name = "SingleValue")
    public Object[][] storeSingleValue() {
        return new Object[][] {
                {"Rasel"},
                {"Abdullah"},
                {"John"}
        };
    }

    @DataProvider(name = "MultipleValues")
    public Object[][] storeMultipleValues() {
        return new Object[][] {
                {"Rasel", "Brooklyn", 11230},
                {"Abdullah", "Queens", 23566},
                {"John", "Bronx", 45889}
        };
    }

    @DataProvider(name = "CalculateReal_AprRate")
    public Object[][] storeRealAprRatesData() {
        return new Object[][] {
                {"200000", "15000", "3", "3.310%"}
        };
    }


    //@Test(dataProvider = "SingleValue")
    public void readSingleValue(String name) {
        System.out.println("[Single column value] Name is: " + name);
    }

    @Test(dataProvider = "MultipleValues")
    public void readMultipleValues(String name, String county, int zipCode) {
        System.out.println("[Multiple column value] Name is: " + name);
        System.out.println("[Multiple column value] County is: " + county);
        System.out.println("[Multiple column value] Zip Code is: " + zipCode);
    }
}
