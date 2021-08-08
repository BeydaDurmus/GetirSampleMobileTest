package mobile.pages;

import mobile.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage extends BaseTest {

    public List<WebElement> removeBasket(){
        List<WebElement> basket= driver.findElements(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/recyclerview']//*[@resource-id='com.allandroidprojects.getirsample:id/layout_action1']"));
        System.out.println("***"+basket.size());
        if(basket.size()>0)
        {
            for(int i =0 ;i<basket.size();i++)
            {
                //String xpath=String.format("//*[@resource-id='com.allandroidprojects.getirsample:id/recyclerview']//*[@resource-id='com.allandroidprojects.getirsample:id/layout_action1[%d]",i);
                WebElement basketItem=driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/recyclerview']//*[@resource-id='com.allandroidprojects.getirsample:id/layout_action1']"));
                basketItem.click();
            }
        }

        List<WebElement> basketControl= driver.findElements(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/recyclerview']//*[@resource-id='com.allandroidprojects.getirsample:id/layout_action1']"));

        return basketControl;
    }
}
