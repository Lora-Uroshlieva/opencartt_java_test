package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.RegexUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductComponent {

    private WebElement productLayout;
    //
    // private WebElement name;
    // private WebElement price;
    // private WebElement addToCart;
    // private WebElement addToWish;

    public ProductComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        //
        // Verify Web Elements
        verifyWebElements();
    }

    private void verifyWebElements() {
        // TODO Check, if Web Elements Exist
        getName();
        getPrice();
        getAddToCart();
        getAddToWish();
    }

    // name
    public WebElement getName() {
        // return name;
        return productLayout.findElement(By.cssSelector("h4 a"));
    }

    public String getNameText() {
        return getName().getText();
    }

    public void clickName() {
        getName().click();
    }

    // price
    public WebElement getPrice() {
        // return price;
        WebDriverWait wait = new WebDriverWait(Application.get().getBrowser().getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOf(productLayout.findElement(By.cssSelector(".caption .price"))));
    }

    public String getPriceText() {
        return getPrice().getText();
    }

    public double getPriceAmount() {
        return RegexUtils.extractFirstDouble(getPriceText());
    }

    // addToCart
    public WebElement getAddToCart() {
        return productLayout.findElement(By.cssSelector(".fa.fa-shopping-cart"));
    }

    public void clickAddToCart() {
        getAddToCart().click();
    }

    // addToWish
    public WebElement getAddToWish() {
        // return currency;
        return productLayout.findElement(By.cssSelector(".fa.fa-heart"));
    }

    public void clickAddToWish() {
        getAddToWish().click();
    }

    public String getElementClasses() {
        return productLayout.getAttribute("class");
    }

}
