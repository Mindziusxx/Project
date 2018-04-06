import java.util.Scanner;

public class ScannerUtils {

    public static String scannerForWord() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

    public static int scannerForNumber() {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        return input1;
    }
}
