import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.UUID;

public class Actions {

    public static void menuActionsByAdmin() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                Actions.registerNewUser();
                break;
            case 2:
                System.out.println("ats 2");
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsByLecturer() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                System.out.println("ats 1");
                break;
            case 2:
                System.out.println("ats 2");
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsByStudent(String user) {

        switch (ScannerUtils.scanner1()) {
            case 1:
                userinfo(user);
                break;
            case 2:
//                change(user);
//                changeInfo(user);
                break;
            case 3:
                System.out.println("ats 3");
                break;
            case 4:
                System.out.println("ats 4");
                break;
            case 5:
                System.out.println("ats 5");
                break;
            case 6:
                System.out.println("ats 6");
                break;
            default:
                break;
        }
    }

    public static void menuActionsToAll() {

        switch (ScannerUtils.scanner1()) {
            case 1:
                System.out.println("Aprašyti visų Rolių nukreipimą į jų MENU");
                break;
            case 2:
                System.out.println("Jūs išėjote iš programos");
                break;
        }
    }


    public static void registerNewUser() {
        Users users = new Users();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt", true))
        ) {
            System.out.println("Įveskite firstName:");
            users.setFirstName(ScannerUtils.scanner());

            System.out.println("Įveskite secondName:");
            users.setSecondName(ScannerUtils.scanner());

            System.out.println("Įveskite password:");
            users.setPassword(ScannerUtils.scanner());

            System.out.println("Įveskite userName:");
            users.setUserName(ScannerUtils.scanner());

            System.out.println("Įveskite ROLE:");
            String role = ScannerUtils.scanner();

            bufferedWriter.newLine();
            bufferedWriter.write(UUID.randomUUID().toString() + "," + users.getFirstName() + "," + users.getSecondName() + "," + users.getPassword() + "," + users.getUserName() + "," + role);
            System.out.println("Naujas vartotojas sukurtas sėkmingai! \n");

        } catch (Exception e) {
            System.out.println("registerNewUser" + e);
        }
    }


    public static void userinfo(String user) {

        System.out.println("Jūsų duomenys: \n");

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader("login.txt"));
            String read = null;

            while ((read = in.readLine()) != null) {
                String[] splited = read.split(",");

                if ((user.equals(splited[4]))) {
                    for (int i = 0; i < splited.length; i++) {
                        System.out.println(splited[i]);
                    }
                    break;
                } else {
                }
            }
            in.close();
        } catch (Exception e) {
            System.out.println("login" + e);
        }
    }


    ///KEIČIA VISKĄ VIETOJ USER PADUOTOS REIKŠMĖS - NEGERAI, NES REIKIA TIK PAKEISTI ŠIO USERIO INFO, O ČIA JEI SUTAPS VISKĄ KEIČIA...
//    public static void changeNew1(String user) {
//        Users users = new Users();
//
//        try
//        {
//            File file = new File("login.txt");
//
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//
//            String line = "", oldtext = "";
//
//            while ((line = reader.readLine()) != null) {
//
//                String[] splited = line.split(",");
//
//                for (int i = 0; i < splited.length ; i++) {
//                    if (user.equals(splited[4]));
//                }
//            }
//
//            {
//                oldtext += line + "\r\n";
//            }
//            reader.close();
//            // replace a word in a file
//
//            String newtext = oldtext.replace(user, "Love");
//
//            //To replace a line in a file
//            //String newtext = oldtext.replaceAll("This is test string 20000", "blah blah blah");
//
//            FileWriter writer = new FileWriter("file15.txt");
//            writer.write(newtext);writer.close();
//        }
//        catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }
//    }

//
//    public static void changeNew(String user) {
//
//        Users users = new Users();
//
//        BufferedReader in = null;
//
//        try {
//            in = new BufferedReader(new FileReader("login.txt"));
//            String read = null;
//
//            String line = "", oldtext = "";
//
//            while ((read = in.readLine()) != null) {
//
//                oldtext += line + "\r\n";
//
//
//                users.setUserName(user);
//
//                String newtext = oldtext.replace(users.getUserName(), "bandomasis");
//
//                FileWriter writer = new FileWriter("login1.txt");
//                writer.write(newtext);
//                writer.close();
//
//                {
//                }
//            }
//            in.close();
//        } catch (Exception e) {
//            System.out.println("login" + e);
//        }
//    }
}


