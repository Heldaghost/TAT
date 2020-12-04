package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PantsPage {
    private static final String PANTS_PAGE_URL = "https://www.underarmour.com/en-us/p/bottoms/mens-project-rock-unstoppable-pants/1357202.html";
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='BY']")
    private WebElement closeModalButton;

    @FindBy(xpath = "//button[@class='b-product_name-fav_defultButton add-to-wish-list product']")
    private WebElement addToWishListButton;

    @FindBy(xpath = "//div[@class='b-header-wishlist b-wishlist']")
    private WebElement goToWishListButton;

    public PantsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PantsPage openPage() {
        driver.get(PANTS_PAGE_URL);
        return this;
    }

    public PantsPage closeModal() {
        closeModalButton.click();
        return this;
    }
    public PantsPage addToWishList() {
        addToWishListButton.click();
        return this;
    }

    public WishListPage openWishListPage() {
        goToWishListButton.click();
        return new WishListPage(driver);
    }
}
