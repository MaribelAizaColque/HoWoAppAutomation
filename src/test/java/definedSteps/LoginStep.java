package definedSteps;

import Base.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginStep extends BaseStep {

    private static WebDriverWait wait;

    @Given("that the user enters incorrect information")
    public void thatTheUserEntersIncorrectInformation() {
        geturl();
    }

    @When("^click the Login button$")
    public void theUserClickDropdown() {
        findElementClick("body > a.btn2",Pather.cssSelector);
    }

    @And("^user clicks on the login item$")
    public void userClicksOnTheLoginItem() {
        findElementClick("login",Pather.id);
    }

    @Then("the system should display a warning message")
    public void theSystemShouldDisplayAWarningMessage() {
        waitElement(findElement("title1",Pather.id,"Iniciar Sesion"),TimeOut.LOW);
    }


    @And("^user enters his (.*)$")
    public void userEntersHisEmail(String email) {
        findElement("correo",Pather.id,"").sendKeys( email);

    }

    @And("^user enters the (.*)")
    public void userEntersThePassword(String passwd) {
        findElement("contraseña",Pather.id,"").sendKeys(passwd);
    }


    @And("^user click login button$")
    public void userClickSubmitButton() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        findElementClick("iniciar",Pather.id);
        PageScrolldown();

    }

    @And("verify that display the warning message")
    public void verifythatdisplaythewarningmessage() {

        String message = findElement("alerta",Pather.id,"").getText();
        Assert.assertTrue(findElement("alerta",Pather.id,"").isDisplayed(),"El mensaje no se esta mostrando");
    }

    @And("^driver close$")
    public void driverClose() {
        DriverQuit();
    }

}
