package steps.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.objects.DatePage;

public class DateDefinitions {
    DatePage datePage;

    public DateDefinitions() {
        datePage = new DatePage();
    }

    @Given("the DateWeb app should be enabled")
    public void DateWebAppShouldBeEnabled() {
        datePage.loadPage();
    }

    @When("the user displays the calendar")
    public void userDisplaysTheCalendar() {
        datePage.clickInputFecha();
    }

    @And("^enters the following date: (.*)$")
    public void entersDate(String date) {
        boolean status = datePage.entersDate(date);
        Assert.assertTrue("Error message>> The selected date is not present: " +date,  status);
    }
}
