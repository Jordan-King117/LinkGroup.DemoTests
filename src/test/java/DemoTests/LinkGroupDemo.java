package DemoTests;

import Helpers.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkGroupDemo {

    @BeforeTest
    public void openBrowser(){
        Browser.open(Constants.URL);
    }

    @Test(description = "After browser launches ensure the home page has loaded")
    public void assertHomePageLoaded(){
        //assert we have landed on the homepage by checking for the "home" title
        TestAssertions homePageAssertion = new TestAssertions();
        homePageAssertion.verifyPathExists(PageElements.HOME_PAGE_TITLE, "Home page did not open");
    }

    @Test(dependsOnMethods = {"assertHomePageLoaded"}, description = "click the agree button on the cookie policy and search for 'Leeds'")
    public void agreeToCookiesAndSearch(){
        Functions userClickOnButton = new Functions();
        userClickOnButton.clickOnButton(PageElements.ACCEPT_BUTTON);

        //hover on search bar
        Functions hoverOnSearch = new Functions();
        hoverOnSearch.hoverMouse(PageElements.SEARCH_MENU);

        //Enter text in search field and click search
        Functions useSearchField = new Functions();
        useSearchField.enterText(PageElements.SEARCH_FIELD, Var.CITY_TO_SEARCH);
        userClickOnButton.clickOnElement("XPATH", PageElements.SEARCH_BUTTON);

        //assert the correct response is given after the search
        TestAssertions expectedTextReturn = new TestAssertions();
        expectedTextReturn.verifyText( PageElements.SEARCH_RESULTS_CONTAINER,Var.SEARCH_RESULT_TEXT + "\n\"" + Var.CITY_TO_SEARCH + "\"");
    }

    @AfterTest
    public void closeBrowser(){
        Browser.driver.quit();
    }
}
