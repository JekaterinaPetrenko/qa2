package AcountTesting;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Master on 28.05.2017..
 */
public class FieldTest {
    private static final Logger LOGGER = Logger.getLogger(FieldTest.class);
    private static final By ADD_USER = By.xpath("//*[contains(@href, 'addUser')]");
    private static final By ERROR_MESSAGE = By.xpath("//div[contains(text(), 'Some fields are empty' )]");
    private BaseFunktions baseFunctions = new BaseFunktions();

    @Test
    public void test() {
        LOGGER.info("Open Delfi News Portal");
        baseFunctions.goToUrl("qaguru.lv:8080/qa2/");

        LOGGER.info("Open user registration form");
        UserRegistrationForm userRegistrationForm = new UserRegistrationForm(baseFunctions);
        baseFunctions.click(ADD_USER);

        LOGGER.info("Check if there are empty fields");
        userRegistrationForm.checkEmptyFields();

        LOGGER.info("Enter user name");
        userRegistrationForm.enterUserName("Vasja");

        LOGGER.info("Enter user surname");
        userRegistrationForm.enterUserSurname("Pupkin");

//        LOGGER.info("Enter user email");
//        userRegistrationForm.enterUserMail("Vasja.Pupkin@gmail.lv");

        LOGGER.info("Confirm user registration");
        userRegistrationForm.confirmRegistration();

        LOGGER.info("Some fields are empty. The error message is shown 'Some fields are empty'");
        Assert.assertEquals("Some fields are empty", baseFunctions.findElement(ERROR_MESSAGE).getText());

          }

}
