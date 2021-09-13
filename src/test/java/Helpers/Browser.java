package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class Browser {

    public static WebDriver driver;



    public static void open(String url){
        setupDriver(Constants.BROWSER_UNDER_TEST);
        driver.manage().window().maximize();
        driver.get(url);
    }


    public static void setupDriver(String browserName){
        //absolute file path for chrome driver
        File chromeExe = new File("drivers\\chromedriver.exe");
        String chromePath = chromeExe.getAbsolutePath();

        //absolute file path for firefox(gecko) driver
        File firefoxExe = new File("drivers\\geckodriver.exe");
        String firefoxPathPath = firefoxExe.getAbsolutePath();

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", firefoxPathPath);
            driver = new FirefoxDriver();
        }
        else{
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();

        }
    }
}
