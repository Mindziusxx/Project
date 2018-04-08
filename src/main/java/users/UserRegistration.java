package users;

import scanner.ScannerUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.UUID;

public class UserRegistration {
    public static void registerNewUser() {
        Users users = new Users();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("usersFile.csv", true))

        ) {
            System.out.println("----------------------------");
            System.out.println("Naujo vartotojo registracija");
            System.out.println("----------------------------");
            System.out.println("Vardas:");
            users.setFirstName(ScannerUtils.scannerForWord());
            System.out.println("Pavardė:");
            users.setSecondName(ScannerUtils.scannerForWord());
            System.out.println("Slaptažodis:");
            users.setPassword(ScannerUtils.scannerForWord());
            System.out.println("Vartotojo prisijungimo vardas:");
            users.setUserName(ScannerUtils.scannerForWord());
            System.out.println("Vartotojo teisės (student/lecturer):");
            String role = ScannerUtils.scannerForWord();

            bufferedWriter.newLine();
            bufferedWriter.write(UUID.randomUUID().toString() + "," + users.getFirstName() + "," + users.getSecondName()
                    + "," + users.getPassword() + "," + users.getUserName() + "," + role + "," +
                    "neįvestas,neįvesta,neįvestas,neįvestas,neįvesta,neįvestas");

            System.out.println("\nNaujas vartotojas sukurtas sėkmingai!");

        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
    }
}
