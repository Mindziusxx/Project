//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//public class Delete {
//
//    public static void deleteLine() {
//
//        List<String> userStgrings = new ArrayList<>();
//
//        File usersFile = new File("course list.csv");
//        try (
//                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
//        ) {
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//
//                if (!line.split(",")[2].equals("minde"))
//
//                userStgrings.add(line);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        try (
//                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile))
//        ) {
//            for (String line : userStgrings) {
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}