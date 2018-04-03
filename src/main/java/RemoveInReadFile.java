import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemoveInReadFile {

    public static void removeInReadFile () {

        try {
            Scanner scanner = new Scanner(new File("course list.csv"));

            while(scanner.hasNext())
            {
                String line = scanner.next();
                String lineAfterTrim = line.trim();
                System.out.print(lineAfterTrim);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}