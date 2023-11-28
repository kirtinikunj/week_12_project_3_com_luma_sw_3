package utilities;

import browser_factory.Base_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends Base_Test {


    /**
     * This method will click on any element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will send text on any element
     */
    public void sendTextToElement(By by,String text){

        driver.findElement(by).sendKeys(text);
        //or
//        WebElement element=driver.findElement(by);
//        element.sendKeys(text);
    }

    /**
     * This method will get text from any element
     */
    public String getTextFromElement(By by){
//        WebElement webElement = driver.findElement(by);
//        String text = webElement.getText();
//        return text;
        return driver.findElement(by).getText();
    }

    public void selectByValueFromDropDown(By by,String value){

        WebElement dropDown=driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByValue(value);
    }

    public void selectByVisibleFromDropDown(By by,String text){

        WebElement dropDown=driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
}
