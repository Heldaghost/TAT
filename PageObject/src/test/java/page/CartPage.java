package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://github.com/login";
    private WebDriver driver;

    @FindBy(xpath = "//div[@data-name=\"Boys' UA Showdown Pants\"]//option[@selected]")
    private WebElement quantityOfProductInCart;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getQuantityOfProduct(){
 
        return quantityOfProductInCart.getText();
    }
}
