package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PantsPage {
    private static final String PANTS_PAGE_URL = "https://www.underarmour.com/en-us/p/bottoms/boys-ua-showdown-pants/193444360950.html";
    private WebDriver driver;

    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeBannerButton;

    @FindBy(xpath = "//span[@class='b-header_minicart-icon']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//div[@class='b-product_attrs']//button[@data-addto-bag]")
    private WebElement addToBagButton;

    @FindBy(xpath = "//a[@data-size-attr=8]")
    private WebElement selectSizeButton;

    @FindBy(xpath = "//select[@id='quantity-1']")
    private WebElement quantityList;

    @FindBy(xpath = "//select[@id='quantity-1']/option[@value=10]")
    private WebElement selectQuantityButton;

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

    public PantsPage selectSize(){
        selectSizeButton.click();
        return this;
    }

    public PantsPage openQuantityList(){
        quantityList.click();
        return this;
    }

    public PantsPage selectQuantity() {
        selectQuantityButton.click();
        return this;
    }

    public PantsPage addToBag(){
        addToBagButton.click();
        return this;
    }

    public CartPage goToCartPage(){
        goToCartButton.click();
        return new CartPage(driver);
    }

    public PantsPage closeBanner(){
        closeBannerButton.click();
        return this;
    }
}
