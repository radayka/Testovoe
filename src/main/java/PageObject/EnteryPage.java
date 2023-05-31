package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class EnteryPage {
    WebDriver webDriver;

    public EnteryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By emailField = By.id("loginEmail");
    private By passwrodField = By.id("loginPassword");
    private By enterButton = By.id("authButton");
    private By forCheck = By.xpath("/html/body/div[2]/form/div[4]/label");

    public void clickEmailField() {
        webDriver.findElement(emailField).click();
    }

    public void fillEmailField(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void clickPasswordField() {
        webDriver.findElement(passwrodField).click();
    }

    public void fillPasswordField(String password) {
        webDriver.findElement(passwrodField).sendKeys(password);
    }

    public void clickEnterButton() {
        webDriver.findElement(enterButton).click();
    }

    public void checkSuccessfulLogin() {
        assertTrue(webDriver.findElement(forCheck).isDisplayed());
    }
}
