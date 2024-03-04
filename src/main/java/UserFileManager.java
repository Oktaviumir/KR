import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class UserFileManager {
    public static void writeFile(UserData userData) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userData.getLastName() + ".txt", true))) {
            bufferedWriter.write(userData.toString() + System.lineSeparator());
        }
    }
}