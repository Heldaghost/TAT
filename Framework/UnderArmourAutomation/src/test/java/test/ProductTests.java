package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.AssertAccumulator;
import page.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductTests extends CommonConditions {

    @Test
    public void addProductToCart() {
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .closeAdds()
                .selectSize(8)
                .addToBag()
                .goToCartPage();
        String expectedProduct = cartPage.getNameOfProductInCart();
        Assert.assertEquals(expectedProduct,"Boys' UA Showdown Pants");
    }

   @Test
    public void addManyProductsToCart() {
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .closeAdds()
                .selectSize(8)
                .openQuantityList()
                .selectQuantity()
                .addToBag()
                .goToCartPage();
        String expectedQuantity = cartPage.getQuantityOfProduct();
        Assert.assertEquals(expectedQuantity,"10");
    }

    @Test
    public void addToWishList() {
        WishlistPage wishListPage = new ProductPage(driver)
                .openPage()
                .closeAdds()
                .addToWishList()
                .openWishListPage();
        String expectedName  = wishListPage.getTextFromCard();
        Assert.assertEquals(expectedName,"Boys' UA Showdown Pants");
    }

    @Test
    public void emptyCart(){
        String expectedMessage = new CartPage(driver)
                .openPage()
                .getEmptyCartMessage();
        assertThat(expectedMessage, is(equalTo("You have no items in your bag.")));
    }

    @Test
    public void changeColorOfProductInCart() {
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .closeAdds()
                .selectSize(8)
                .addToBag()
                .goToCartPage();
        String expectedColor = cartPage
                .closeBanner()
                .changeColorOfProductInCart()
                .getColorOfProductInCart();
        assertThat(expectedColor, is(equalTo("Color: Gray")));

    }


    @Test
    public void freeShippingTest()
    {
        AssertAccumulator assertAccumulator = new AssertAccumulator();
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .changeCountry()
                .selectSize(8)
                .addToBag()
                .goToCartPage();
        String expectedPrice = cartPage.getShippingCost();
        int expectedSubtotalCost = cartPage.getSubtotalCost();
        assertAccumulator.accumulate(()->assertThat(expectedPrice, is(equalTo("Free"))));
        assertAccumulator.accumulate(()->assertThat(expectedSubtotalCost,is(greaterThanOrEqualTo(60))));
        assertAccumulator.release();
    }



    @Test
    public void colorFilterTest() throws InterruptedException {
        String expectedColorOfProduct = new ProductListPage(driver).openPage()
                .closeModal()
                .filterByPinkColor()
                .getColorOfFilteredProduct();
        assertThat(expectedColorOfProduct,is(equalTo("Men's Project Rock Charged Cotton® Fleece Shorts, Pink")));
    }

    @Test
    public void enterWrongPromoTest(){
        CartPage cartPage = new ProductPage(driver)
                .openPage()
                .changeCountry()
                .selectSize(8)
                .addToBag()
                .goToCartPage();
        String expectedErrorPromoCodeMessage = cartPage.enterPromoCode()
                .getPromoCodeErrorMessage();
        assertThat(expectedErrorPromoCodeMessage,is(equalTo("Promo code cannot be added to your bag")));
    }

}
