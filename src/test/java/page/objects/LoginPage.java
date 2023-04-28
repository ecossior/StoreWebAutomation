package page.objects;

import base.BasePage;
import driver.StoreDriver;
import entity.User;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static util.StoreData.SData;

import java.io.IOException;

public class LoginPage extends BasePage {
    @FindBy(xpath="//input[@data-qa='login-password']")
    private WebElement passwordTxt;
    @FindBy(xpath="//button[normalize-space()='Login']")
    private  WebElement loginBtn;
    @FindBy(name="name")
    private WebElement nameTxt;
    @FindBy(xpath="//button[.='Signup']")
    private WebElement signupBtn;
    @FindBy(xpath="//input[@type='password']/following-sibling::p")
    private WebElement invalidCredentials;
    @FindBy(xpath="//input[@data-qa='login-email']")
    private WebElement loginEmailTxt;
    @FindBy(xpath="//input[@data-qa='signup-email']")
    private WebElement signupEmailTxt;

   public LoginPage() {
        super(StoreDriver.getInstance());
        PageFactory.initElements(this.driver,this);
    }

    private void fillLoginEmail(String value){
        wait.until(ExpectedConditions.visibilityOf(loginEmailTxt));
        loginEmailTxt.sendKeys(value);
    }
    private void fillSignupEmail(String value){
        wait.until(ExpectedConditions.visibilityOf(signupEmailTxt));
        signupEmailTxt.sendKeys(value);
    }
    private void fillPassword(String value){
        wait.until(ExpectedConditions.visibilityOf(passwordTxt));
        passwordTxt.sendKeys(value);
    }
    private void fillName(String value){
        wait.until(ExpectedConditions.visibilityOf(nameTxt));
        nameTxt.sendKeys(value);
    }

    private void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }
    private void clickSignupBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(signupBtn));
        signupBtn.click();
    }
    public void loginToMyAccount(User user){
        fillLoginEmail(user.getEmail());
        fillPassword(user.getPassword());
        clickLogin();
    }
    public void isErrorDisplayed(String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOf(invalidCredentials));
        Assert.assertEquals(invalidCredentials.getText(),expectedMessage);
        Assert.assertTrue(invalidCredentials.isDisplayed());
    }
    public void newUserSignup(User user){
        fillSignupEmail(user.getEmail());
        fillName(user.getName());
        clickSignupBtn();
    }
    public void loadPage() throws IOException {
        driver.get(SData("url"));
    }
}
