import org.junit.After;
import org.junit.Before;

public class LoginTest {
    private Login login;

    @Before
    public void setUp() {
        System.out.println("Before");
        login = new Login();
    }

//    @Test
//    public void given() {
//        login.login();
//        //when
//        boolean result = login...
//        //then
//        Assert.assertEquals(true, result);
//        System.out.println("checkEnterPin OK");
//    }

    @After
    public void tearDown() {
        System.out.println("After");
    }
}