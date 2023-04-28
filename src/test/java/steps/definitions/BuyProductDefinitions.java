package steps.definitions;

import Convert.DataTableConvert;
import entity.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.objects.HomePage;
import page.objects.LoginPage;
import page.objects.PaymentPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static util.StoreData.SData;

public class BuyProductDefinitions {
    PaymentPage paymentPage;
    LoginPage loginPage;
    HomePage homePage;
    User user;
    Card card;

    @DataTableType
    public Order convertToOrder(Map<String, String> entry) {
        return DataTableConvert.convertToOrder(entry);
    }
    @DataTableType
    public Card convertToCard(Map<String, String> entry) {
        return DataTableConvert.convertToCard(entry);
    }
    public BuyProductDefinitions() {
        loginPage =new LoginPage();
        homePage =new HomePage();
        paymentPage = new PaymentPage();
        user = new User();
        card = new Card();
    }

    @Given("^the web should be enabled$")
    public void  webShouldBeEnabled() throws IOException {
        user.setFirstName(SData("name"));
        user.setEmail(SData("email"));
        user.setPassword(SData("pwd"));
        loginPage.loadPage();
        loginPage.loginToMyAccount(user);
    }

    @And("the user should be Logged to Home page")
    public void theUserShouldBeLoggedToHomePage() {
        homePage.isUserLoggedToHomePage(user);
    }

    @When("^the user selects items from Clothing Catalog$")
    public void theUserSelectsItemsFromClothingCatalog(List<Order> myOrders) throws InterruptedException {
        homePage.selectASetOFProducts(myOrders);
        Thread.sleep(3000);
    }

    @And("reviews the Shopping Card with selected products")
    public void reviewsTheShoppingCardWithSelectedProducts() {
        homePage.clickShoppingCart();
        homePage.clickCheckOut();
    }

    @And("adds a comment to Order: {string}")
    public void addsAComment(String value) {
        homePage.fillComment(value);
        homePage.clickCheckOut();
    }

    @And("enters info about the credit card")
    public void entersInfoAboutTheCreditCard(Card card) throws InterruptedException {
        paymentPage.fillCreditCard(card);
    }

    @And("confirms the process payment")
    public void confirmsTheProcessPayment() {
        paymentPage.clickConfirmOrder();
    }

    @Then("^the user should see this message (.*)$")
    public void theUserShouldSeeCongratulations(String expecMessage) {
        Assert.assertTrue(homePage.IsOrderConfirmed());
        String actualMessage = homePage.getText();
        Assert.assertEquals(actualMessage, expecMessage);
    }

    @Given("the user navigates to Products page")
    public void theUserNavigatesToProductsPage() throws InterruptedException {
        homePage.clickProducts();
    }

    @When("the user searches^chooses items from list")
    public void theUserSearchesChoosesItemsFromList(List<String> products) {
        for (String name: products ) {
            homePage.selectProduct(name);
        }
    }
}
