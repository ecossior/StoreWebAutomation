package page.objects;

import base.BasePage;
import driver.StoreDriver;
import entity.Order;
import entity.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//a[contains(.,'Cart')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//a[contains(.,'Products')]")
    private WebElement productsIcon;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement proceedToChecout;
    @FindBy(tagName = "textarea")
    private WebElement comment;

    @FindBy(xpath = "//h2/following-sibling::p")
    private WebElement confirmationMessage;

    @FindBy(id = "quantity")
    private WebElement quantity;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    private WebElement addToCartBtn;

    @FindBy(id = "search_product")
    private WebElement searchProductTxt;

    @FindBy(id="submit_search")
    private WebElement submitSearchBtn;

    @FindBy(xpath = "//div[@class='overlay-content']/a[.='Add to cart']")
    private WebElement overAddToCartBtn;
    private Boolean disabledScript = false;
    private Boolean disabledScript2 = false;
    public HomePage() {
        super(StoreDriver.getInstance());
        PageFactory.initElements(driver,this);
    }
    public void isUserLoggedToHomePage(User user) {
        String locator = String.format("//a[contains(.,'Logged in as %s')]",user.getFirstName());
        WebElement title = driver.findElement(By.xpath(locator));
        Assert.assertTrue(title.isDisplayed());
    }
    private void clickSelectCategory(String category){
        if (disabledScript==false) moveScrollDown();
        String locator = String.format("//a[@href='#%s']", category);
        WebElement webElement = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }
    private void moveScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
        disabledScript =true;
    }
    private void clickSelectSubCategory(String catName, String subName){
        String locator = String.format("//div[@id='%s']//a[contains(.,'%s')]",catName,subName);
        WebElement webElement = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }
    private void clickAddToCart(){
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
        addToCartBtn.click();
    }
    private void clickItemViewProduct(String num){
        String locator = String.format("//a[@href='/product_details/%s']", num);
        WebElement itemViewProduct = driver.findElement(By.xpath(locator));
        itemViewProduct.click();
    }
    private void clickContinueShopping(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        continueShoppingBtn.click();
    }
    public void clickOverAddToCartBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        String locator = "//div[@class='product-image-wrapper']/div/div/img";
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOf(overAddToCartBtn));
        overAddToCartBtn.click();
    }
    private void fillQuantity(String q){
        quantity.clear();
        quantity.sendKeys(q);
    }
    public void fillComment(String value){
        wait.until(ExpectedConditions.visibilityOf(comment));
        comment.sendKeys(value);
    }

    public void clickProducts() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(productsIcon));
        productsIcon.click();
        Thread.sleep(5000);
    }
    public void clickShoppingCart(){
        wait.until(ExpectedConditions.visibilityOf(cartIcon));
        cartIcon.click();
    }

    public void clickCheckOut(){
        wait.until(ExpectedConditions.visibilityOf(proceedToChecout));
        proceedToChecout.click();
    }
    public void fillSearchProduct(String value){
        wait.until(ExpectedConditions.visibilityOf(searchProductTxt));
        searchProductTxt.clear();
        searchProductTxt.sendKeys(value);
    }
    public void clickSubmitSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(submitSearchBtn));
        submitSearchBtn.click();
    }

    public void selectProduct(Order item) throws InterruptedException {
        clickSelectCategory(item.getCategory());
        clickSelectSubCategory(item.getCategory(),item.getType());
        Thread.sleep(3000);
        clickItemViewProduct(item.getQuantity());
        fillQuantity(item.getQuantity());
        clickAddToCart();
        clickContinueShopping();
    }
    public void selectProduct( String name){
        fillSearchProduct(name);
        clickSubmitSearch();
        clickOverAddToCartBtn();
        clickContinueShopping();
    }

    public void selectASetOFProducts( List<Order> myOrders) throws InterruptedException {
        for (Order item : myOrders) {
            selectProduct(item);
            Thread.sleep(2000);
        }
    }
    public Boolean IsOrderConfirmed(){
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.isDisplayed();
    }

    public String getText(){
        return confirmationMessage.getText();
    }
}
