package page.objects;

import base.BasePage;
import driver.StoreDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.StoreData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadPage extends BasePage {
    @FindBy(xpath = "//input[@name='files[]']")
    private WebElement addFiles_btn;
    @FindBy(xpath = "//button[@class='btn btn-primary start']")
    private WebElement start;
    @FindBy(xpath = "//div[@class='progress-bar progress-bar-success' and contains(@style,'100%')]")
    private WebElement progressbarCompleted;
    public UploadPage() {
        super(StoreDriver.getInstance());
        PageFactory.initElements(driver, this);
    }
    public boolean isDisplayed(String name) {
        String locator = String.format("//p/a[.='%s']", name);
        WebElement image = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
        return image.isDisplayed();
    }
    public void uploadImages(List<String> images) throws InterruptedException {
        String folder= "src/test/resources/Images/";
        for (String image: images) {
            File file = new File(folder + image);
            String imagePath = file.getAbsolutePath();
            addFiles_btn.sendKeys(imagePath);
        }
        Thread.sleep(2000);
        start.click();
        wait.until(ExpectedConditions.visibilityOf(progressbarCompleted));
    }
    public boolean areAllImagesUploaded(List<String> list) {
        for (String image: list) {
            if (isDisplayed(image)==false) {
             return false;
            }
        }
        return true;
    }
    public void loadPage()  {
        try {
            driver.get(StoreData.SData("upload"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
