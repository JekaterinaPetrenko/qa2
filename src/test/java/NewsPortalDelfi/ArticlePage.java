package NewsPortalDelfi;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * Created by Master on 16.05.2017..
 */
public class ArticlePage {

    private static final By COUNTER = By.xpath("//*[contains(@class, 'comment-add-form-listing-url-registered')]");
    BaseFunctions baseFunctions;

    public ArticlePage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void openCommentPage ()

    {
        baseFunctions.waitForElement(COUNTER, 500);
        baseFunctions.click(COUNTER);
    }
}
