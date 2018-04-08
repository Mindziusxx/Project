import org.junit.Assert;
import org.junit.Test;
import users.Users;

public class UsersTest {

    Users users = new Users();

    @Test
    public void testGetterUseName() {
        final String userName = "admin";
        users.setUserName("admin");
        Assert.assertEquals(users.getUserName(), userName);
        System.out.println("getUserName Tested");
    }

    @Test
    public void testGetterFirstName() {
        final String firstName = "admin";
        users.setFirstName("admin");
        Assert.assertEquals(users.getFirstName(), firstName);
        System.out.println("getFirstName Tested");
    }
}