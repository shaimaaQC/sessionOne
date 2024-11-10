package t;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class T {

    @Test
    public void t1 () {
        //Setup
        WebDriver driver = new ChromeDriver() ;

        //Steps
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String actualResult = driver.findElement(By.id("flash")).getText();
        String expectedResult = "You logged into a secure area!";
        assertTrue (actualResult.contains(expectedResult));

        //Tear down
        driver.quit();
    }

    @Test
    public void t2 () {
        //Setup
        WebDriver driver = new ChromeDriver() ;

        //Steps
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith11");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String actualResult = driver.findElement(By.id("flash")).getText();
        String expectedResult = "Your username is invalid!";
        assertTrue (actualResult.contains(expectedResult));
        //Tear down
        driver.quit();
    }


    @Test
    public void t3 () {
        //Setup
        WebDriver driver = new ChromeDriver() ;

        //Steps
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.className("radius")).click();
        String actualResult = driver.findElement(By.id("flash")).getText();
        String expectedResult = "Your password is invalid!";
        assertTrue (actualResult.contains(expectedResult));
        //Tear down
        driver.quit();
    }
}
