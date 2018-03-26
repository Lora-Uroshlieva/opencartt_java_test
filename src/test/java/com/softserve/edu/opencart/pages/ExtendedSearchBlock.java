package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.Categories;
import com.softserve.edu.opencart.data.ProductsLimitOnPage;
import com.softserve.edu.opencart.data.SortingType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ExtendedSearchBlock extends FeaturedBlock {
    public ExtendedSearchBlock(WebDriver driver) {
        super(driver);
            }

    public WebElement getSearchField() {
        return driver.findElement(By.id("input-search"));
    }

    public void clearSearchField() {
       getSearchField().clear();
    }

    public void inputToSearchField(String text) {
        getSearchField().sendKeys(text);
    }

    public void selectCategory(Categories category) {
        Select dropdown = new Select(driver.findElement(
                By.cssSelector("#content select.form-control[name='category_id']")));
        dropdown.selectByVisibleText(category.toString()); //category is visible text in html code
    }

    public void clickSelectInDescriptionsCheckbox() {
        driver.findElement(By.id("description")).click();
    }

    public void clickSearchButton() {
        driver.findElement(By.id("button-search")).click();
    }

    public void clickListViewButton() {
        driver.findElement(By.id("list-view")).click();
    }

    public void clickGridViewButton() {
        driver.findElement(By.id("grid-view")).click();
    }

    public void selectSortingType(SortingType sortingType) {
        Select dropdown = new Select(driver.findElement(By.id("input-sort")));
        dropdown.selectByVisibleText(sortingType.toString());
    }

    public void selectQuantityOnPage(ProductsLimitOnPage quantity) {
        Select dropdown = new Select(driver.findElement(By.id("input-limit")));
        dropdown.selectByVisibleText(quantity.toString());
    }



}
