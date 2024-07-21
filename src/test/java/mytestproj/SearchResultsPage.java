package mytestproj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    private WebDriver driver;

    private By dellCheckbox = By.xpath("//*[@id='root']/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div[1]/label[1]/span[1]/input");
    private By minPriceInput = By.xpath("//*[@id='root']/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/input[1]");
    private By maxPriceInput = By.xpath("//*[@id='root']/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/input[2]");
    private By priceFilterButton = By.xpath("//*[@id='root']/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/button");
    private By resultCountText = By.xpath("//*[@id='root']/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div/span[1]");
    private By firstResultImage = By.id("id-img");
    private By freeShippingText = By.xpath("//*[@id='module_seller_delivery']/div/div/div[3]/div/div[1]/div/div/div[1]/div[1]/span[1]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDellCheckbox() {
        driver.findElement(dellCheckbox).click();
    }

    public void setPriceRange(String minPrice, String maxPrice) {
        driver.findElement(minPriceInput).sendKeys(minPrice);
        driver.findElement(maxPriceInput).sendKeys(maxPrice);
        driver.findElement(priceFilterButton).click();
    }

    public void getResultCount() {
        String resultText = driver.findElement(resultCountText).getText();
        int num = Integer.parseInt(resultText.substring(0, 3));
        if (num > 0) {
            System.out.println(num);
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public void clickFirstResultImage() {
        driver.findElement(firstResultImage).click();
    }

    public String getFreeShippingText() {
        return driver.findElement(freeShippingText).getText();
    }
}
