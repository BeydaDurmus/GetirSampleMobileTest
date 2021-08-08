package mobile.pages;

import mobile.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasketPage extends BaseTest {

    public WebElement removeBasket(){
        List<WebElement> basket= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/recyclerview']//*[@resource-id='com.allandroidprojects.getirsample:id/layout_action1']")));
        System.out.println("***"+basket.size());
        if(basket.size()>0)
        {
            for(int i =0 ;i<basket.size();i++)
            {
                WebElement basketItem=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/recyclerview']//*[@resource-id='com.allandroidprojects.getirsample:id/layout_action1']")));
                basketItem.click();
            }
        }
        //List<WebElement> basketControl=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/recyclerview']//*[@resource-id='com.allandroidprojects.getirsample:id/layout_action1']")));
        //return basketControl;
        WebElement basketTotal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/activity_cart_list']//android.widget.TextView[@resource-id='com.allandroidprojects.getirsample:id/text_action_bottom1']")));
        return basketTotal;
    }

    public WebElement controlBasketTotal(){
        WebElement basketTotal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/activity_cart_list']//android.widget.TextView[@resource-id='com.allandroidprojects.getirsample:id/text_action_bottom1']")));
        return basketTotal;
    }
}
