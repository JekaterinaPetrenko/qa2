package AcountTesting;

import org.openqa.selenium.By;

/**
 * Created by Master on 25.05.2017..
 */
public class ScoreForm {
    //http://qaguru.lv:8080/qa2/addScore/14

    private static final By AGE = By.xpath("//*[contains(@name, 'age')]");
    private static final By CITY = By.xpath("//*[contains(@name, 'city')]");
    private static final By COUNTRY = By.xpath("//*[contains(@name, 'country')]");
    private static final By CHILD_COUNT = By.xpath("//*[contains(@name, 'childCount')]");
    private static final By BUTTON= By.xpath("//*[contains(@type, 'submit')]");
    private static final By NUMBER_OF_FIELDS = By.xpath("//input[contains(@type, 'text')]");

    BaseFunktions baseFunktions;

    public ScoreForm(BaseFunktions baseFunktions) {
        this.baseFunktions = baseFunktions;
    }

    public void checkEmptyField(){
        baseFunktions.emptyFields(NUMBER_OF_FIELDS);
    }
        public void enterAge(String num){

        baseFunktions.fillInput(AGE, num);

        }

        public void enterCity(String cityName){

            baseFunktions.fillInput(CITY, cityName);
        }

        public void enterCountry(String countryName){
            baseFunktions.fillInput(COUNTRY, countryName);

        }

        public void enterChildCount(String childCount){


            baseFunktions.fillInput(CHILD_COUNT,childCount);
        }


        public void confirmFilledScore(){
            baseFunktions.click(BUTTON);

        }
    }
