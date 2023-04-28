package page.objects;

import base.BasePage;
import driver.StoreDriver;
import entity.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class AccountInformationPage extends BasePage{

    @FindBy(id = "id_gender1")
    private WebElement mrRdb;
    @FindBy(id = "id_gender2")
    private WebElement mrsRdb;
    @FindBy(id = "password")
    private WebElement passwordTxt;
    @FindBy(id = "days")
    private WebElement daysCbo;
    @FindBy(id = "months")
    private WebElement monthsCbo;
    @FindBy(id = "years")
    private WebElement yearsCbo;
    @FindBy(xpath = "//label[@for='newsletter']")
    private WebElement newsletterChk;
    @FindBy(xpath = "//label[@for='optin']")
    private WebElement optinChk;
    @FindBy(id = "first_name") 
    private WebElement firstNameTxt;
    @FindBy(id = "last_name")
    private WebElement lastNameTxt;
    @FindBy(id = "company")
    private WebElement companyTxt;
    @FindBy(id = "address1")
    private WebElement address1Txt;
    @FindBy(id = "address2")
    private WebElement address2Txt;
    @FindBy(id = "country")
    private WebElement countryCbo;
    @FindBy(id = "state")
    private WebElement stateTxt;
    @FindBy(id = "city")
    private WebElement cityTxt;
    @FindBy(id = "zipcode")
    private WebElement zipcodeTxt;
    @FindBy(id = "mobile_number")
    private WebElement mobileNumberTxt;
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAccountBtn;
    public AccountInformationPage(){
        super(StoreDriver.getInstance());
        PageFactory.initElements(driver,this);
    }

    private void clickMr() {
        wait.until(ExpectedConditions.elementToBeClickable(mrRdb));
        mrRdb.click();
    }

    private void clickMrs() {
        wait.until(ExpectedConditions.elementToBeClickable(mrsRdb));
        mrsRdb.click();
    }

    private void fillPassword(String value) {
        wait.until(ExpectedConditions.visibilityOf(passwordTxt));
        passwordTxt.sendKeys(value);
    }
    private void selectDay(String day){
            new Select(daysCbo).selectByVisibleText(day);
    }
    private void selectMonths(String month){
            new Select(monthsCbo).selectByVisibleText(month);
    }
    private void selectYears(String year){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        new Select(yearsCbo).selectByValue(year);
    }
    private void clickNewsletter() {
        wait.until(ExpectedConditions.elementToBeClickable(newsletterChk));
        newsletterChk.click();
    }
    private void clickOptin() {
        wait.until(ExpectedConditions.elementToBeClickable(optinChk));
        optinChk.click();
    }
    private void fillFirstName(String value){
        wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
        firstNameTxt.sendKeys(value);
    }
    private void fillLastName(String value){
        wait.until(ExpectedConditions.visibilityOf(lastNameTxt));
        lastNameTxt.sendKeys(value);
    }
    private void fillCompany(String value){
        wait.until(ExpectedConditions.visibilityOf(companyTxt));
        companyTxt.sendKeys(value);
    }
    private void fillAddress1(String value){
        wait.until(ExpectedConditions.visibilityOf(address1Txt));
        address1Txt.sendKeys(value);
    }
    private void fillAddress2(String value){
        wait.until(ExpectedConditions.visibilityOf(address2Txt));
        address2Txt.sendKeys(value);
    }
    private void selectCountry(String value){
        new Select(countryCbo).selectByVisibleText(value);
    }
    private void fillState(String value){
        wait.until(ExpectedConditions.visibilityOf(stateTxt));
        stateTxt.sendKeys(value);
    }
    private void fillCity(String value){
        wait.until(ExpectedConditions.visibilityOf(cityTxt));
        cityTxt.sendKeys(value);
    }
    private void fillZipcode(String value){
        wait.until(ExpectedConditions.visibilityOf(zipcodeTxt));
        zipcodeTxt.sendKeys(value);
    }
    private void fillMobileNumber(String value){
        wait.until(ExpectedConditions.visibilityOf(mobileNumberTxt));
        mobileNumberTxt.sendKeys(value);
    }
    private void clickCreateAccount() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn));
        createAccountBtn.click();
    }

    public void enterAccountInformation(User user) {
        if (user.getTitle().equals("Mr")) {clickMr(); }
        else if (user.getTitle().equals("Mrs")){clickMrs();}
        fillPassword(user.getPassword());
        selectDay(user.getDay());
        selectMonths(user.getMonth());
        selectYears(user.getYear());
        if (user.getNewsletter().equals("y")) clickNewsletter();
        if (user.getReceiveoOffers().equals("y")) clickOptin();
        fillFirstName(user.getFirstName());
        fillLastName(user.getLastName());
        fillCompany(user.getCompany());
        fillAddress1(user.getAddress());
        fillAddress2(user.getAddress2());
        selectCountry(user.getCountry());
        fillState(user.getState());
        fillCity(user.getCity());
        fillZipcode(user.getZipcode());
        fillMobileNumber(user.getMobileNumber());
        clickCreateAccount();
    }
}