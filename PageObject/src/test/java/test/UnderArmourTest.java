package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import page.*;

import java.util.List;

public class UnderArmourTest {
    public static WebDriver driver;
    public static PantsPage pantsPage;
    public static WishListPage wishListPage;
    public static CartPage cartPage;

    @BeforeTest
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver","D:\\epam\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addManyProductsToCart() {
        pantsPage = new PantsPage(driver);
        pantsPage.openPage()
                .closeModal()
                .closeBanner()
                .selectSize()
                .openQuantityList()
                .selectQuantity();
        cartPage = pantsPage.addToBag()
                .goToCartPage();
        Assert.assertEquals(cartPage.getQuantityOfProduct(),"10");

    }

    @Test
    public void addToWishList() {
        pantsPage = new PantsPage(driver);
        wishListPage = pantsPage.openPage()
                .closeModal()
                .addToWishList()
                .openWishListPage();
        Assert.assertEquals(wishListPage.getTextFromCard(),"Boys' UA Showdown Pants");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
