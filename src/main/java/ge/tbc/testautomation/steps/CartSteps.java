package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import ge.tbc.testautomation.pages.CartPage;

public class CartSteps extends CommonSteps {
    CartPage cartPage = new CartPage();
    public CartSteps assertCartItemsSize(int expectedSize){
        cartPage.cartItems.shouldHave(CollectionCondition.size(expectedSize));

        return this;
    }

    public CartSteps goToCheckout(){
        cartPage.checkoutButton.click();

        return this;
    }
}
