import java.io.BufferedWriter;
        import java.io.FileWriter;

public class StartProgram   {


    ///Čia aprašyti su IF, kad patikrina, jei yra failas su Admin, tai nekuriam naujo, o jei nėra, kuriam... Sukurimas jau yra, reikia check...



    public static void createFile() {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("login.txt"))
        ) {

            bufferedWriter.write("firstName,secondName,password,userName,role,personalNumber,dateOfBirth,email,mobileNumber,gender,address,runningCourses");
            bufferedWriter.newLine();
            bufferedWriter.write(",,admin,admin");

        } catch (Exception e) {
            System.out.println("createFile" + e);
        }
    }
}


