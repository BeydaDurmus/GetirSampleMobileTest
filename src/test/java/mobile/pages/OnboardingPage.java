package mobile.pages;

import mobile.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OnboardingPage extends BaseTest {

    public boolean openApp(){
        Boolean onboardingScreen= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/view_pager']//android.widget.RelativeLayout/android.widget.LinearLayout//*[contains(@text,'Hello Food')]"))).isDisplayed();

        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.allandroidprojects.getirsample:id/btn_skip")));
        //WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.allandroidprojects.getirsample:id/btn_skip")));
        item.click();
        return onboardingScreen;
    }
}
