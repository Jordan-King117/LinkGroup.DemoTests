package Helpers;

import org.openqa.selenium.By;
import org.testng.Assert;

public class TestAssertions {

    public void verifyPathExists(String pathValue, String failedMessage) {
        FetchElements elementToFetch = new FetchElements();
        Assert.assertTrue(elementToFetch.getListWebElements("XPATH", pathValue).size()>0, failedMessage);
    }

    public void verifyText(String xPath, String textValue){
        String actualString = Browser.driver.findElement(By.xpath(xPath)).getText();
        Assert.assertEquals(actualString,textValue);
    }
}
