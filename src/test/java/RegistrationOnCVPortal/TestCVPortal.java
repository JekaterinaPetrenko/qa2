package RegistrationOnCVPortal;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class TestCVPortal {
    private static final Logger LOGGER = Logger.getLogger(TestCVPortal.class);
    private static WebDriver driver;
    static HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    static LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    static MailBox mailBox = PageFactory.initElements(driver, MailBox.class);


    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void cvPortalTesting() {
        LOGGER.info("Starting our test:");
        driver = getDriver();

        LOGGER.info("Open www.cv.lv home page");
        driver.get("http://www.cv.lv/");

        LOGGER.info("Select English language");
        homePage.selectLanguage(driver);

        LOGGER.info("Navigate to Login Page");
        homePage.navigateToLoginPage(driver);

        LOGGER.info("User forget password");
        loginPage.clickOnForgotPassword(driver);

        LOGGER.info("User enter email address to restore the password");
        loginPage.enterEmailAddress(driver);

        LOGGER.info("User check link to restore password in mail box");
        LOGGER.info("Open inbox.lv");
        driver.get("https://www.inbox.lv/?language=en&persist_language=1");

        LOGGER.info("Enter login");
        mailBox.enterLogin(driver);

        LOGGER.info("Enter password");
        mailBox.enterPassword(driver);

        LOGGER.info("Check email");
        mailBox.clickOnSignInButton(driver);
        mailBox.checkListsInBlockContent(driver);

        LOGGER.info("First mail is opened");
        mailBox.openFirstMail(driver);

        LOGGER.info("Click on link and navigate to cv.lv to restore password");
        mailBox.navigateToCVToRestorePasword(driver);

        LOGGER.info("New password creation");
        loginPage.newPasswordCreation(driver);

    }

    /**
     * Creating WebDriver for the test
     *
     * @return - WebDriver
     */
    private WebDriver getDriver() {
        LOGGER.info("Setting global property for driver");
        System.setProperty("webdriver.chrome.driver", "C:" +
                "\\Users\\Master\\IdeaProjects\\drivers\\chromedriver.exe");


        LOGGER.info("Opening Google Chrome browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //kkk

        return driver;
    }
}
