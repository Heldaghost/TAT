package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends AbstractPage implements IWaitable{
    private final String BASE_URL = "https://www.underarmour.com/en-us/my-account";

    private By userEmailAriaLocator = By.xpath("//*[@id='email']");
    private By userProfileOptionsLocator = By.xpath("//div[@class='b-account-profile']/a");


    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public ProfilePage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getUserEmail(){
        waitForElementLocatedBy(driver,userProfileOptionsLocator)
                .click();
       return waitForElementLocatedBy(driver,userEmailAriaLocator)
               .getAttribute("value");
    }
}
