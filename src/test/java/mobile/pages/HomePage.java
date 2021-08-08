package mobile.pages;

import mobile.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseTest {

    public boolean openApp(){
        Boolean onboardingScreen= driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/view_pager']//android.widget.RelativeLayout/android.widget.LinearLayout//*[contains(@text,'Hello Food')]")).isDisplayed();

        WebElement item = driver.findElement(By.id("com.allandroidprojects.getirsample:id/btn_skip"));
        //WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.allandroidprojects.getirsample:id/btn_skip")));
        item.click();
        return onboardingScreen;
    }

    public String  checkHomePageScreen(){
        WebElement title = driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/toolbar']//android.widget.TextView[@text='GetirSample']"));
        System.out.println("Title"+title.getText());
        //Assert.assertEquals("GetirSample",title.getText());
        return title.getText();
    }

    public void clickCategory(String category,String location){

        if (location=="menu") {
            driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/nav_view']//android.support.v7.widget.LinearLayoutCompat//android.widget.CheckedTextView[@text='"+category+"']")).click();

        }
        else {
            System.out.println("tabs");
            driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/tabs']//*[@content-desc='"+category+"']")).click();

        }
    }

    public String pageExistence(String category){
        WebElement page= driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/tabs']//*[@content-desc='"+category+"']"));
        return page.getAttribute("content-desc");
    }

    public void openMenu(){
        driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/toolbar']/android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
    }
    public void goToBasket(){
        driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/action_cart']")).click();
    }

}
