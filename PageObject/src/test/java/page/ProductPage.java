package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage extends AbstractPage implements IWaitable {
    private static final String PANTS_PAGE_URL = "https://www.underarmour.com/en-us/p/bottoms/boys-ua-showdown-pants/193444360950.html";

    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeBannerButton;

    @FindBy(xpath = "//span[@class='b-header_minicart-icon']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//div[@class='b-product_attrs']//button[@data-addto-bag]")
    private WebElement addToBagButton;

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

    public ProductPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public ProductPage openPage() {
        driver.get(PANTS_PAGE_URL);
        return this;
    }

    public ProductPage closeAdds() {
        closeModalButton.click();
        closeBannerButton.click();
        return this;
    }
    public ProductPage addToWishList() {
        addToWishListButton.click();
        return this;
    }

    public WishListPage openWishListPage() {
        waitForElementLocatedBy(driver, By.xpath("//div[@class='js-whislist-icon product-added b-product_name-fav_selectButton']"));
        goToWishListButton.click();
        return new WishListPage(driver);
    }

    public ProductPage selectSize(int neededSize){
        String buttonSizeLocator = String.format("//a[@data-size-attr=%s]",neededSize);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(buttonSizeLocator)))
                .click();
        return this;
    }

    public ProductPage selectQuantity() {
        waitForElementLocatedBy(driver,By.xpath("//a[@class='js-size-select selectable m-active selected']"));
        quantityList.click();
        selectQuantityButton.click();
        return this;
    }

    public ProductPage addToBag(){
        waitForElementLocatedBy(driver,By.xpath("//a[@class='js-size-select selectable m-active selected']"));
        addToBagButton.click();
        return this;
    }

    public CartPage goToCartPage(){
        waitForElementLocatedBy(driver,By.xpath("//span[@class='b-header_minicart-icon']/span[@style='display: block;']"));
        goToCartButton.click();
        return new CartPage(driver);
    }
}
