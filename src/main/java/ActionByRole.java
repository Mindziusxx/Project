import java.io.BufferedWriter;
import java.io.FileWriter;

public class ActionByRole extends MenuByRole {


    public static void registerNewUser() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt"))
        ) {

            System.out.println("Įveskite username:");
            String user = scanner();
            System.out.println("Įveskite password:");
            String password = scanner();
            bufferedWriter.write(user + "," + password);
            System.out.println("Naujas vartotojas sukurtas sėkmingai!");


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}