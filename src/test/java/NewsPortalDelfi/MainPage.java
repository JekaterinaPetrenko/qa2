package NewsPortalDelfi;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Master on 16.05.2017..
 */
public class MainPage {
    private static final Logger LOGGER = Logger.getLogger(MainPage.class);
    private static final By COUNTER = By.className("comment-count");
    private static final By ARTICLES = By.xpath("//h3[contains(@class, 'top2012-title')]");
    private static final By ARTICLE_HEADER = By.className("top2012-title");
    public Map<String, String> fiveArticles = new HashMap<String, String>();
    BaseFunctions baseFunctions;

    public MainPage(BaseFunctions baseFunctions) {

        this.baseFunctions = baseFunctions;
        LOGGER.info("Delfi browser version main page is opened");
    }

    public void getListOfArticlesFromBrowser() {
        LOGGER.info("We are taking first 5 articles: names and comment count");
        List<WebElement> browserArticles = baseFunctions.findElements(ARTICLES);

        for (int i = 0; i < 5; i++) {
            if (browserArticles.get(i).findElements(COUNTER).isEmpty()) {
                fiveArticles.put(browserArticles.get(i).findElement(ARTICLE_HEADER).getText(), "0");
            } else {
                fiveArticles.put(browserArticles.get(i).findElement(ARTICLE_HEADER).getText(), browserArticles.get(i).findElement(COUNTER).getText());
            }
        }
        LOGGER.info("Here are our 5 articles:\n");
        for (Map.Entry entry : fiveArticles.entrySet()) {
            LOGGER.info(entry.getKey() + ": " + entry.getValue());
        }
    }
//
    public void openArticle(){
        LOGGER.info("Choose article which you want to test:");
        baseFunctions.click(By.xpath("(//h3//a[contains(@class, 'top2012-title')])[4]"));

    }
}
