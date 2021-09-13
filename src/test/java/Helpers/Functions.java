package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Helpers.Browser.driver;

public class Functions {

    public void clickOnButton(String id){
        FetchElements clickButton = new FetchElements();
        clickButton.getWebElement("ID", id).click();
    }

    public void clickOnElement(String identifier, String pathValue){
        FetchElements clickPath = new FetchElements();
        clickPath.getWebElement(identifier, pathValue).click();
    }

    public void enterText(String fieldName, String value){
        driver.findElement(By.name(fieldName)).sendKeys(value);
    }

    public void hoverMouse(String hoverPath){
        //hover on the menu
        WebElement searchMenu = driver.findElement(By.xpath(hoverPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchMenu).perform();
    }

}
