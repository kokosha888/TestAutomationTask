package com.kokosha;


import com.kokosha.pages.AutomationPracticePage;
import com.kokosha.pages.CustomerServiceFormPage;
import com.kokosha.pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AutomationPracticeTest {
    private WebDriver driver;
    private final String LINK = "http://automationpractice.com/index.php";
    AutomationPracticePage page;
    RegistrationPage register;
    CustomerServiceFormPage customerservice;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        page = new AutomationPracticePage(driver);
        register = new RegistrationPage(driver);
        driver.get(LINK);
        customerservice = new CustomerServiceFormPage(driver);
    }


    @Test(priority = 0)
    public void hoverWomenClickTshirt() {
        page.clickWomenTshirt();
        String expectedUrl = "http://automationpractice.com/index.php?id_category=5&controller=category";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 1)
    public void hoverCardClickMore() {
        page.clickCardMore();
        String url = "http://automationpractice.com/index.php?id_product=1&controller=product";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, url);
    }

    @Test(priority = 2)
    public void checkProductHoverBigImageOne() {
        page.hoverProductImageSmallOne();                                           //hover over first product image
        WebElement BigPictureelement = page.getProductImageBig();                   //get big picture element and assign it to bigpictureelement of type webelement
        String bigImage1 = BigPictureelement.getAttribute("src");                //get src of bigpictureelement and store it in bigImage1
        String ulrOne = "http://automationpractice.com/img/p/1/1-large_default.jpg";//supposed picture url
        Assert.assertEquals(bigImage1, ulrOne);                                     //check whether actual url is equal to supposed url
    }

    @Test(priority = 3)
    public void checkProductHoverBigImageTwo() {
        page.hoverProductImageSmallTwo();
        WebElement BigPictureelement = page.getProductImageBig();
        String bigImage2 = BigPictureelement.getAttribute("src");
        String ulrTwo = "http://automationpractice.com/img/p/2/2-large_default.jpg";
        Assert.assertEquals(bigImage2, ulrTwo);
    }

    @Test(priority = 4)
    public void checkProductHoverBigImageThree() {
        page.hoverProductImageSmallThree();
        WebElement BigPictureelement = page.getProductImageBig();
        String bigImage3 = BigPictureelement.getAttribute("src");
        String ulrThree = "http://automationpractice.com/img/p/3/3-large_default.jpg";
        Assert.assertEquals(bigImage3, ulrThree);
    }

    @Test(priority = 5)
    public void checkProductHoverBigImageFour() {
        page.hoverProductImageSmallFour();
        WebElement BigPictureelement = page.getProductImageBig();
        String bigImage4 = BigPictureelement.getAttribute("src");
        String ulrFour = "http://automationpractice.com/img/p/4/4-large_default.jpg";
        Assert.assertEquals(bigImage4, ulrFour);

    }

    @Test(priority = 6)
    public void fillDetailsAndAddToCart() {
        page.fillQuantityAndSize();
        page.addToCart();
        WebElement SizeElement = page.getPopupSizeElement();
        String Size = SizeElement.getAttribute("innerHTML");
        char SizeLetter = 'M';
        Assert.assertEquals(Size.charAt(Size.length() - 1), SizeLetter);

        WebElement QuantityElement = page.getPopupQuantityElement();
        String Quantity = QuantityElement.getAttribute("innerHTML");
        String ExpectedQuantity = "2";
        Assert.assertEquals(Quantity, ExpectedQuantity);
        page.continueShopping();
    }

    @Test(priority = 7)
    public void gotoMainPageAndClickCasualDresses() {
        driver.get(LINK);
        page.clickCasualDresses();
        String expectedUrl = "http://automationpractice.com/index.php?id_category=9&controller=category";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test(priority = 8)
    public void hoverCardClickAddtoCart() {
        page.clickCardAddtoCart();
        WebElement productName = page.getPopupProductName();
        String DressName = productName.getAttribute("innerHTML");
        String expectedName = "Printed Dress";
        Assert.assertEquals(expectedName, DressName);
        page.continueShopping();
    }

    @Test(priority = 9)
    public void moveToCheckout() {
        page.movetoCartAndCheckout();
        String expectedUrl = "http://automationpractice.com/index.php?controller=order";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 10)
    public void checkCartItemNames() {
        WebElement cartItemOneName = page.getCartItemOneNameElement();
        WebElement cartItemTwoName = page.getCartItemTwoNameElement();
        String itemOneName = cartItemOneName.getAttribute("innerHTML");
        String itemTwoName = cartItemTwoName.getAttribute("innerHTML");
        String expectedItemOneName = "Faded Short Sleeve T-shirts";
        String expectedItemTwoName = "Printed Dress";
        Assert.assertEquals(itemOneName, expectedItemOneName);
        Assert.assertEquals(itemTwoName, expectedItemTwoName);
        page.proceedToCheckout();
    }

    public String getRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 15) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }

    @Test(priority = 11)
    public void signUpWithRandomEmail() {
        String randEmail = getRandomEmail();
        register.signUpWithNewAccount(randEmail);

    }

    @Test(priority = 12)
    public void fillPersonalInfoAndAdress() {
        register.fillRegistrationDetails(
                "asdfg",
                "asdfg",
                "asdfg",
                "asdfg",
                "asdfg",
                "00000",
                "000"
        );
    }

    @Test(priority = 13)
    public void proceedToCheckoutOnStepThree() {
        register.proceedToCheckout();

    }

    @Test(priority = 14)
    public void proceedToCheckoutOnStepFour() {
        register.proceedToCheckoutOnStageFour();

    }

    @Test(priority = 15)
    public void proceedToCheckoutOnStepFourAgreementAccepted() {
        register.termsAndConditions();
        register.proceedToCheckoutOnStageFour();

    }

    @Test(priority = 16)
    public void payByCheckAndCheckTotalAndConfirm() {
        register.clickPayByCheck();
        String actualPrice = register.totalPriceElement().getAttribute("innerHTML");
        String expectedPrice = "$63.46";
        Assert.assertEquals(actualPrice, expectedPrice);
        register.confirmOrder();
    }

    @Test(priority = 17)
    public void GotoCustomerServiceLink() {
        register.clickCustomerServiceLink();
    }

    @Test(priority = 18)
    public void fillCustomerServicePageDetails() {
        customerservice.fillCustomerServiceDetails("please hire me", System.getProperty("user.dir") + "\\emptyText.txt");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}




