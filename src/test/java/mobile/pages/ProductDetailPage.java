package mobile.pages;

import mobile.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BaseTest {

    public void openProductDetail(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/cardview']["+index+"]"))).click();

    }

    public String addToCart()
    {
        WebElement addToCart= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/activity_item_details']//android.widget.LinearLayout//*[@text='ADD TO CART']")));
        addToCart.click();
        driver.navigate().back();
        WebElement waterTab= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/tabs']//*[@content-desc='Water']")));
        System.out.println("Title"+waterTab.getText());
        return waterTab.getAttribute("content-desc");
    }

    public String  checkProduct(){
        WebElement price=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/scrollbar']//android.widget.LinearLayout/android.widget.TextView[contains(@text,'$')]")));
        return price.getText();
    }

}
