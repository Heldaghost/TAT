package page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;


public class CartPage extends AbstractPage implements IWaitable {

    private final String BASE_URL = "https://www.underarmour.com/en-us/cart";

    @FindBy(xpath = "//div[@data-name=\"Boys' UA Showdown Pants\"]//option[@selected]")
    private WebElement quantityOfProductInCart;

    private final By closeBannerButtonLocator = By.xpath("//div[@class='g-email-pop-modal-close g-modal-close-button']");
    private final By addToBagButtonLocator = By.xpath("//button[@data-addto-bag]");

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public CartPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public CartPage closeBanner() {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(closeBannerButtonLocator))
                .click();
        return this;
    }

    public String getQuantityOfProduct() {
        return quantityOfProductInCart.getText();
    }


    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30,SECONDS)
            .pollingEvery(5, SECONDS)
            .ignoring(NoSuchElementException.class);
}
