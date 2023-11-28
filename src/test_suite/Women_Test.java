package test_suite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in alphabetical order
 * <p>
 * 2. verifyTheSortByPriceFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Price”
 * * Verify the products price display in Low to High
 */
public class Women_Test extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {

        //* * Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));

        // * * Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));

        //* * Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //* * Select Sort By filter “Product Name”
        selectByValueFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "name");

        //* * Verify the products name display in alphabetical order
    }

    @Test
    public void verifyTheSortByPriceFilter() {

        //* * Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));

        //* * Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));

        // * * Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //* * Select Sort By filter “Price”
        selectByValueFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "price");

        //* * Verify the products price display in Low to High
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
