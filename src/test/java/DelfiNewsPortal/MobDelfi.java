package DelfiNewsPortal;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Master on 05.05.2017..
 */
public class MobDelfi {
    private static final Logger LOGGER = Logger.getLogger(BrowserDelfi.class);
    private static final By MOBILE_ARTICLES = By.className("md-mosaic-title");
    private static final By MOBILE_TITLE = By.className("md-scrollpos");
    private static final By MOBILE_COUNTER = By.className("commentCount");
    private static final By COMMENT_PAGE_COUNTERS = By.xpath("//*[contains(@class, 'comment-thread-switcher-selected-reg ')]/a/span");
    BaseFunctions baseFunctions;
    public Map<String, String> fiveArticles = new HashMap<String, String>();

    public MobDelfi(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
        LOGGER.info("Delfi home page is opened");
    }

    public void mobHashMap() {

        LOGGER.info("Here is our 5 articles from mobile version:");
        for (Map.Entry entry : fiveArticles.entrySet()) {
            LOGGER.info(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void listOfMobArticles() {

        List<WebElement> mobArticles = baseFunctions.findElements(MOBILE_ARTICLES);

        for (int i = 0; i < 5; i++) {

            if (mobArticles.get(i).findElements(MOBILE_COUNTER).isEmpty()) {
                fiveArticles.put(mobArticles.get(i).findElement(MOBILE_TITLE).getText(), "0");
            } else {
                fiveArticles.put(mobArticles.get(i).findElement(MOBILE_TITLE).getText(), mobArticles.get(i).findElement(MOBILE_COUNTER).getText());
            }
        }

    }

}
