package steps.definitions;

import driver.StoreDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public static void setupDriver(){
        StoreDriver.getInstance();
    }

    @After
    public static void tearDown() {
        StoreDriver.getInstance().manage().deleteAllCookies();
        StoreDriver.getInstance().quit();

    }
}
