import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "alahu.exe";
        byte[] inputBytes;
        long startTime;
        long endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));

            startTime = System.currentTimeMillis();

            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }

            endTime = System.currentTimeMillis();

            System.out.println("Length: " + outputString.length());
            System.out.println("Time using String + : " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Cannot read file: " + filename);
            e.printStackTrace();
        }
    }
}