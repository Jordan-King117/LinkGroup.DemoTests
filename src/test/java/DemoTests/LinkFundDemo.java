package DemoTests;

import Helpers.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static Helpers.Browser.driver;


public class LinkFundDemo {

    public static String FUNDS_INVESTMENT_MANAGERS_UK_HREF      = "//a[contains (@href,'investment-managers-for-uk-investors')]";
    public static String FUNDS_INVESTMENT_MANAGERS_IRISH_HREF   = "//a[contains (@href,'investment-managers-for-irish-investors')]";
    public static String FUNDS_INVESTMENT_MANAGERS_SWISS_HREF   = "//a[contains (@href,'investment-managers-for-swiss-investors')]";
    public static String LIMITED_DISTRIBUTION_FUNDS_HREF        = "//a[contains (@href,'/ldf/')]";
    public static String INVESTMENT_FUNDS_HREF                  = "//a[contains (@href,'/investment-trusts/')]";


    @BeforeTest
    public void openBrowser(){
        Browser.open(Constants.LINK_FUND_URL);
    }

    @Test(description = "navigate to page and assert the 'funds' dropdown has expected links")
    public void assertActiveInvestmentManagers(){
        //hover over 'funds' dropdown
        Functions hoverOverFunds = new Functions();
        hoverOverFunds.hoverMouse(PageElements.FUNDS_DROPDOWN);

        //active url  for Investment managers for UK investors
        TestAssertions investmentManagersUKLink = new TestAssertions();
        investmentManagersUKLink.verifyPathExists(FUNDS_INVESTMENT_MANAGERS_UK_HREF, "Failed to find Investment Managers for UK investors");

        //active url for Investment managers for Irish investors
        TestAssertions investmentManagersIrishLink = new TestAssertions();
        investmentManagersIrishLink.verifyPathExists(FUNDS_INVESTMENT_MANAGERS_IRISH_HREF, "Failed to find Investment Managers for Irish investors");

        //active url for Investment managers for Swiss investors
        TestAssertions investmentManagersSwissLink = new TestAssertions();
        investmentManagersSwissLink.verifyPathExists(FUNDS_INVESTMENT_MANAGERS_SWISS_HREF, "Failed to find Investment Managers for Swiss investors");

        //active url for Limited Distribution Funds
        TestAssertions limitedDistributionFundsLink = new TestAssertions();
        limitedDistributionFundsLink.verifyPathExists(LIMITED_DISTRIBUTION_FUNDS_HREF, "Failed to find Limited Distribution Funds");

        //active url for Investment Trust
        TestAssertions investmentTrustLink = new TestAssertions();
        investmentTrustLink.verifyPathExists(INVESTMENT_FUNDS_HREF, "Failed to find Investment Trusts");
    }


    @Test(dependsOnMethods = {"assertActiveInvestmentManagers"}, description = "open Links and ensure you are taken to the correct page")
    public void openActiveLinksInFunds(){
        //hover over 'funds' dropdown
        Functions hoverOverFunds = new Functions();
        hoverOverFunds.hoverMouse(PageElements.FUNDS_DROPDOWN);

        //click on Investment managers UK link and assert you are taken to the right page
        Functions clickOnUkInvestmentManagers = new Functions();
        clickOnUkInvestmentManagers.clickOnElement("XPATH", FUNDS_INVESTMENT_MANAGERS_UK_HREF);

        TestAssertions investmentManagersForUkPage = new TestAssertions();
        investmentManagersForUkPage.verifyPathExists(PageElements.INVESTMENT_MANAGERS_FOR_UK_PAGE, "Could not find page 'Investment managers for UK investors'");

        //click on Investment managers Irish link and assert you are taken to the right page
        hoverOverFunds.hoverMouse(PageElements.FUNDS_DROPDOWN);

        Functions clickOnIrishInvestmentManagers = new Functions();
        clickOnIrishInvestmentManagers.clickOnElement("XPATH", FUNDS_INVESTMENT_MANAGERS_IRISH_HREF);

        TestAssertions investmentManagersForIrishPage = new TestAssertions();
        investmentManagersForIrishPage.verifyPathExists(PageElements.INVESTMENT_MANAGERS_FOR_IRISH_PAGE, "Could not find page 'Investment managers for Irish investors'");

        //click on Investment managers Swiss link and assert you are taken to the right page
        hoverOverFunds.hoverMouse(PageElements.FUNDS_DROPDOWN);

        Functions clickOnSwissInvestmentManagers = new Functions();
        clickOnSwissInvestmentManagers.clickOnElement("XPATH", FUNDS_INVESTMENT_MANAGERS_SWISS_HREF);

        TestAssertions investmentManagersForSwissPage = new TestAssertions();
        investmentManagersForSwissPage.verifyPathExists(PageElements.INVESTMENT_MANAGERS_FOR_SWISS_PAGE, "Could not find page 'Investment managers for Swiss investors'");

        //click on Limited Distribution Funds link and assert you are taken to the right page
        hoverOverFunds.hoverMouse(PageElements.FUNDS_DROPDOWN);

        Functions clickOnLinkDistributionFunds = new Functions();
        clickOnLinkDistributionFunds.clickOnElement("XPATH", LIMITED_DISTRIBUTION_FUNDS_HREF);

        TestAssertions linkDistributionFundsPage = new TestAssertions();
        linkDistributionFundsPage.verifyPathExists(PageElements.LIMITED_DISTRIBUTION_FUNDS_PAGE, "Could not find page 'Link Distribution Funds'");

        //click on Investment Trust link and assert you are taken to the right page
        hoverOverFunds.hoverMouse(PageElements.FUNDS_DROPDOWN);

        Functions clickOnInvestmentFunds = new Functions();
        clickOnInvestmentFunds.clickOnElement("XPATH", INVESTMENT_FUNDS_HREF);

        TestAssertions InvestmentFundsPage = new TestAssertions();
        InvestmentFundsPage.verifyPathExists(PageElements.INVESTMENT_TRUST_PAGE, "Could not find page 'Investment Trust'");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
