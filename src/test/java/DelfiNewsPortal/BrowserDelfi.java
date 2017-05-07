package DelfiNewsPortal;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BrowserDelfi {

    private static final Logger LOGGER = Logger.getLogger(BrowserDelfi.class);
    private static final By COUNTER = By.xpath("//a[contains(@class, 'comment-count')]");
    private static final By ARTICLES = By.xpath("//h3[contains(@class, 'top2012-title')]");
    private static final By ARTICLE_HEADER = By.className("top2012-title");
    BaseFunctions baseFunctions;
    public Map<String, String> fiveArticles = new HashMap<String, String>();

    public BrowserDelfi(BaseFunctions baseFunctions) {

        this.baseFunctions = baseFunctions;
        LOGGER.info("Delfi home page is opened");
    }

    public void webHashMap() {

        LOGGER.info("Here is our 5 articles from mobile version:");
        for (Map.Entry entry : fiveArticles.entrySet()) {
            LOGGER.info(entry.getKey() + ": " + entry.getValue());
        }

    }

public void listOfWebArticles(){

    List<WebElement> browserArticles = baseFunctions.findElements(ARTICLES);

    for (int i = 0; i < 5; i++) {
        if (browserArticles.get(i).findElements(COUNTER).isEmpty()) {
            fiveArticles.put(browserArticles.get(i).findElement(ARTICLE_HEADER).getText(), "0");
        } else {
            fiveArticles.put(browserArticles.get(i).findElement(ARTICLE_HEADER).getText(), browserArticles.get(i).findElement(COUNTER).getText());
        }
    }

}

public void navigateToCommentPage(){
    baseFunctions.click(COUNTER);
}

}

