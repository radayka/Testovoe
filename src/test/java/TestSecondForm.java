
import PageObject.SecondPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

public class TestSecondForm {
    static SecondPage secondPage;

    @RunWith(Parameterized.class)
    public static class checkForm extends BaseTest {

        private final String email;
        private final String name;

        public checkForm(String email, String name) {
            this.email = email;
            this.name = name;
        }

        @Parameterized.Parameters
        public static Object[][] getData() {
            return new Object[][]{
                    {"test@mail.ru", "Макс"},
                    {"test@gmail.com", ""},
                    {"test@gmail.com", " "},
                    {" ", "Ник"},
                    {" ", " "},
            };

        }

        @Test
        public void formTest() {
            //Проход через авторизацию
            webDriver.findElement(By.id("loginEmail")).click();
            webDriver.findElement(By.id("loginEmail")).sendKeys("test@protei.ru");
            webDriver.findElement(By.id("loginPassword")).click();
            webDriver.findElement(By.id("loginPassword")).sendKeys("test");
            webDriver.findElement(By.id("authButton")).click();
            //Тестирование анкеты
            secondPage = new SecondPage(webDriver);
            secondPage.clickEmailField();
            secondPage.fillEmailField(email);
            secondPage.clickNameField();
            secondPage.fillNameField(name);
            secondPage.clickGenderField();
            secondPage.clickGenderMan();
            secondPage.clickCheckbox1_1();
            secondPage.clickCheckbox1_2();
            secondPage.clickRadio2_1();
            secondPage.clickDataSendButton();
            secondPage.clickOkButton();
            secondPage.checkSuccessfulSendData(email);
        }
    }
}
