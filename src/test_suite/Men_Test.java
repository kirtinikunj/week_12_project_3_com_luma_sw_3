package test_suite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Write down the following test into ‘MenTest’
 * class
 * 1. userShouldAddProductSuccessFullyToShoppinCart()
 * * Mouse Hover on Men Menu
 * * Mouse Hover on Bottoms
 * * Click on Pants
 * * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
 * * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
 * * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
 * * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
 * * Click on ‘shopping cart’ Link into message
 * * Verify the text ‘Shopping Cart.’
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the product size ‘32’
 * * Verify the product colour ‘Black’
 */
public class Men_Test extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {

        //* * Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Men']"));

        //* * Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));

        //* * Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //* * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

        //* * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        //* * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));

        //* * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expText="You added Cronus Yoga Pant to your shopping cart.";
        String actText=getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expText,actText);

        //* * Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[text()='shopping cart']"));

        //* * Verify the text ‘Shopping Cart.’
        String expText1="Shopping Cart";
        String actText1=getTextFromElement(By.xpath("//span[text()='Shopping Cart']"));
        Assert.assertEquals(expText1,actText1);

        //* * Verify the product name ‘Cronus Yoga Pant’
        String expName="Cronus Yoga Pant";
        String actName=getTextFromElement(By.xpath("(//a[normalize-space()='Cronus Yoga Pant'])[2]"));
        Assert.assertEquals(expName,actName);

        //* * Verify the product size ‘32’
        String expSize="32";
        String actSize=getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals(expSize,actSize);

        //* * Verify the product colour ‘Black’
        String expColour="Black";
        String actColour=getTextFromElement(By.xpath("(//dd[contains(text(),'Black')])[1]"));
        Assert.assertEquals(expColour,actColour);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

