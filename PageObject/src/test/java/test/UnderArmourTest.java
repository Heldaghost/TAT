package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import page.*;
import property.*;

import java.util.List;

public class UnderArmourTest {
    public static WebDriver driver;
    public static PantsPage pantsPage;
    public static WishListPage wishListPage;
    public static CartPage cartPage;

    @BeforeTest
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", ConfigurationProperties.getProperty("chromedriver"));

        ChromeOptions options = new ChromeOptions();


        driver = new ChromeDriver(options);
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
        Assert.assertEquals(expectedResult,"Boys' UA Showdown Pants");
    }

    @Test
    public void addManyProductsToCart(){
        pantsPage = new PantsPage(driver);
        cartPage = pantsPage.openPage()
                .closeModal()
                .selectSize()
                .closeBanner()
                .openQuantityList()
                .selectQuantity()
                .addToBag()
                .goToCartPage();
        Assert.assertEquals(cartPage.getQuantityOfProduct(),"10");

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
