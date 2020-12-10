package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@data-name=\"Boys' UA Showdown Pants\"]//option[@selected]")
    private WebElement quantityOfProductInCart;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getQuantityOfProduct(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(quantityOfProductInCart));
        return quantityOfProductInCart.getText();
    }
}
