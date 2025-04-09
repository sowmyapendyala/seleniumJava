package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementHelper {

    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHorseButton(WebElement row) {
        WebElement horseButton = row.findElement(By.cssSelector("button[data-test-id^='select-horse-button--startlist']"));
        horseButton.click();
    }

    public void clickIfExists(WebElement row, String cssSelector) {
        List<WebElement> elements = row.findElements(By.cssSelector(cssSelector));
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
    }

    public void processRow(WebElement row) {
        clickHorseButton(row);
        clickIfExists(row, "span[data-test-id='startlist-cell-betdistribution']");
        clickIfExists(row, "span[data-test-id='startlist-cell-vodds']");
        clickIfExists(row, "span[data-test-id='startlist-cell-shoe']");
    }
}