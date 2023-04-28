package page.objects;

import base.BasePage;
import driver.StoreDriver;
import entity.Card;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {
    @FindBy(name = "name_on_card")
    private WebElement cardNameTxt;
    @FindBy(name = "card_number")
    private  WebElement numberTxt;
    @FindBy(name = "cvc")
    private WebElement cvcTxt;
    @FindBy(name = "expiry_month")
    private WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    private WebElement expiryYear;
    @FindBy(id = "submit")
    private WebElement confirmOrderBtn;

    public PaymentPage() {
        super(StoreDriver.getInstance());
        PageFactory.initElements(driver,this);
    }

    public void fillCreditCard(Card card) throws InterruptedException {
        Thread.sleep(3000);
        cardNameTxt.sendKeys(card.getName());
        numberTxt.sendKeys(card.getCardNumber());
        cvcTxt.sendKeys(card.getCVC());
        expiryMonth.sendKeys(card.getMonth());
        expiryYear.sendKeys(card.getYear());
    }
    public void clickConfirmOrder(){
        confirmOrderBtn.click();
    }
}
