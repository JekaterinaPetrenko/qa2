package RegistrationOnCVPortal;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class MailBox {
    private static final By USER_LOGIN = By.xpath("//input[contains(@id, 'imapuser')]");
    private static final By USER_PASSWORD = By.xpath("//input[contains(@id, 'pass')]");
    private static final By SIGN_IN_BUTTON = By.xpath("//div[contains(@class, 'tc btn-login')]");
    private static final By LISTS_FOLDER = By.xpath("//span[contains(@class, 'ci-icon ci-icon-envelope-lists')]");
    private static final By RECEIVED_MAIL = By.xpath("(//td[contains(@class, 'eml__from')])[1]");
    private static final By RECEIVED_LINK = By.xpath("//a[contains(@href, 'http://www.cv.lv/password/confirm/')]");
    private static final Logger LOGGER = Logger.getLogger(TestCVPortal.class);

    private String userLogin = "aprelja.xolodano";
    private String userPassword = "TestRun001";

    public void enterLogin(WebDriver driver) {
        WebElement login = driver.findElement(USER_LOGIN);
        login.sendKeys(userLogin);
    }

    public void enterPassword(WebDriver driver) {
        WebElement password = driver.findElement(USER_PASSWORD);
        password.sendKeys(userPassword);
    }

    public void clickOnSignInButton(WebDriver driver) {
        WebElement signInButton = driver.findElement(SIGN_IN_BUTTON);
        signInButton.click();
    }

    public void checkListsInBlockContent(WebDriver driver) {
        WebElement blockContent = driver.findElement(LISTS_FOLDER);
        blockContent.click();
        driver.navigate().refresh();
    }

    public void openFirstMail(WebDriver driver) {
        WebElement firstMail = driver.findElement(RECEIVED_MAIL);
        firstMail.click();
    }

    public void navigateToCVToRestorePasword(WebDriver driver) {
        WebElement link = driver.findElement(RECEIVED_LINK);
        link.click();

        LOGGER.info("Navigate to new opened tab");

        String currentWindowHandle = driver.getWindowHandle();
        //Get the list of all window handles
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());

        for (String window : windowHandles) {

            //if it contains the current window we want to eliminate that from switchTo();
            if (window != currentWindowHandle) {
                //Now switchTo new Tab.
                driver.switchTo().window(window);
            }

        }
    }
}
