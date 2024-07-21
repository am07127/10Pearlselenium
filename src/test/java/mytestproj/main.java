package mytestproj;

import mytestproj.Homepage;
import mytestproj.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/asadmuhammad/Downloads/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.daraz.pk/");

            Homepage homePage = new Homepage(driver);
            homePage.enterSearchTerm("laptop");
            Thread.sleep(2000);
            homePage.clickSearchButton();
            Thread.sleep(10000);

            SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
            searchResultsPage.clickDellCheckbox();
            Thread.sleep(10000);
            searchResultsPage.setPriceRange("5000", "50000");
            Thread.sleep(10000);

            searchResultsPage.getResultCount();

            searchResultsPage.clickFirstResultImage();
            Thread.sleep(10000);

            String freeText = searchResultsPage.getFreeShippingText();
            System.out.println(freeText);
            if (freeText.contains("Free")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
