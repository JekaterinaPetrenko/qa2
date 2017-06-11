package AcountTesting;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Master on 04.06.2017..
 */
public class ScoreTest {
    private static final Logger LOGGER = Logger.getLogger(RegistrationSuccessfulTest.class);
    private BaseFunktions baseFunctions = new BaseFunktions();
    private static final By ADD_USER = By.xpath("//*[contains(@href, 'addUser')]");
    private static final By ADD_SCORE = By.xpath("(//*[contains(@class, 'score')])");

    @Test
    public void test(){
        LOGGER.info("Open Delfi News Portal");
        baseFunctions.goToUrl("qaguru.lv:8080/qa2/");


        LOGGER.info("Open score form");
        ScoreForm scoreForm = new ScoreForm(baseFunctions);
        List<WebElement> scoreCount = baseFunctions.findElements(ADD_SCORE);
        baseFunctions.pause(500);
        int count  = scoreCount.size();
        scoreCount.get(count-1).click();

        LOGGER.info("Enter user age");
        int age = 25;
        scoreForm.enterAge(String.valueOf(age));

        LOGGER.info("Enter city");
        scoreForm.enterCity("Riga");

        LOGGER.info("Enter country");
        scoreForm.enterCountry("Latvia");

        LOGGER.info("Enter user child count");
        int child = 2;
        scoreForm.enterChildCount(String.valueOf(child));
//
//        scoreForm.confirmFilledScore();

    }
}
