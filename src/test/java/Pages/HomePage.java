package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@class='img-responsive']")
    WebElement imageHome;

   
    public void checkHomePageImage() {
        webActionHelperMethods.VerifyObjectExists(imageHome);
       
    }
}
