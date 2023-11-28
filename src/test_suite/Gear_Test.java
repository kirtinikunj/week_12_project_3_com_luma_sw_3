package test_suite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Write down the following test into ‘GearTest’ class
 * 1. userShouldAddProductSuccessFullyToShoppinCart()
 * * Mouse Hover on Gear Menu Click on Bags
 * * Click on Product Name ‘Overnight Duffle’
 * * Verify the text ‘Overnight Duffle’
 * * Change Qty 3
 * * Click on ‘Add to Cart’ Button.
 * * Verify the text ‘You added Overnight Duffle to your shopping cart.’
 * * Click on ‘shopping cart’ Link into message
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the Qty is ‘3’
 * * Verify the product price ‘$135.00’
 * * Change Qty to ‘5’
 * * Click on ‘Update Shopping Cart’ button
 * * Verify the product price ‘$225.00’
 */
public class Gear_Test extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {

        //* * Mouse Hover on Gear Menu Click on Bags
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));

        //* * Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        // * * Verify the text ‘Overnight Duffle’
        String expText="Overnight Duffle";
        String actText=getTextFromElement(By.xpath("//span[text()='Overnight Duffle']"));
        Assert.assertEquals(expText,actText);

        // * * Change Qty 3
        sendTextToElement(By.id("qty"),"3");

        // * * Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[text()='Add to Cart']"));

        //* * Verify the text ‘You added Overnight Duffle to your shopping cart.’
//        String expText1="You added Overnight Duffle to your shopping cart.";
//        String actText1=getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
//        Assert.assertEquals(expText1,actText1);

        // * * Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //  * * Verify the product name ‘Overnight Duffle’
        String expName="Overnight Duffle";
        String actName=getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        Assert.assertEquals(expName,actName);

        //* * Verify the Qty is ‘3’
        String expQty="3";
        String actQty=getTextFromElement(By.xpath("//input[@id='cart-488734-qty']"));
        Assert.assertEquals(expQty,actQty);

        //* * Verify the product price ‘$135.00’
        String expPrice="$135.00";
        String actPrice=getTextFromElement(By.xpath("//span[contains(text(),'$135.00')]"));
        Assert.assertEquals(expPrice,actPrice);

        // * * Change Qty to ‘5’
        sendTextToElement(By.xpath("//input[@id='cart-488734-qty']"),"5");

        // * * Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

        // * * Verify the product price ‘$225.00’
        String expPrice1="$225.00";
        String actPrice1=getTextFromElement(By.xpath("//span[normalize-space()='$324.00']"));
        Assert.assertEquals(expPrice1,actPrice1);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
