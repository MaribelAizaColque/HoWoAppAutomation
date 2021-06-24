package definedSteps;

import Base.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class RegisterStep extends BaseStep {

    private static WebDriverWait wait;

    @Given("that the user can register in HoWo page")
    public void thatTheUserCanRegisterInHoWoPage() {
        geturl();
    }

    @When("^the user click Register button$")
    public void theUserClickDropdown() {
//        findElement("//a[normalize-space()='Registrarse']",Pather.xPath,"60");
//        driver.findElement(By.cssSelector("body > a.btn1")).sendKeys(Keys.ENTER);
        findElementClick("body > a.btn1",Pather.cssSelector);
    }

    @And("^user clicks on the registration item$")
    public void userClicksOnTheRegistrationItem() {
        findElementClick("register",Pather.id);
    }

    @Then("user sees the register form")
    public void userSeesTheRegisterForm() {
        waitElement(findElement("titulo1",Pather.id,"Registrarse"),TimeOut.LOW);
    }

    @And("user enters  (.*)$")
    public void userEntersFullName(String fullName) {
        //        PageScrolldown();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        findElement("name1",Pather.id,"").sendKeys(fullName);
//        Assert.assertTrue();
    }

    @And("^user enters his (.*)$")
    public void userEntersHisEmail(String email) {
        findElement("correo",Pather.id,"").sendKeys( email);

    }

    @And("^user enters the (.*)")
    public void userEntersThePassword(String passwd) {
        findElement("contrasenia",Pather.id,"").sendKeys(passwd);
    }

    @And("^user enters repeat (.*)")
    public void userEnterRepeatPassword(String rpsswd) {
        findElement("contrasenia2",Pather.id,"").sendKeys(rpsswd);
    }

    @And("^user click register button$")
    public void userClickSubmitButton() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        findElementClick("enviar",Pather.id);
        PageScrolldown();

    }

    @And("verify that  display the success message")
    public void verifyThatDisplayTheSuccessMessage() {

        Assert.assertTrue(findElement("enviado",Pather.id,"").isDisplayed(),"El mensaje no se esta mostrando");
    }

    @And("^driver close$")
    public void driverClose() {
        DriverQuit();
    }

}
