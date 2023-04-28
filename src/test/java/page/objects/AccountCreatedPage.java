package page.objects;
import base.BasePage;
import driver.StoreDriver;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountCreatedPage extends BasePage {
    @FindBy(tagName = "b")
    private WebElement title;
    public AccountCreatedPage() {
        super(StoreDriver.getInstance());
        PageFactory.initElements(driver,this);
    }
    public void isAccountCreated(String expectedMessage){
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals(title.getText(),expectedMessage);
        Assert.assertTrue(title.isDisplayed());
    }
}