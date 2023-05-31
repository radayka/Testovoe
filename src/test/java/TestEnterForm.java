import PageObject.EnteryPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class TestEnterForm {
    static EnteryPage enteryPage;

    @RunWith(Parameterized.class)
    public static class checkForm extends BaseTest {
        private final String email;
        private final String password;

        public checkForm(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Parameterized.Parameters
        public static Object[][] getData() {
            return new Object[][]{
                    {"test@protei.ru", "test"},
                    {" ", "text"},
                    {"test@protei.ru", " "},
                    {"  ", "  "},
                    {"", ""},
            };
        }

        @Test
        public void formTest() {
            enteryPage = new EnteryPage(webDriver);
            enteryPage.clickEmailField();
            enteryPage.fillEmailField(email);
            enteryPage.clickPasswordField();
            enteryPage.fillPasswordField(password);
            enteryPage.clickEnterButton();
            enteryPage.checkSuccessfulLogin();
        }
    }
}
