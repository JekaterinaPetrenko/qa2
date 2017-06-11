package NewsPortalDelfi;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SourceType;

import java.util.List;

/**
 * Created by Master on 16.05.2017..
 */
public class NewsPortalTesting {
    private static final Logger LOGGER = Logger.getLogger(NewsPortalTesting.class);

    private static final By REG_COUNT = By.xpath("//*[@id=\"comments-listing\"]/div[3]/a[1]/span");
    private static final By UNREG_COUNT = By.xpath("//*[@id=\"comments-listing\"]/div[3]/a[2]/span");


    private BaseFunctions baseFunctions = new BaseFunctions();

    @Test
    public void test() {
        LOGGER.info("Open Delfi News Portal");
        baseFunctions.goToUrl("rus.delfi.lv/");

        MainPage mainPage = new MainPage(baseFunctions);
        LOGGER.info("List of articles from browser version");
        mainPage.getListOfArticlesFromBrowser();

        LOGGER.info(" Open one of article");
        mainPage.openArticle();

        LOGGER.info("Open page with comments");
        ArticlePage articlePage = new ArticlePage(baseFunctions);
        articlePage.openCommentPage();

        LOGGER.info("Registered comments page is opened: ");
        CommentPage commentPage = new CommentPage(baseFunctions);

        LOGGER.info("Count of registered comments is: ");
        commentPage.registeredCommentsCount();
        String regCount = baseFunctions.getElement(REG_COUNT).getText();
        int countOfReg = baseFunctions.removeChars(regCount);
        System.out.println("Count of registered comments: " + countOfReg);

        LOGGER.info("Check up of registered comments count");
        Assert.assertEquals(countOfReg, commentPage.registeredCommentsCount());

        LOGGER.info("Count of Unregistered comments is: ");
        commentPage.openUnregisteredComments();
        commentPage.unregisteredCommentsCount();

        String unregCount = baseFunctions.getElement(UNREG_COUNT).getText();
        int countOfUnreg = baseFunctions.removeChars(unregCount);
//        System.out.println("Count of unregistered comments: "+countOfUnreg);

        LOGGER.info("Check up of unregistered comments count");
        Assert.assertEquals(countOfUnreg, commentPage.unregisteredCommentsCount());

        LOGGER.info("Common count of comments is true");
        Assert.assertEquals(5, countOfReg + countOfUnreg);


        LOGGER.info(" Close internet browser");
        baseFunctions.closeBrowser();

    }

}

