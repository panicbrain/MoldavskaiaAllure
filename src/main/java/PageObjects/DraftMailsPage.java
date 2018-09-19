package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.Screenshoter.takeScreenshot;

public class DraftMailsPage extends BaseAreasPage {
    public DraftMailsPage(WebDriver driver) {
        super(driver);
    }

    private String toLocator = "[data-subject='" + MAIL_SUBJECT + "']";
    private final By LAST_SAVED_DRAFT_LOCATOR = By.cssSelector(toLocator);
    private final static By EMAIL_ADDRESS_INPUT_LOCATOR = By.cssSelector(".js-input[data-original-name=To]");
    private final static By SUBJECT_INPUT_LOCATOR = By.name("Subject");
   // private final static By FRAME_MAIL_BODY_LOCATOR = By.cssSelector(".mceFirst iframe");
 //   private final static By MAIL_BODY_INPUT_LOCATOR = By.cssSelector("#tinymce");

    public NewLetterPage openLastSavedDraft() {
        highlightElement(LAST_SAVED_DRAFT_LOCATOR);
        takeScreenshot();
        unHighlightElement(LAST_SAVED_DRAFT_LOCATOR);
        driver.findElement(LAST_SAVED_DRAFT_LOCATOR).click();
        waitForElementsVisible(EMAIL_ADDRESS_INPUT_LOCATOR);
        waitForElementsVisible(SUBJECT_INPUT_LOCATOR);
        return new NewLetterPage(driver);
    }
}
