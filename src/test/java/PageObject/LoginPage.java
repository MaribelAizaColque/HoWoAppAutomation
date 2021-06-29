package PageObject;

import Common.DriverClass;
import Common.Elements;
import Common.ImpliciExplictwaits;
import Common.TypeElement;
import Locations.LoginLocation;
import Locations.RegisterLocation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean existElement() {
        boolean result=false;
        WebElement element= Elements.GetElement(TypeElement.CSSSELECTOR, LoginLocation.titleHoWo1,driver);
        if(element.isDisplayed()==true){
            result=true;
        }
        return result;
    }

    public void clickLogin() {
        WebElement register= Elements.GetElement(TypeElement.CSSSELECTOR, LoginLocation.loginbutton,driver);
        register.sendKeys(Keys.ENTER);
        ImpliciExplictwaits.Implicitwait(DriverClass.driver);
    }

    public void enterEmail(String email) {
        WebElement usernameEle= Elements.GetElement(TypeElement.CSSSELECTOR, LoginLocation.email,driver);
        usernameEle.sendKeys(email);
    }

    public void enterPassword(String passwordLogin) {
        WebElement usernameEle= Elements.GetElement(TypeElement.CSSSELECTOR, LoginLocation.password,driver);
        usernameEle.sendKeys(passwordLogin);
    }

    public void click() {
        WebElement submit= Elements.GetElement(TypeElement.CSSSELECTOR, LoginLocation.login,driver);
        submit.click();
        ImpliciExplictwaits.Implicitwait(DriverClass.driver);
    }

    public void verifyWarningMessage() {
        WebElement messageEle= Elements.GetElement(TypeElement.CSSSELECTOR, LoginLocation.message,driver);
        Assert.assertTrue(messageEle.isDisplayed());
    }
}
