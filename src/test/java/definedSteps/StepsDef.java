package definedSteps;

import Base.BaseStep;
import Common.DriverClass;
import PageObject.LoginPage;
import PageObject.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class StepsDef extends BaseStep {
    private RegisterPage registerPage;
    private LoginPage loginPage;

    @Given("user enters to Howo page")
    public void userEntersToHoWoPage() throws Throwable{
        initializeTestBase();
        getWebDriver();

    }

    @When("^the user click Register button$")
    public void theUserClickDropdown() throws Throwable{
        registerPage = new RegisterPage(DriverClass.driver);
        if(registerPage.existElement()==true){
         registerPage.clickRegister();
        }
    }

    @Then("user enters  (.*)$")
    public void userEntersFullName(String fullName) {
        if(registerPage.existTitleReg()==true){
            registerPage.enterUsername(fullName);
        }

    }

    @And("user enters his (.*)$")
    public void userEntersHisEmail(String email) {
        registerPage.enterEmail(email);
    }

    @And("user enters the (.*)$")
    public void userEntersThePassword(String passw) {
        registerPage.enterPassword(passw);
    }

    @And("user enters repeat (.*)$")
    public void userEntersRepeatPassword(String passwd2) {
        registerPage.enterRepeatPasswd(passwd2);
    }

    @And("user click register button")
    public void userClickRegisterButton() {
        registerPage.PageScrolldown();
        registerPage.click();

    }

    @And("verify that  display the success message")
    public void verifyThatDisplayTheSuccessMessage() {
        registerPage.verifyMessage();
    }

    @When("the user click login button")
    public void theUserClickLoginButton() {
        loginPage = new LoginPage(DriverClass.driver);
        if(loginPage.existElement()==true){
            loginPage.clickLogin();
        }
    }

    @Then("the user enters (.*)$")
    public void theUserEntersEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("enter your (.*)$")
    public void enterYourPassword(String passwordLogin) {
        loginPage.enterPassword(passwordLogin);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.click();
    }

    @And("verify that  display the warning message")
    public void verifyThatDisplayTheWarningMessage() {
        loginPage.verifyWarningMessage();
    }
}
