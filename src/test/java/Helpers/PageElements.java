package Helpers;

public class PageElements {

    //Xpaths
    public static String HOME_PAGE_TITLE                       = "//head//title[text()='Home']";
    public static String SEARCH_MENU                           = "//i[@class='fa fa-search']";
    public static String SEARCH_BUTTON                         = "//button[text()='Search']";

    //Link funds paths
    public static String SEARCH_RESULTS_CONTAINER              = "//section[@id='SearchResults']//child::h3";
    public static String FUNDS_DROPDOWN                        = "//a[@id='navbarDropdown' and @aria-haspopup='true']";
    public static String INVESTMENT_MANAGERS_FOR_UK_PAGE       = "//head//title[text()='Investment Managers for UK investors']";
    public static String INVESTMENT_MANAGERS_FOR_IRISH_PAGE    = "//head//title[text()='Investment Managers for Irish investors']";
    public static String INVESTMENT_MANAGERS_FOR_SWISS_PAGE    = "//head//title[text()='Investment Managers for Swiss investors']";
    public static String LIMITED_DISTRIBUTION_FUNDS_PAGE       = "//h2[text()='Limited distribution funds Terms and Conditions']";
    public static String INVESTMENT_TRUST_PAGE                 = "//h2[text()='Investment Trust Terms and Conditions']";


    //Id's
    public static String ACCEPT_BUTTON   = "btnAccept";



    //Names
    public static String SEARCH_FIELD    = "searchTerm";
}
