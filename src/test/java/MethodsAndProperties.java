import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Random;

public class MethodsAndProperties {

    WebDriver driver;

    @BeforeMethod
    public void preConditions() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kulibin.com.ua/");

    }

    int randValue;
    int tempInt;
    int diff;
    int i;
    int j;
    int maxNumForRand;
    int numCards;

    String CATALOG_PATH = "//a[@href='/catalog/']";
    String ELECTROINSTRUMENT_PATH = "//a[@href='/catalog/elektroinstrument/']";
    String DRELI_PATH = "//a[@href='/catalog/dreli/']";

    String SALES_FLAG = "//span[@style='display:block;']";
    String SALEWS_FLAG_NUM_RAND = "(//span[@style='display:block;']/../../../a)";
    String OLD_PRICE = "(//span[contains(text(),'%')]/../../../..//span[@class='old-price'])";
    String OLD_PRICE_IN_CARD = "(//span[@class='item_old_price old-price'])";
    String MENU = "//a[@href='/catalog/']";
    String CRADS_WITH_SALE = "(//span[@style='display:block;']/../../../..//h4[@class='s_title'])";
    String NAME_WITH_SALE = "(//span[@style='display:block;']/../../../..//h4[@class='s_title']//span)";
    String tempStr;

    List<WebElement> tempListWeb;
    WebElement tempWeb;
    WebElement NextPage;
    WebElement _1_ELEMENT_IN_MENU;
    WebElement _2_SUB_ELEMENT_IN_MENU;

    public void navigate(WebElement _1_ELEMENT_IN_MENU, WebElement _2_SUB_ELEMENT_IN_MENU) {
        this._1_ELEMENT_IN_MENU = _1_ELEMENT_IN_MENU;
        this._2_SUB_ELEMENT_IN_MENU = _2_SUB_ELEMENT_IN_MENU;

        Actions actions = new Actions(driver);
        click(MENU);
        actions.moveToElement(_1_ELEMENT_IN_MENU).moveToElement(_2_SUB_ELEMENT_IN_MENU).click().build().perform();
    }

    public boolean isPresent(String xpath) {
        int result = driver.findElements(By.xpath(xpath)).size();
        System.out.println("Result is present: "+result);
        if (result != 0) {
            return true;
        } else return false;
    }

    public int rand(int min, int max) {

        diff = max - min;
        Random random = new Random();
        randValue = random.nextInt(diff + 1) + min;


        return randValue;
    }

    public int rand(int max) {
        int min = 1;
        int diff = max - min;
        Random random = new Random();
        randValue = random.nextInt(diff + 1) + min;
        return randValue;
    }

    public int size(String xpath) {

        int result = findByXpathElements(xpath).size();
        return result;

    }

    public void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void randClick(String card, String xpath, int numPages, int numCards) {
        StringBuffer buffer = new StringBuffer();

        for (i = 0; i < numPages; i++) {
            for (j = 0; j < numCards; j++) {
                tempInt = rand(size(card));
                tempStr = card;
                tempStr += "[" + tempInt + "]";
                System.out.println(tempStr);
                click(card);

                if (isPresent(xpath) == true) {
                    back();
                    //getName(card);
                    System.out.println(getName(NAME_WITH_SALE) + " is present");
                } else {
                    print("is absent");
                    tempStr = "Element is absent";
                    Assert.assertEquals(isPresent(card), true, tempStr);

                }
                tempStr = null;
            }

        }

    }

    public int getNumberFromText(String xpath) {
        tempStr = findByXpath(xpath).getText();

        return tempInt = Integer.parseInt(tempStr.replaceAll("[^0-9]", ""));

    }

    public int actualPercent(String xpath) {


        return 0;
    }

    public WebElement findByXpath(String xpath) {

        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> findByXpathElements(String xpath) {

        return driver.findElements(By.xpath(xpath));
    }

    public void nextPage() {
        NextPage = driver.findElement(By.partialLinkText("Следующая"));
    }

    public String getName(String path) {

        return findByXpath(path).getText();
    }

    public void print(String str) {
        System.out.println(str);
    }

    public void back() {
        driver.navigate().back();
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.close();
    }
}


