import java.util.Scanner;

public class ScannerUtils {

    public static String scannerForWord() {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        return word;
    }

    public static int scannerForNumber() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }
}
