package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='b-tile-name']")
    private WebElement pantsCardInWishList;

    public WishListPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTextFromCard() {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(pantsCardInWishList));
        return pantsCardInWishList.getText();
    }
}
