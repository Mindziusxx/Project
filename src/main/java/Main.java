import java.io.BufferedWriter;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt"))
        ) {
            bufferedWriter.write("admin, admin");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
