package steps.definitions;

import entity.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.AccountCreatedPage;
import page.objects.AccountInformationPage;
import page.objects.LoginPage;

import java.io.IOException;

public class RegisterUserDefinitions {
    LoginPage loginPage;
    AccountInformationPage accountInformationPage;
    AccountCreatedPage accountCreatedPage;
    User user;

    public RegisterUserDefinitions() {
        loginPage =new LoginPage();
        accountInformationPage= new AccountInformationPage();
        accountCreatedPage = new AccountCreatedPage();
        user = new User();
    }

    @Given("^enters an account that it is not registered (.*) (.*)$")
    public void EntersAnAccountThatItIsNotRegistered(String email, String password) {
        user.setEmail(email);
        user.setPassword(password);
        loginPage.loginToMyAccount(user);
    }

    @And("the Login page displays, {string}")
    public void theLoginPageDisplays(String errorMessage) {
        loginPage.isErrorDisplayed(errorMessage);
    }

    @When("^the user enters (.*) and (.*) for New User Signup$")
    public void theUserEntersNameAndEmailForNewUserSignup(String name, String email) {
        user.setEmail(email);
        user.setName(name);
        loginPage.newUserSignup(user);
    }

    @And("^enters information to create a new account$")
    public void EntersInformationToCreateANewAccount(DataTable dataTable) {
        User user;
        String title = dataTable.cell(0,1);
        String password = dataTable.cell(1,1);
        String day = dataTable.cell(2,1);
        String month = dataTable.cell(3,1);
        String year = dataTable.cell(4,1);
        String newsletter = dataTable.cell(5,1);
        String receiveoOffers = dataTable.cell(6,1);
        String firstName = dataTable.cell(7,1);
        String lastName = dataTable.cell(8,1);
        String company = dataTable.cell(9,1);
        String address = dataTable.cell(10,1);
        String address2 = dataTable.cell(11,1);
        String country = dataTable.cell(12,1);
        String state = dataTable.cell(13,1);
        String city = dataTable.cell(14,1);
        String zipcode = dataTable.cell(15,1);
        String mobileNumber = dataTable.cell(16,1);

       user = new User(title,password, day, month,year, newsletter,
               receiveoOffers, firstName, lastName, company, address, address2,
                    country, state, city, zipcode, mobileNumber);
       accountInformationPage.enterAccountInformation(user);
    }
    @Then("^the user should see in Account Created page: (.*)$")
    public void theUserShouldSeeInAccountCreatedPage(String confirmationMessage){
        accountCreatedPage.isAccountCreated(confirmationMessage);
    }

    @Given("the user opens login page")
    public void theUserOpensLoginPage() throws IOException {
        loginPage.loadPage();
    }

}
