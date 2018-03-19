import java.util.Scanner;

public class Meniu extends ScannerUtils {

    public static void meniuActions() {

            switch (scanner1()) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                default:
                    break;
            }
        }

    public static void printMenu() {
        System.out.println("1. Veiksmas 1");
        System.out.println("2. Veiksmas 2");
        System.out.println("3. Veiksmas 3");
        System.out.println("4. Exit");
        meniuActions();
    }
}
