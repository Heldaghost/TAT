import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



    public class testUnderArmour {
        private WebDriver driver;
        public static String expectedResult = "Men's Project Rock Unstoppable Pants";

        @BeforeMethod(alwaysRun = true)
        public void driverSetup(){
            driver = new ChromeDriver();
        }

        @Test
        public void addToWishListTest(){
            driver.get("https://www.underarmour.com/en-us/p/bottoms/mens-project-rock-unstoppable-pants/1357202.html");

            WebElement addToWishListButton = waitForElementLocatedBy(driver,By.xpath("//button[@class='b-product_name-fav_defultButton add-to-wish-list product']"));
            addToWishListButton.click();
            WebElement goToWishListButton = driver.findElement(By.xpath("//div[@class='b-header-wishlist b-wishlist']"));
            goToWishListButton.click();
            Assert.assertEquals(waitForElementLocatedBy(driver,By.xpath("//a[@href='/en-us/p/bottoms/mens-project-rock-unstoppable-pants/194512003878.html'][@class='b-tile-name']")).getText(), expectedResult);
        }

        @AfterMethod(alwaysRun = true)
        public void driverShutDown(){
            driver.quit();
            driver=null;
        }

        private static WebElement waitForElementLocatedBy(WebDriver driver, By by){
            return new WebDriverWait(driver,3)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
    }


