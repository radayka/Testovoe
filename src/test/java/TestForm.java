import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class TestForm {

    @RunWith(Parameterized.class)
    public static class checkForm extends BaseTest {
        private final String loginEmail;
        private final String password;
        private final String ancetaLogin;
        private final String name;

        public checkForm(String loginEmail, String password, String ancetaLogin, String name) {
            this.loginEmail = loginEmail;
            this.password = password;
            this.ancetaLogin = ancetaLogin;
            this.name = name;
        }

        @Parameterized.Parameters
        public static Object[][] getData() {
            return new Object[][]{
                    {"test@protei.ru", "test", "212@gmail.com", "Макс"},
                    {"test@protei.ru", "test", "212@bk.ru", "Никита"},
                    {"test@protei.ru", "text", "2ew@mail.ru", "Илья"},
                    {"shmest@protei.ru", "test", "ew3@yanex.ru", "Maks"},
                    {"  ", "  ", "  ", "   "},
            };
        }

        @Test
        public void formTest() {
            webDriver.findElement(By.xpath("/html/body/div[1]/form/div[2]/input")).click();
            webDriver.findElement(By.xpath("/html/body/div[1]/form/div[2]/input")).sendKeys(loginEmail);
            webDriver.findElement(By.xpath("/html/body/div[1]/form/div[3]/input")).click();
            webDriver.findElement(By.xpath("/html/body/div[1]/form/div[3]/input")).sendKeys(password);
            webDriver.findElement(By.xpath("/html/body/div[1]/form/div[4]/button")).click();
            assertTrue(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[4]/label")).isDisplayed());

            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[2]/input")).click();
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[2]/input")).sendKeys(ancetaLogin);
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).click();
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).sendKeys(name);
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[4]/select")).click();
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[4]/select/option[1]")).click();
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[6]/input")).click();
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[8]/input")).click();
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[10]/button")).click();
            assertTrue(webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/button")).isEnabled());
        }
    }
}
