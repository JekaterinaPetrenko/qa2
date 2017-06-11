package NewsPortalDelfi;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BaseFunctions {
    private static final String CHROME_DRIVER_LOCATION = "C:\\Users\\Master\\IdeaProjects\\drivers\\chromedriver.exe";

    private static final Logger LOGGER = Logger.getLogger(DelfiNewsPortal.BaseFunctions.class);
    WebDriver driver;

    public BaseFunctions() {

        LOGGER.info("Setting global property for driver");
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);

        LOGGER.info("Starting first chromedriver");
        this.driver = new ChromeDriver();

        LOGGER.info("Maximize browser window size");
        driver.manage().window().maximize();
    }

    /**
     * This method goes to specific URL
     *
     * @param url web address
     */
    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        LOGGER.info("User goes to: " + url);
        driver.get(url);

    }


    /**
     * Method to stop the webdriver
     */
    public void closeBrowser() {

        LOGGER.info("Stopping driver");
        driver.quit();
    }

    /**
     * Method to clock on specific element
     *
     * @param element element to click
     */
    public void click(By element) {
        driver.findElement(element).click();
    }

    /**
     * Method is waiting for element to be added in DOM
     *
     * @param element - element to wait
     * @param mills   - max time to wait in milliseconds
     */
    public void waitForElement(By element, long mills) {
        WebDriverWait wait = new WebDriverWait(driver, mills);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /**
     * Method checks if element is available in DOM
     *
     * @param element element to check
     * @return true or false
     */
    public void isPresentElement(By element) {
        List<WebElement> elements = driver.findElements(element);
        if (elements.size() != 0) {
            for (WebElement webButton : elements) {
                webButton.click();
            }
        }
    }

    /**
     * Method returns a list of elements with a specific locator
     *
     * @param element element locator to search
     * @return list of WebElements
     */
    public List<WebElement> findElements(By element) {

        return driver.findElements(element);

    }

    /**
     * Method returns WebElement with a specific locator
     *
     * @param element element locator to search
     * @return WebElement
     */
    public WebElement getElement(By element) {
        return driver.findElement(element);
    }

    /**
     * Method returns String without first and last character
     *
     * @param cuntStr String variable
     * @return String
     */
    public Integer removeChars(String cuntStr) {

        return Integer.parseInt(cuntStr.substring(1, cuntStr.length() - 1));
    }
    /**
     * This method created to pause test - needs to wait for data refresh or receiving mail message
     *
     * @param mills time to wait in milliseconds
     */
    public void pause(long mills) {
        try {
            Thread.sleep(mills);
            LOGGER.info("Test pauses for " + mills + " milliseconds to wait for data");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
