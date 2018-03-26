package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.SortingType;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends TestRunner {

    @Test
    public void searchMultipleResult() throws InterruptedException {
        SearchPage searchPage = Application.get()
                .loadSearchPage()
                .makeExtendedSearch("i", Categories.LAPTOPS);
//        Thread.sleep(2000);
        int actual = searchPage.countProductsFound();
        Assert.assertEquals(actual, 11);

    }

    @Test
    public void searchSingleResult() {
        SearchPage searchPage = Application.get()
                .loadSearchPage()
                .makeExtendedSearch("Sony VAIO", Categories.ALL);
        int actualCount = searchPage.countProductsFound();
        Assert.assertEquals(actualCount, 1);
        String actualName = searchPage.getExtendedSearchBlock().getProductComponentTexts().get(0);
        Assert.assertEquals(actualName, "Sony VAIO");
    }

    @Test
        public void testSearchByEmptyField() {
            SearchPage searchPage = Application.get()
                    .loadSearchPage()
                    .makeExtendedSearch("", Categories.ALL);
            int actualCount = searchPage.countProductsFound();
            Assert.assertEquals(actualCount, 0);

    }

    @Test
    public void testSortingByPriceAsc() throws InterruptedException {
        SearchPage searchPage = Application.get()
                .loadSearchPage()
                .makeExtendedSearch("apple", Categories.ALL);
        searchPage.sortProducts(SortingType.PRICE_ASC);

        Assert.assertTrue(searchPage.isPricesSortedByAsc());
    }

    @Test
    public void testSortingByPriceDesc() throws InterruptedException {
        SearchPage searchPage = Application.get()
                .loadSearchPage()
                .makeExtendedSearch("apple", Categories.ALL);
        searchPage.sortProducts(SortingType.PRICE_DESC);

        Assert.assertTrue(searchPage.isPricesSortedByDesc());
    }

    @Test
    public void testSwitchingToListView() {
        SearchPage searchPage = Application.get()
                .loadSearchPage()
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.displayProductsAsList();
        Assert.assertTrue(searchPage.isProductsDisplayedByList());
    }

    @Test
    public void testSwitchingToGridView() {
        SearchPage searchPage = Application.get()
                .loadSearchPage()
                .makeExtendedSearch("mac", Categories.ALL);
        searchPage.displayProductsAsGrid();
        Assert.assertTrue(searchPage.isProductsDisplayedByGrid());
    }

}
