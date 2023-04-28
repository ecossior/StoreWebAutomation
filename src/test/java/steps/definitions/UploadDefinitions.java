package steps.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import page.objects.UploadPage;
import java.util.List;

public class UploadDefinitions {
    UploadPage uploadPage;
    List<String> list;
    public UploadDefinitions() {
        uploadPage = new UploadPage();
    }

    @Given("the Wep App should be enabled")
    public void theWebAppShoulBeEnabled() {
        uploadPage.loadPage();
    }

    @And("the user uploads a set of images:")
    public void theUserUploadsASetOfFiles(List<String> images) throws InterruptedException {
        uploadPage.uploadImages(images);
        list=images;
    }

    @Then("the user should see the Images list uploaded")
    public void theUserShouldSeeTheList()  {
        Assert.assertTrue(uploadPage.areAllImagesUploaded(list));
    }
}