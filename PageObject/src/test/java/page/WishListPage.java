package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage extends AbstractPage implements IWaitable {
    private final String BASE_URL = "https://www.underarmour.com/en-us/saved-items";


    private By pantsCardInWishListLocator = By.xpath("//a[@class='b-tile-name']");

    public WishListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(BASE_URL);
        return null;
    }

    public String getTextFromCard() {
        return waitForElementLocatedBy(driver,pantsCardInWishListLocator)
                .getText();
    }
}
