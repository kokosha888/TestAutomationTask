package com.kokosha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticePage {

    WebDriver driver;



    public AutomationPracticePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickWomenTshirt () {
        Actions action = new Actions(driver);
        WebElement woman = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"));
        action.moveToElement(woman).moveToElement(driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(1) > a"))).click().build().perform();

    }

    public void clickCardMore () {
        Actions action = new Actions(driver);
        WebElement card = driver.findElement(By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img"));
        action.moveToElement(card).moveToElement(driver.findElement(By.cssSelector("#center_column > ul > li > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default"))).click().build().perform();

    }

    public WebElement getProductImageBig () {
        return driver.findElement(By.cssSelector("#bigpic"));
    }

    public void hoverProductImageSmallOne () {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#thumb_1"))).build().perform();
    }
    public void hoverProductImageSmallTwo () {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#thumb_2"))).build().perform();
    }
    public void hoverProductImageSmallThree () {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#thumb_3"))).build().perform();
    }
    public void hoverProductImageSmallFour () {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#thumb_4"))).build().perform();
    }

    public void fillQuantityAndSize () {
        driver.findElement(By.cssSelector("#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up")).click();
        driver.findElement(By.cssSelector("#group_1")).click();
        driver.findElement(By.cssSelector("#group_1 > option:nth-child(2)")).click();

    }

    public void addToCart () {

        driver.findElement(By.cssSelector("#add_to_cart > button")).click();
    }

    public WebElement getPopupSizeElement() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layer_cart_product_attributes")));
    }

    public WebElement getPopupQuantityElement () {
        return driver.findElement(By.cssSelector("#layer_cart_product_quantity"));
    }

    public void continueShopping () {
      driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")).click();
    }

    public void clickCasualDresses () {
        Actions action = new Actions(driver);
        WebElement Dresses = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"));
        action.moveToElement(Dresses).moveToElement(driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(1) > a"))).click().build().perform();

    }

    public void clickCardAddtoCart () {
        Actions action = new Actions(driver);
        WebElement card = driver.findElement(By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img"));
        action.moveToElement(card).moveToElement(driver.findElement(By.cssSelector("#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default"))).click().build().perform();

    }

    public WebElement getPopupProductName () {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layer_cart_product_title")));
    }

    public void movetoCartAndCheckout () {
        Actions action = new Actions(driver);
        WebElement cart = driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a"));
        WebDriverWait wait = new WebDriverWait(driver, 100);
        action.moveToElement(cart).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#button_order_cart"))).click();
    }

    public WebElement getCartItemOneNameElement () {
        return driver.findElement(By.cssSelector("#product_1_3_0_0 > td.cart_description > p > a"));
    }

    public WebElement getCartItemTwoNameElement () {
        return driver.findElement(By.cssSelector("#product_3_13_0_0 > td.cart_description > p > a"));
    }

    public void proceedToCheckout () {
        driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")).click();
    }

}
