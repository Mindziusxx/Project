package users;

import login.Login;
import menu.Menu;
import scanner.ScannerUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInformation {

    public static void changeUserInformation() throws IOException {

        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("usersFile.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[4].equals(Login.getCurrentUser().getUserName())) {
                    List<String> splited = Arrays.asList(line.split(","));

                    System.out.println("------------------------------------");
                    System.out.println("Norite įvesti/pakeisti vardą? (Y/N)");
                    System.out.println("------------------------------------");
                    String answer2 = ScannerUtils.scannerForWord();

                    if (answer2.equals("Y") || answer2.equals("y")) {
                        System.out.println("\nĮveskite naują vardą: ");
                        String firstName = ScannerUtils.scannerForWord();
                        splited.set(1, firstName);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(firstName);
                    }

                    System.out.println("--------------------------------------");
                    System.out.println("Norite įvesti/pakeisti pavardę? (Y/N)");
                    System.out.println("--------------------------------------");
                    String answer3 = ScannerUtils.scannerForWord();

                    if (answer3.equals("Y") || answer3.equals("y")) {
                        System.out.println("\nĮveskite naują pavardę: ");
                        String secondName = ScannerUtils.scannerForWord();
                        splited.set(2, secondName);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(secondName);
                    }

                    System.out.println("--------------------------------------");
                    System.out.println("Norite pakeisti slaptažodį? (Y/N)");
                    System.out.println("--------------------------------------");
                    String answer4 = ScannerUtils.scannerForWord();

                    if (answer4.equals("Y") || answer4.equals("y")) {
                        System.out.println("\nĮveskite naują slaptažodį: ");
                        String password = ScannerUtils.scannerForWord();
                        splited.set(3, password);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(password);
                    }

                    System.out.println("---------------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti namų telefono numerį? (Y/N)");
                    System.out.println("---------------------------------------------------");
                    String answer5 = ScannerUtils.scannerForWord();

                    if (answer5.equals("Y") || answer5.equals("y")) {
                        System.out.println("\nĮveskite naują telefono numerį: ");
                        String phoneNumber = ScannerUtils.scannerForWord();
                        splited.set(6, phoneNumber);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(phoneNumber);
                    }

                    System.out.println("------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti gimimo datą? (Y/N)");
                    System.out.println("------------------------------------------");
                    String answer6 = ScannerUtils.scannerForWord();

                    if (answer6.equals("Y") || answer6.equals("y")) {
                        System.out.println("\nĮveskite gimimo datą: ");
                        String dateOfBirth = ScannerUtils.scannerForWord();
                        splited.set(7, dateOfBirth);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(dateOfBirth);
                    }

                    System.out.println("-------------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti elektroninį paštą? (Y/N)");
                    System.out.println("-------------------------------------------------");
                    String answer7 = ScannerUtils.scannerForWord();

                    if (answer7.equals("Y") || answer7.equals("y")) {
                        System.out.println("\nĮveskite elektroninį paštą: ");
                        String email = ScannerUtils.scannerForWord();
                        splited.set(8, email);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(email);
                    }

                    System.out.println("--------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti mobilų numerį? (Y/N)");
                    System.out.println("--------------------------------------------");
                    String answer8 = ScannerUtils.scannerForWord();

                    if (answer8.equals("Y") || answer8.equals("y")) {
                        System.out.println("\nĮveskite mobilų numerį: ");
                        String mobileNumber = ScannerUtils.scannerForWord();
                        splited.set(9, mobileNumber);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(mobileNumber);
                    }

                    System.out.println("------------------------------------------");
                    System.out.println("Norite įvesti/pakeisti savo adresą? (Y/N)");
                    System.out.println("------------------------------------------");
                    String answer9 = ScannerUtils.scannerForWord();

                    if (answer9.equals("Y") || answer9.equals("y")) {
                        System.out.println("\nĮveskite adresą: ");
                        String address = ScannerUtils.scannerForWord();
                        splited.set(11, address);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(address);
                    }

                    System.out.println("------------------------------------------");
                    System.out.println("Norite įvesti lytį? (Y/N)");
                    System.out.println("------------------------------------------");
                    String answer10 = ScannerUtils.scannerForWord();

                    if (answer10.equals("Y") || answer10.equals("y")) {
                        System.out.println("\nĮveskite lytį (vyr./mot.): ");
                        String gender = ScannerUtils.scannerForWord();
                        splited.set(10, gender);
                        line = splited.stream().collect(Collectors.joining(","));
                        Login.getCurrentUser().setFirstName(gender);
                    }
                }
                userStgrings.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile))
        ) {
            for (String line : userStgrings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nJūsų duomenys atnaujinti!");
        Menu.menuForAllRolesValidation();
    }

    public static void getUserInformation() throws IOException {

        System.out.println("--------------");
        System.out.println("Jūsų duomenys:");
        System.out.println("--------------");

        try (
                BufferedReader in = new BufferedReader(new FileReader("usersFile.csv"))
        ) {
            String read = null;
            in.readLine();

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if (Login.getCurrentUser().getUserName().equals(splited[4])) {
                    for (int i = 1; i < splited.length; i++) {
                    }
                    System.out.println("Vardas: " + splited[1] + "\nPavardė: " + splited[2] + "\nVartotojo vardas: " +
                            splited[4] + "\nAsmeninis numeris: " + splited[6] + "\nGimimo diena: " + splited[7]
                            + "\nElektroninis paštas: " + splited[8] + "\nMobilus numeris: " + splited[9] + "\nLytis: "
                            + splited[10]+ "\nAdresas: " + splited[11]);
                    break;
                } else {
                }
            }
            Menu.menuForAllRolesValidation();
        } catch (Exception e) {
            System.out.println("getUserInformation" + e);
        }
    }
}
