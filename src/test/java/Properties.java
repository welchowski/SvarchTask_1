import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class Properties {
    WebDriver driver;

    @BeforeTest
    public void preConditions() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kulibin.com.ua/");
    }

    int randValue=0;
    int max;

    Actions actions = new Actions(driver);
    String CATALOG_PATH="//a[@href='/catalog/']";
    String ELECTROINSTRUMENT_PATH="//a[@href='/catalog/elektroinstrument/']";
    String DRELI_PATH="//a[@href='/catalog/dreli/']";
    String SALES_FLAG="//span[@style='display:block;']";
    String SALEWS_FLAG_NUM_RAND="(//span[@style='display:block;']/../../../a)[" + randValue + "]";


    WebElement MENU;
    WebElement _1_ELEMENT_IN_MENU;
    WebElement _2_ELEMENT_IN_MENU;
    WebElement _3_ELEMENT_IN_MENU;




    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.close();
    }


}
