package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class SecondPage {
    WebDriver webDriver;

    public SecondPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By emailField = By.id("dataEmail");
    private By nameField = By.id("dataName");
    private By genderField = By.id("dataGender");
    private By genderMan = By.xpath("/html/body/div[2]/form/div[4]/select/option[1]");
    private By genderWoman = By.xpath("/html/body/div[2]/form/div[4]/select/option[2]");
    private By checkbox1_1 = By.id("dataCheck11");
    private By checkbox1_2 = By.id("dataCheck12");
    private By radio2_1 = By.id("dataSelect21");
    private By radio2_2 = By.id("dataSelect22");
    private By radio2_3 = By.id("dataSelect23");
    private By dataSendButton = By.id("dataSend");
    private By okButton = By.xpath("/html/body/div[3]/div/div/div[2]/button");

    public void clickEmailField() {
        webDriver.findElement(emailField).click();
    }

    public void fillEmailField(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void clickNameField() {
        webDriver.findElement(nameField).click();
    }

    public void fillNameField(String name) {
        webDriver.findElement(nameField).sendKeys(name);
    }

    public void clickGenderField() {
        webDriver.findElement(genderField).click();
    }

    public void clickGenderMan() {
        webDriver.findElement(genderMan).click();
    }

    public void clickGenderWoman() {
        webDriver.findElement(genderWoman).click();
    }

    public void clickCheckbox1_1() {
        webDriver.findElement(checkbox1_1).click();
    }

    public void clickCheckbox1_2() {
        webDriver.findElement(checkbox1_2).click();
    }

    public void clickRadio2_1() {
        webDriver.findElement(radio2_1).click();
    }

    public void clickRadio2_2() {
        webDriver.findElement(radio2_2).click();
    }

    public void clickRadio2_3() {
        webDriver.findElement(radio2_3).click();
    }

    public void clickDataSendButton() {
        webDriver.findElement(dataSendButton).click();
    }

    public void clickOkButton() {
        webDriver.findElement(okButton).click();
    }

    public void checkSuccessfulSendData(String email) {
        assertEquals(email, webDriver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td[1]")).getText());
    }
}
