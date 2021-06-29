package PageObject;

import Common.DriverClass;
import Common.Elements;
import Common.ImpliciExplictwaits;
import Common.TypeElement;
import Locations.RegisterLocation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegister(){
        WebElement register= Elements.GetElement(TypeElement.CSSSELECTOR, RegisterLocation.register,driver);
        register.sendKeys(Keys.ENTER);
        ImpliciExplictwaits.Implicitwait(DriverClass.driver);

    }
    public void enterUsername(String username){
        WebElement usernameEle= Elements.GetElement(TypeElement.CSSSELECTOR, RegisterLocation.username,driver);
        usernameEle.sendKeys(username);

    }
    public void enterPassword(String password){
        WebElement passwordEle= Elements.GetElement(TypeElement.CSSSELECTOR, RegisterLocation.password,driver);
        passwordEle.sendKeys(password);

    }
    public void click(){
        WebElement submit= Elements.GetElement(TypeElement.CSSSELECTOR, RegisterLocation.submit,driver);
        submit.click();
        ImpliciExplictwaits.Implicitwait(DriverClass.driver);

    }

    public boolean existElement() {
        boolean result=false;
        WebElement element= Elements.GetElement(TypeElement.CSSSELECTOR,RegisterLocation.titleHoWo,driver);
        if(element.isDisplayed()==true){
            result=true;
        }
        return result;
    }
    public boolean existTitleReg() {
        boolean result=false;
        WebElement element= Elements.GetElement(TypeElement.CSSSELECTOR,RegisterLocation.registerLabel,driver);
        if(element.isDisplayed()==true){
            result=true;
        }
        return result;
    }

    public void enterEmail(String email) {
        WebElement usernameEle= Elements.GetElement(TypeElement.CSSSELECTOR, RegisterLocation.email,driver);
        usernameEle.sendKeys(email);
    }

    public void enterRepeatPasswd(String passwd) {
        WebElement passwordEle= Elements.GetElement(TypeElement.CSSSELECTOR, RegisterLocation.passwd,driver);
        passwordEle.sendKeys(passwd);
    }

    public void verifyMessage() {
        WebElement messageEle= Elements.GetElement(TypeElement.CSSSELECTOR, RegisterLocation.message,driver);
        Assert.assertTrue(messageEle.isDisplayed());
    }

    public void PageScrolldown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)", "");
    }
}
