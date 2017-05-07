package DelfiNewsPortal;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * Created by Master on 05.05.2017..
 */
public class TestAutomation {
    private static final Logger LOGGER = Logger.getLogger(TestAutomation.class);
    private static final String WEB_URL = "http://rus.delfi.lv/";
    private static final String MOB_URL = "http://m.rus.delfi.lv";
    private static final By SEARCHING_ARTICLE = By.xpath("(//a[contains(text(), 'Во Франции стартовал решающий тур президентских выборов')])[1]");
    private static final By COMMENT_PAGE_COUNTER = By.xpath("//*[contains(@class, 'comment-thread-switcher-selected-reg ')]/a/span");
    private static final By REG_COMMENT_COUNTER = By.xpath("//a[contains(@class, 'comment-thread-switcher-list-a-reg')]");
    private static final By UNREG_COMMENT_COUNTER = By.xpath("//a[contains(@class, 'comment-thread-switcher-list-a-anon')]");
    private static final By LOAD_MORE_COMMENTS = By.xpath("//div[contains(@class, 'load-more-comments-btn')]");
    private static final By COMMENT_NUMBER = By.xpath("//div[contains(@class, 'comment-content-inner')]");
    private static final By HIDDEN_COMMENT_NUMBER = By.xpath("//a[contains(@class, 'load-more-comments-btn-link')]");


    private BaseFunctions baseFunctions = new BaseFunctions();


    @Test
    public void HomePage() {

        LOGGER.info("We are opening browser version");
        baseFunctions.goToUrl("http://rus.delfi.lv/");


        LOGGER.info("We are taking first 5 articles from Delfi browser version: names and comment count");
        BrowserDelfi browserDelfi = new BrowserDelfi(baseFunctions);
        browserDelfi.listOfWebArticles();
        browserDelfi.webHashMap();


//        LOGGER.info("We are opening mobile version");
//        baseFunctions.goToUrl("http://m.rus.delfi.lv");
//
//        LOGGER.info("We are taking first 5 articles from Delfi mobile version: names and comment count");
//        MobDelfi mobDelfi = new MobDelfi(baseFunctions);
//        mobDelfi.listOfMobArticles();
//        mobDelfi.mobHashMap();

//        LOGGER.info("Comparison of the browser version with the mobile");
//        Assert.assertEquals("Comparison is passed", browserDelfi.browserHashMap(), mobDelfi.mobHashMap());

        /**
         * Choose article which you want to open.
         * Copy text of article title.
         * Paste copied text in locator SEARCHING_ARTICLE"
         */

        LOGGER.info("Open article");
        baseFunctions.click(SEARCHING_ARTICLE);

        LOGGER.info("Navigating to comment page ");
        browserDelfi.navigateToCommentPage();

        baseFunctions.click((UNREG_COMMENT_COUNTER));
        LOGGER.info("List of comments");
        while (baseFunctions.findElements(LOAD_MORE_COMMENTS).size() > 0) {
//            int a = baseFunctions.findElements(LOAD_MORE_COMMENTS).size();
            for (int i = 0; i < baseFunctions.findElements(LOAD_MORE_COMMENTS).size(); i++) {

                baseFunctions.findElements(LOAD_MORE_COMMENTS).get(i);
                baseFunctions.getElement(LOAD_MORE_COMMENTS).click();

            }
            System.out.println(baseFunctions.findElements(COMMENT_NUMBER).size());

        }
//

            LOGGER.info("Number of comments");
            baseFunctions.waitForElement(COMMENT_NUMBER, 5);
            System.out.println(baseFunctions.findElements(COMMENT_NUMBER).size());




    }
}
