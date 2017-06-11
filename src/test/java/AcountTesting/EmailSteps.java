package AcountTesting;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

/**
 * Created by Master on 04.06.2017..
 */
public class EmailSteps {
    private static final By ADD_USER = By.xpath("//*[contains(@href, 'addUser')]");
    private static final By ERROR_MESSAGE = By.xpath("//div[contains(text(), 'Email is not valid' )]");
    private BaseFunktions baseFunctions = new BaseFunktions();
    public UserRegistrationForm userRegistrationForm = new UserRegistrationForm(baseFunctions);

    public EmailSteps(BaseFunktions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }
    public EmailSteps() {
            }

    @Given("QA Test System is opened")
    public void QA_Test_System_is_opened() {
        baseFunctions.goToUrl("qaguru.lv:8080/qa2/");
    }

    @Given("User registration form is opened")
    public void User_registration_form_is_opened(){

        baseFunctions.click(ADD_USER);
    }


    @When("^User enter the following for registration$")
    public void user_enter_the_following_for_registration(Map<String,String> table){

        userRegistrationForm.enterUserName(table.get("name"));
        userRegistrationForm.enterUserSurname(table.get("surname"));
        userRegistrationForm.enterUserPhone(table.get("phone"));
        userRegistrationForm.enterUserMail(table.get("email"));


    }

    @When("User confirm registration")
            public void user_confirm_registration() {
        userRegistrationForm.confirmRegistration();
    }


    @Then("User see message (.*)")
    public void user_See_Message_Email_Is_NotValid(String message) throws Throwable {
        Assert.assertEquals(message, baseFunctions.findElement(ERROR_MESSAGE).getText());

    }
}
