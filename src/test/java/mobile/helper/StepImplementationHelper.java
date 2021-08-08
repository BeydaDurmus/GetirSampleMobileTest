package mobile.helper;

import com.thoughtworks.gauge.Step;
import mobile.BaseTest;
import mobile.pages.BasketPage;
import mobile.pages.HomePage;
import mobile.pages.OnboardingPage;
import mobile.pages.ProductDetailPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepImplementationHelper extends BaseTest {

    HomePage homapage= new HomePage();
    OnboardingPage onboardingPage = new OnboardingPage();
    ProductDetailPage detailPage= new ProductDetailPage();
    BasketPage basketPage= new BasketPage();

   /* @Step("Check onboarding screen")
    public void openApp(){
        Boolean onboardingScreen= driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/view_pager']//android.widget.RelativeLayout/android.widget.LinearLayout//*[contains(@text,'Hello Food')]")).isDisplayed();
        Assert.assertTrue(onboardingScreen);
        WebElement item = driver.findElement(By.id("com.allandroidprojects.getirsample:id/btn_skip"));
        //WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.allandroidprojects.getirsample:id/btn_skip")));
        item.click();
    }
    @Step("Check home page screen")
    public void checkHomePageScreen(){
        WebElement title = driver.findElement(By.xpath("//*[@resource-id='com.allandroidprojects.getirsample:id/toolbar']//android.widget.TextView[@text='GetirSample']"));
        System.out.println("Title"+title.getText());
        Assert.assertEquals("GetirSample",title.getText());
    }*/


    @Step("Check onboarding screen")
    public void openApp(){
        Boolean onboardingScreen= onboardingPage.openApp();
        Assert.assertTrue(onboardingScreen);
    }

    @Step("Check home page screen")
    public void checkHomePageScreen(){
        String title=homapage.checkHomePageScreen();
        Assert.assertEquals("GetirSample",title);
    }

    @Step("Click <category> from <location> ")
    public void clickCategory(String category,String location){
        homapage.clickCategory(category,location);
    }

    @Step("Open the menu")
    public void openMenu(){
        homapage.openMenu();
    }
    @Step("Back to page")
    public void backPage(){
        driver.navigate().back();
    }

    @Step("Control <category> Page Existence")
    public void pageExistence(String category){
        String pageName=homapage.pageExistence(category);
        Assert.assertEquals(category,pageName);
    }

    @Step("Open <index> product detail")
    public void openProductDetail(int index){
        detailPage.openProductDetail(index);

    }
    @Step("Add to Cart product")
    public void addToCart()
    {
        String waterTab=detailPage.addToCart();
        Assert.assertEquals("Water",waterTab);
    }

    @Step("Go to the cart")
    public void goToBasket(){
       homapage.goToBasket();
    }

    @Step("Remove item from the Basket")
    public void removeBasket(){
       // List<WebElement> basketControl=basketPage.removeBasket();
        WebElement basketTotal=basketPage.removeBasket();
        //Assert.assertEquals(0,basketControl.size());
        Assert.assertEquals("$0.00",basketTotal.getText());

    }

    @Step("Check price of the product")
    public void checkProduct(){
        String price= detailPage.checkProduct();
        Assert.assertEquals("$1,98",price);
    }

}
