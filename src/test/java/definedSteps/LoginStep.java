package definedSteps;

import Base.BaseStep;
import Base.ImpliciExplictwaits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginStep extends BaseStep {

    private static WebDriverWait wait;

    @Given("that the user enters incorrect information")
    public void thatTheUserEntersIncorrectInformation() throws Throwable {
        initializeTestBase();
        getWebDriver();
    }

    @When("^click the Login button$")
    public void clickTheLoginButton() {
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
}
