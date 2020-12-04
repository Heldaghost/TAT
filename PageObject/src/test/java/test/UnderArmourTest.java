package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.*;

import java.util.List;

public class UnderArmourTest {
    public static WebDriver driver;
    public static PantsPage pantsPage;
    public static WishListPage wishListPage;

    @BeforeTest
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addToWishList() {
        pantsPage = new PantsPage(driver);
        wishListPage = pantsPage.openPage()
                .closeModal()
                .addToWishList()
                .openWishListPage();
        String expectedResult = wishListPage.getTextFromCard();
        Assert.assertEquals(expectedResult,"Men's Project Rock Unstoppable Pants");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
