package com.kokosha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }
    public void signUpWithNewAccount (String email) {
        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();

    }

    public void fillRegistrationDetails (String Name, String Surname, String password, String address, String city, String postal, String phonenumber) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_firstname"))).sendKeys(Name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer_lastname"))).sendKeys(Surname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwd"))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#address1"))).sendKeys(address);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#city"))).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#postcode"))).sendKeys(postal);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#phone_mobile"))).sendKeys(phonenumber);

//        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(Surname);
//        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
//        driver.findElement(By.cssSelector("#address1")).sendKeys(address);
//        driver.findElement(By.cssSelector("#city")).sendKeys(city);
//        driver.findElement(By.cssSelector("#postcode")).sendKeys(postal);
//        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys(phonenumber);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#id_state"))).click().build().perform();
        driver.findElement(By.cssSelector("#id_state > option:nth-child(2)")).click();

        driver.findElement(By.cssSelector("#submitAccount > span")).click();
    }

    public void proceedToCheckout () {
        driver.findElement(By.cssSelector("#center_column > form > p > button > span")).click();
    }
    public void proceedToCheckoutOnStageFour () {
        driver.findElement(By.cssSelector("#form > p > button > span")).click();
    }

    public void termsAndConditions () {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#order > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a"))).click();
        driver.findElement(By.cssSelector("#cgv")).click();
    }

    public void clickPayByCheck () {
        driver.findElement(By.cssSelector("#HOOK_PAYMENT > div:nth-child(2) > div > p > a")).click();
    }
    public WebElement totalPriceElement () {
        return driver.findElement(By.cssSelector("#amount"));
    }
    public void confirmOrder () {
        driver.findElement(By.cssSelector("#cart_navigation > button > span")).click();
    }

    public void clickCustomerServiceLink () {
        driver.findElement(By.cssSelector("#center_column > div > a")).click();
    }



}
