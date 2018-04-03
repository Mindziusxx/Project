import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Delete {

    public static void deleteLine () {

        List<String> userStgrings = new ArrayList<>();
        File usersFile = new File("course list.csv");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usersFile));
        ) {
            String line;

            System.out.println("");

            while ((line = bufferedReader.readLine()) != null) {

                if (line.split(",")[2].equals ("asddfs")) {

                    List<String> splited = Arrays.asList(line.split(","));
                    String uname = "";
                    splited.set(0, uname);
                    line = splited.stream().collect(Collectors.joining(""));

                    String fname = "";
                    splited.set(1, fname);
                    line = splited.stream().collect(Collectors.joining(""));

                    String fname1 = "";
                    splited.set(2, fname1);
                    line = splited.stream().collect(Collectors.joining(""));

                    String fname2 = "";
                    splited.set(3, fname2);
                    line = splited.stream().collect(Collectors.joining(""));

                    String fname3 = "";
                    splited.set(4, fname3);
                    line = splited.stream().collect(Collectors.joining(""));

                    String fname4 = "";
                    splited.set(5, fname4);
                    line = splited.stream().collect(Collectors.joining(""));

                    String fname5 = "";
                    splited.set(6, fname5);
                    line = splited.stream().collect(Collectors.joining(""));
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
    }
}