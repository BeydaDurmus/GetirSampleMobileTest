package mobile.pages;

import mobile.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseTest {


    public String  checkHomePageScreen(){
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/toolbar']//android.widget.TextView[@text='GetirSample']")));
        System.out.println("Title"+title.getText());
        //Assert.assertEquals("GetirSample",title.getText());
        return title.getText();
    }

    public void clickCategory(String category,String location){

        if (location=="menu") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/nav_view']//android.support.v7.widget.LinearLayoutCompat//android.widget.CheckedTextView[@text='"+category+"']"))).click();

        }
        else {
            System.out.println("tabs");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/tabs']//*[@content-desc='"+category+"']"))).click();

        }
    }

    public String pageExistence(String category){
        WebElement page= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/tabs']//*[@content-desc='"+category+"']")));
        return page.getAttribute("content-desc");
    }

    public void openMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/toolbar']/android.widget.ImageButton[@content-desc='Open navigation drawer']"))).click();
    }
    public void goToBasket(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/action_cart']"))).click();
    }

}
