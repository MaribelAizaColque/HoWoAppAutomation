package Common;

import Base.BaseStep;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Elements {
    static WebDriver driver;
    public static WebElement GetElement(TypeElement type, String nameelement, WebDriver drivers){
        driver=drivers;
        WebElement element=null;
        if(type.equals(TypeElement.ID)){
            element=driver.findElement(By.id(nameelement));


        }else{
            if(type.equals(TypeElement.NAME)){
                element=driver.findElement(By.name(nameelement));
            }
            else{
                if(type.equals(TypeElement.CSSSELECTOR)){
                    element=driver.findElement(By.cssSelector(nameelement));
                }else{
                    if(type.equals(TypeElement.BYCLASSNAME)){
                        element=driver.findElement(By.className(nameelement));
                    }else {
                        if(type.equals(TypeElement.XPATH)){
                            element=driver.findElement(By.xpath(nameelement));
                        }
                    }
                }
            }
        }
        return  element;
    }
    public static List<WebElement> GetElements(TypeElement type, String nameelement, WebDriver drivers){
        driver=drivers;
        List<WebElement>elements=null;
        if(type.equals(TypeElement.ID)){
            ImpliciExplictwaits.waitSeconds(driver, 2);
            elements=driver.findElements(By.id(nameelement));

        }else{
            if(type.equals(TypeElement.NAME)){
                elements=driver.findElements(By.name(nameelement));
            }
            else{
                if(type.equals(TypeElement.CSSSELECTOR)){
                    ImpliciExplictwaits.waitSeconds(driver, 2);
                    elements=driver.findElements(By.cssSelector(nameelement));
                }else{
                    if(type.equals(TypeElement.BYCLASSNAME)){
                        elements=driver.findElements(By.className(nameelement));
                    }else {
                        if(type.equals(TypeElement.XPATH)){
                            elements=driver.findElements(By.xpath(nameelement));
                        }else {
                            if(type.equals(TypeElement.TAGNAME)){
                                elements=driver.findElements(By.tagName(nameelement));
                            }
                        }
                    }
                }
            }
        }
        return  elements;
    }

}