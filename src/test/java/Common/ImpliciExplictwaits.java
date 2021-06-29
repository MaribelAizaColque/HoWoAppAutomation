package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Marisol on 19/10/2018.
 */
public class ImpliciExplictwaits {
   static WebDriverWait wait;

    public static void Expliciwait(WebDriver driver, WebElement element){
        (new WebDriverWait(driver,3000)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void Implicitwait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
    }
    public static void waitForElementEnabled(WebElement element,WebDriver driver) {

       new WebDriverWait(driver, 5000).until((ExpectedCondition<Boolean>) drivers -> element.isEnabled());
    }
    public static void waitPresence(By element, WebDriver driver){
        wait = new WebDriverWait(driver, 50000);

        wait.until(ExpectedConditions.presenceOfElementLocated(element));

    }
    public static void waituntillvisibility(WebElement element,WebDriver driver){
        wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitSeconds(WebDriver driver, int second){

        synchronized(driver){
            try {
                driver.wait(second * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}