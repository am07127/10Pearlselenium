package mytestproj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.name("q");
    private By searchButton = By.className("search-box__button--1oH7");

    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterSearchTerm(String searchTerm) {
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
        searchField.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
