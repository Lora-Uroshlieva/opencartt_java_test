package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.ProductsLimitOnPage;
import com.softserve.edu.opencart.data.SortingType;
import com.softserve.edu.opencart.data.Currencies;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AAdressBar {

    protected ExtendedSearchBlock extendedSearchBlock;

    public SearchPage(WebDriver driver) {
        super(driver);
        extendedSearchBlock = new ExtendedSearchBlock(driver);
    }

    public static SearchPage load(WebDriver driver) {
        driver.get("http://atqc-shop.epizy.com/index.php?route=product/search");
        return new SearchPage(driver);
    }

        public ExtendedSearchBlock getExtendedSearchBlock() {
        return extendedSearchBlock;
    }

    // Business Logic

    public SearchPage selectCurrency(Currencies currencyName) {
        chooseCurrency(currencyName);
        return new SearchPage(driver);
    }

    public SearchPage addToWishListByProduct(String productName) {
        extendedSearchBlock.clickAddToWishByProductName(productName);
        //return this;
        return new SearchPage(driver);
    }

    public SearchPage makeExtendedSearch(String keyWord, Categories category) {
        extendedSearchBlock.clearSearchField();
        extendedSearchBlock.inputToSearchField(keyWord);
        extendedSearchBlock.selectCategory(category);
        extendedSearchBlock.clickSelectInDescriptionsCheckbox();
        extendedSearchBlock.clickSearchButton();
        return new SearchPage(driver);
    }

    public void displayProductsAsList() {
        extendedSearchBlock.clickListViewButton();
    }

    public void displayProductsAsGrid() {
        extendedSearchBlock.clickGridViewButton();
    }

    public SearchPage sortProducts(SortingType type) {
        extendedSearchBlock.selectSortingType(type);
        return new SearchPage(driver);
    }

    public  SearchPage changeProductsLimitOnpage(ProductsLimitOnPage limit) {
        extendedSearchBlock.selectQuantityOnPage(limit);
        return new SearchPage(driver);
    }

    public int countProductsFound() {
        return extendedSearchBlock.getProductComponents().size();
    }

    public boolean isPricesSortedByAsc() {
        boolean result = true;
        List<ProductComponent> products = extendedSearchBlock.initProductComponents();
        List<Double> prices = new ArrayList<>();
        for (ProductComponent current: products) {
          prices.add(current.getPriceAmount());
        }
        System.out.println("*****************************************");
        System.out.println(prices);
        for (int i = 0; i < prices.size()-1; i++) {
            if (prices.get(i) > prices.get(i+1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isPricesSortedByDesc() {
        boolean result = true;
        List<ProductComponent> products = extendedSearchBlock.initProductComponents();
        List<Double> prices = new ArrayList<>();
        for (ProductComponent current: products) {
            prices.add(current.getPriceAmount());
        }
        System.out.println("*****************************************");
        System.out.println(prices);
        for (int i = 0; i < prices.size()-1; i++) {
            if (prices.get(i) < prices.get(i+1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isProductsDisplayedByList() {
        return extendedSearchBlock.checkClassPresenceInElements("product-list");
    }

    public boolean isProductsDisplayedByGrid() {
        return extendedSearchBlock.checkClassPresenceInElements("product-grid");
    }

}
