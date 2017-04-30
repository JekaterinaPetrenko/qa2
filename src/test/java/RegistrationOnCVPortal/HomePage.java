package RegistrationOnCVPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private static final By CHOOSE_LANGUAGE = By.className("cvonl_mainmenu_top_users_language");
    private static final By LANGUAGE = By.xpath("//a[contains(@title,'Latviski')]");
    private static final By ENGLISH_LANGUAGE = By.xpath("//a[contains(@title,'Angliski')]");
    private static final By MENU = By.id("cvonl_mainmenu_top_users_login");
    private static final By LOGIN_BUTTON = By.xpath("//a[contains(@title,'Log in')]");



    public void selectLanguage(WebDriver driver) {
        WebElement chooseLanguage = driver.findElement(CHOOSE_LANGUAGE);
        WebElement language = driver.findElement(LANGUAGE);
        WebElement englishLanguage = driver.findElement(ENGLISH_LANGUAGE);
        Actions builder = new Actions(driver);
        builder.moveToElement(language).build().perform();
        englishLanguage.click();
    }

    public void navigateToLoginPage(WebDriver driver) {
        WebElement menu = driver.findElement(MENU);
        boolean waitFor = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(MENU).isDisplayed();
            }
        });

        WebElement loginButton = driver.findElement(LOGIN_BUTTON);
        loginButton.click();
        //jjjjj
    }

}
