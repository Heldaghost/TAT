package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.*;

public class UnderArmourTest extends CommonConditions {

    @Test
    public void addManyProductsToCart() {
        String expectedQuantity = new ProductPage(driver)
                .openPage()
                .closeAdds()
                .selectSize(8)
                .selectQuantity()
                .addToBag()
                .goToCartPage()
                .getQuantityOfProduct();
        Assert.assertEquals(expectedQuantity,"10");
    }

    @Test
    public void addToWishList() {
        String expectedName = new ProductPage(driver)
                .openPage()
                .closeAdds()
                .addToWishList()
                .openWishListPage()
                .getTextFromCard();
        Assert.assertEquals(expectedName,"Boys' UA Showdown Pants");
    }
}
