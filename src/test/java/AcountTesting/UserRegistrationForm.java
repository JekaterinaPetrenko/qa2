package AcountTesting;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Master on 25.05.2017..
 */
public class UserRegistrationForm {

    private static final By LOGIN = By.xpath("//*[contains(@name, 'name')]");
    private static final By SURNAME = By.xpath("//*[contains(@name, 'surname')]");
    private static final By PHONE = By.xpath("//*[contains(@name, 'phone')]");
    private static final By EMAIL = By.xpath("//*[contains(@name, 'email')]");
    private static final By GENRE = By.xpath("//*[contains(@name, 'genre')]");
    private static final By MALE_GENRE = By.xpath("//*[contains(text(), 'Male')]");
    private static final By FEMALE_GENRE = By.xpath("//*[contains(text(), 'Female')]");
    private static final By PERSON_ID = By.xpath("//*[contains(@name, 'personId')]");
    private static final By NUMBER_OF_FIELDS = By.xpath("//input[contains(@type, 'text')]");

    private static final By BUTTON = By.xpath("//*[contains(@type, 'submit')]");
    BaseFunktions baseFunktions;

    public UserRegistrationForm(BaseFunktions baseFunktions) {

        this.baseFunktions = baseFunktions;
    }


    public void checkEmptyFields() {

    baseFunktions.emptyFields(NUMBER_OF_FIELDS);
    }

    public void enterUserName(String text) {

        baseFunktions.fillInput(LOGIN, text);

    }

    public void enterUserSurname(String text) {

        baseFunktions.fillInput(SURNAME, text);

    }

    public void enterUserPhone(String text) {

        baseFunktions.fillInput(PHONE, text);
    }

    public void enterUserMail(String text) {

        baseFunktions.fillInput(EMAIL, text);

    }

    public void chooseGenre() {
        baseFunktions.click(GENRE);
        baseFunktions.waitForElement(FEMALE_GENRE,500);
        baseFunktions.click(FEMALE_GENRE);

    }

    public void enterPersonID(String text) {
        baseFunktions.fillInput(PERSON_ID,text);

    }

    public void confirmRegistration() {
        baseFunktions.click(BUTTON);

    }
}
