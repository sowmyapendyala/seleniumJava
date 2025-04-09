package atg.tests;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Selenium {

    WebDriver driver;
    ElementHelper elementHelper;

    @BeforeClass
    public void setUp() {
        System.out.println("Test is started");
        driver = new ChromeDriver();
        elementHelper = new ElementHelper(driver);
        System.out.println("Browser opened");
    }

    @Test
    public void openAtg() {
        driver.get("https://www.atg.se/");
        driver.manage().window().maximize();
        System.out.println("Web page is open");

        driver.findElement(By.xpath("//button[@data-test-id='acceptAllCookiesBtn']")).click();

        driver.findElement(By.xpath("//div[text()='Alla spel']")).click();
        sleep(5);
        driver.findElement(By.xpath("//*[@id='all-games-list']/ul[1]/li[9]/a/div[2]/span")).click();
        sleep(5);
        driver.findElement(By.xpath("//div[@data-test-id='V4-game']/div/div[3]/div/div/div/div/div[2]/div/div/button")).click();
        sleep(5);
        driver.findElement(By.xpath("//*[@id='composition-menu']/li[2]")).click();
        sleep(5);
        driver.findElement(By.xpath("//button[text()='Bekräfta']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("horse-1aiw0kl")));

        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));

        // Process rows for Row V4_1
        for (int i = 0; i < Math.min(rows.size(), 4); i++) {
            elementHelper.processRow(rows.get(i));
        }
        // Process rows for Row V4_2
        driver.findElement(By.xpath("//*[@id=\"race-section-scroll-container\"]/div/div[2]/button/div[1]/div")).click();
        rows = table.findElements(By.cssSelector("tbody tr"));
        for (int i = 0; i < Math.min(rows.size(), 1); i++) {
            elementHelper.processRow(rows.get(i));
        }
        // Process rows for Row V4_3
        driver.findElement(By.xpath("//*[@id=\"race-section-scroll-container\"]/div/div[3]/button/div/div")).click();
        rows = table.findElements(By.cssSelector("tbody tr"));
        for (int i = 0; i < Math.min(rows.size(), 2); i++) {
            elementHelper.processRow(rows.get(i));
        }
        // Process rows for Row V4_4
        driver.findElement(By.xpath("//*[@id=\"race-section-scroll-container\"]/div/div[4]/button/div/div")).click();
        rows = table.findElements(By.cssSelector("tbody tr"));
        for (int i = 0; i < Math.min(rows.size(), 4); i++) {
            elementHelper.processRow(rows.get(i));
        }

        driver.findElement(By.xpath("//button[@data-test-id='play-game-coupon']")).click();
        System.out.println("Test is finished");
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}