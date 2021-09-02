package com.kokosha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CustomerServiceFormPage {

    WebDriver driver;

    public CustomerServiceFormPage (WebDriver driver){
        this.driver = driver;
    }

    public void fillCustomerServiceDetails (String formText, String uploadInfo) {
        //subject heading
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#id_contact"))).click().build().perform();
        driver.findElement(By.cssSelector("#id_contact > option:nth-child(2)")).click();
        //order reference
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#center_column > form > fieldset > div.clearfix > div.col-xs-12.col-md-3 > div:nth-child(6) > div > select"))).click().build().perform();
        driver.findElement(By.cssSelector("#center_column > form > fieldset > div.clearfix > div.col-xs-12.col-md-3 > div:nth-child(6) > div > select > option:nth-child(2)")).click();

        driver.findElement(By.cssSelector("#message")).sendKeys(formText);

        driver.findElement(By.cssSelector("#fileUpload")).sendKeys(uploadInfo);

        driver.findElement(By.cssSelector("#submitMessage > span")).click();

    }

}
