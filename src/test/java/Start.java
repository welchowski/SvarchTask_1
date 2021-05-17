import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//
import java.util.*;

public class Start  {

    public int Rand(int min, int max) {

        int diff = max - min;
        Random random = new Random();
        int randValue = random.nextInt(diff + 1) + min;


        return randValue;
    }

    @Test
    public void test(){

        System.out.println("1");
    }

}
