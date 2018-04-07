import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class StartProgramTest {

   private StartProgram startProgram;

    @Before
    public void setUp () {
        System.out.println("BeforeTest");
        startProgram = new StartProgram();
    }

    @After
    public void tearDown (){
        System.out.println("AfterTest");
    }
    
    @Test
    public void testOrUsersFileWasCreated () {
        File file = new File("usersFile.csv");
        Assert.assertTrue(file.exists());
        System.out.println("usersFile - yra sukurtas!");
    }

    @Test
    public void testOrCourseListFileWasCreated () {
        File file = new File("courseListFile.csv");
        Assert.assertTrue(file.exists());
        System.out.println("courseListFile - yra sukurtas!");
    }

    @Test
    public void testOrStudentsInCourseFileWasCreated() {
        File file = new File("studentsInCourseFile.csv");
        Assert.assertTrue(file.exists());
        System.out.println("studentsInCourseFile - yra sukurtas!");
    }
}