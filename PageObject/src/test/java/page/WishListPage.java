package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/en-us/p/bottoms/mens-project-rock-unstoppable-pants/194512005476.html'][@class='b-tile-name']")
    private WebElement pantsCardInWishList;

    public WishListPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTextFromCard()
    {
        return pantsCardInWishList.getText();
    }
}
