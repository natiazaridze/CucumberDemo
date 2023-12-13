import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class FirstTest {

    @Test
    public void firstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        Actions act = new Actions(driver);
        WebElement element = driver.findElement(By.className("wikipedia-search-input"));
        element.sendKeys("Georgia");

        WebElement searchButton = driver.findElement(By.xpath("//input[@class='wikipedia-search-button' and @type='submit']"));
/*
        act.doubleClick(searchButton);
*/      searchButton.click();

        WebElement wait =  new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(byLinkText("Georgia")));
        wait.click();

        driver.quit();


    }
}
