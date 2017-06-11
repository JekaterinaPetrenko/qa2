package AcountTesting;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Master on 25.05.2017..
 */
public class RegistrationSuccessfulTest {
    private static final Logger LOGGER = Logger.getLogger(RegistrationSuccessfulTest.class);
    private BaseFunktions baseFunctions = new BaseFunktions();
    private static final By ADD_USER = By.xpath("//*[contains(@href, 'addUser')]");
    private static final By ADD_SCORE = By.xpath("(//*[contains(@class, 'score')])");

    @Test
    public void test(){
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

        LOGGER.info("Enter user phone number");
        userRegistrationForm.enterUserPhone("Vasja.Pupkin@gmail.lv");

        LOGGER.info("Enter user email");
        userRegistrationForm.enterUserMail("63633351");

        LOGGER.info("Enter user person id");
        userRegistrationForm.enterPersonID("12107989-11261");

        LOGGER.info("Confirm user registration");
        userRegistrationForm.confirmRegistration();
//
//        LOGGER.info("Open score form");
//        ScoreForm scoreForm = new ScoreForm(baseFunctions);
//        baseFunctions.click(ADD_SCORE);
//
//        LOGGER.info("Enter user age");
//        int age = 25;
//        scoreForm.enterAge(String.valueOf(age));
//
//        LOGGER.info("Enter city");
//        scoreForm.enterCity("Riga");
//
//        LOGGER.info("Enter country");
//        scoreForm.enterCountry("Latvia");
//
//        LOGGER.info("Enter user child count");
//        int child = 2;
//        scoreForm.enterChildCount(String.valueOf(child));
//
//        scoreForm.confirmFilledScore();

    }
}
