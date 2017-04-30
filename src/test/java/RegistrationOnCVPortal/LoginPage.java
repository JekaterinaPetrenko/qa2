package RegistrationOnCVPortal;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * CV login page
 *
 */
public class LoginPage {

    private static final Logger LOGGER = Logger.getLogger(TestCVPortal.class);

    private static final By FORGOT_PASSWORD = By.xpath("//a[contains(@class, 'forgot arrow')]");
    private static final By EMAIL_FIELD = By.xpath("(//input[contains(@type, 'text')])[2]");
    private static final By FIELD = By.xpath("//div[contains(@id, 'hiddendiv')]");
    private static final By BUTTON = By.xpath("//input[contains(@class, 'blue_submit')]");
    private static final By USER_NEW_PASSWORD = By.xpath("(//*[contains(@id, 'password_945643616')])[2]");
    private static final By USER_CONFIRMATION_PASSWORD = By.xpath("//input[contains(@id,'password2')]");
    //    private static final By POP_UP = By.xpath("(//div[contains(@onclick,'Cvo.overlay.close();')])[2]");
    private static final By POP_UP = By.xpath("//div[contains(@class, 'close')]");

    private static final By STATUS_OF_REGISTRATION = By.xpath("//h1[contains(text(), 'Your password has been changed!')]");
    private static final By LINK_FOR_PASSWORD = By.xpath("//span[contains(text(), 'Link for password changing is successfully sent to your e-mail address!')]");


    private String text = "aprelja.xolodano@inbox.lv";
    private String userNewPassword = "TestRun002";


    public void clickOnForgotPassword(WebDriver driver) {
        WebElement forgotPassword = driver.findElement(FORGOT_PASSWORD);
        forgotPassword.click();
    }

    public void enterEmailAddress(WebDriver driver) {

        boolean waitForEmail = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(FIELD).isDisplayed();
            }
        });
        WebElement emailAddress = driver.findElement(EMAIL_FIELD);
        emailAddress.sendKeys(text);
        emailAddress.submit();

        WebElement remindMeButton = driver.findElement(BUTTON);
        remindMeButton.click();

        //lo
//        String linkForPassword = driver.findElement(LINK_FOR_PASSWORD).getText();
//        String linkIsSent = linkForPassword;
//        Assert.assertTrue("Link for password changing is successfully sent to your e-mail address!", linkIsSent.contains(linkForPassword));

    }

    public void newPasswordCreation(WebDriver driver) {
        LOGGER.info("Close pop-up ads");
        WebElement popUp = driver.findElement(POP_UP);
        boolean waitForPopUp = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(POP_UP).isDisplayed();
            }
        });
        popUp.click();

        LOGGER.info("Enter new password");
        WebElement newPassword = driver.findElement(USER_NEW_PASSWORD);
        newPassword.sendKeys(userNewPassword);

        LOGGER.info("Confirm new password");
        WebElement confirmationPassword = driver.findElement(USER_CONFIRMATION_PASSWORD);
        confirmationPassword.sendKeys(userNewPassword);
        confirmationPassword.submit();

        LOGGER.info("Save new password");
        WebElement saveButton = driver.findElement(BUTTON);
        boolean waitForButton = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(BUTTON).isDisplayed();
            }
        });
        saveButton.click();

        LOGGER.info("The password restore is completed:\n");
        String registrationStatus = driver.findElement(STATUS_OF_REGISTRATION).getText();
        String status = registrationStatus;

        Assert.assertTrue("Your password has been changed!", status.contains(registrationStatus));
        Assert.assertFalse("Password already exist or expired or invalid security ID," +
                " please order new reminder", !status.contains(registrationStatus));


    }
}
