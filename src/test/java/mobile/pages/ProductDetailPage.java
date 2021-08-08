package mobile.pages;

import mobile.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BaseTest {

    public void openProductDetail(int index){
        driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/cardview']["+index+"]")).click();

    }

    public String addToCart()
    {
        WebElement addToCart= driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/activity_item_details']//android.widget.LinearLayout//*[@text='ADD TO CART']"));
        addToCart.click();
        driver.navigate().back();
        WebElement waterTab= driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/tabs']//*[@content-desc='Water']"));
        System.out.println("Title"+waterTab.getText());
        return waterTab.getAttribute("content-desc");
    }

    public String  checkProduct(){
        WebElement price=driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/scrollbar']//android.widget.LinearLayout/android.widget.TextView[contains(@text,'$')]"));
        return price.getText();
    }

}
