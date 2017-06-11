package NewsPortalDelfi;


import org.openqa.selenium.By;


public class CommentPage {
    private static final By LOAD_BTN = By.xpath("//a[contains(@class, 'load-more-comments-btn-link')]");
    private static final By UNREGISTERED_BTN = By.xpath("//*[contains(@class, 'comment-thread-switcher-list-a-anon')]");
    private static final By COUNT_OF_UNREGISTERED = By.xpath("//div[contains(@class, 'comment-post-full-content')]");
    private static final By COUNT_OF_REGISTERED = By.xpath("//div[contains(@class, 'comment-avatar-registered')]");


    BaseFunctions baseFunctions;

    public CommentPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public int registeredCommentsCount() {
        int regComments = baseFunctions.findElements(COUNT_OF_REGISTERED).size();
        System.out.println(regComments);
        return regComments;
    }

    public void openUnregisteredComments() {
        baseFunctions.click(UNREGISTERED_BTN);
    }

    public int unregisteredCommentsCount() {
        baseFunctions.isPresentElement(LOAD_BTN);
        baseFunctions.pause(300);
        int unregComments = baseFunctions.findElements(COUNT_OF_UNREGISTERED).size();

        System.out.println(unregComments);
        return unregComments;
    }


}
