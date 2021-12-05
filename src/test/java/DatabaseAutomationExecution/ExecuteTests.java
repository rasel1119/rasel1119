package DatabaseAutomationExecution;

import org.testng.annotations.Test;
import parameters.DataClass;

public class ExecuteTests {
    @Test(dataProvider = "MultipleValues", dataProviderClass = DataClass.class)
    public void run(String name, String county, int zipCode) {
        System.out.println("[Multiple column value] Name is: " + name);
        System.out.println("[Multiple column value] County is: " + county);
        System.out.println("[Multiple column value] Zip Code is: " + zipCode);
    }
}
