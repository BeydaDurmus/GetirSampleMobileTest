import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepImplementation extends BaseTest {

    @Step("Go to GetirSample App")
    public void goApp() throws InterruptedException{
        //TimeUnit.SECONDS.sleep(10);
        WebElement item = driver.findElement(By.id("com.allandroidprojects.getirsample:id/btn_skip"));
        //WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.allandroidprojects.getirsample:id/btn_skip")));
        item.click();
        WebElement title = driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/toolbar']//android.widget.TextView[@text='GetirSample']"));
        System.out.println("Title"+title.getText());
        Assert.assertEquals("GetirSample",title.getText());
    }

    @Step("Change category to <category>")
    public void changeCategory(String category)
    {
        driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/tabs']//*[@content-desc='"+category+"']")).click();
    }

    @Step("Open <index> product detail")
    public void openProductDetail(int index){
        driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/cardview']["+index+"]")).click();

    }
    @Step("Add to Cart product")
    public void addToCart()
    {
        WebElement addToCart= driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/activity_item_details']//android.widget.LinearLayout//*[@text='ADD TO CART']"));
        addToCart.click();
        driver.navigate().back();
        WebElement waterTab= driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/tabs']//*[@content-desc='Water']"));
        System.out.println("Title"+waterTab.getText());
        Assert.assertEquals("Water",waterTab.getAttribute("content-desc"));
    }

    @Step("Go to the cart")
    public void goToBasket(){
        WebElement cart= driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/action_cart']"));
        cart.click();
    }

    @Step("Remove item from the Basket")
    public void removeBasket(){
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

        Assert.assertEquals(0,basketControl.size());
    }

}
