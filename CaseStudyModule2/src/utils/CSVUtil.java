package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {
    public static List<String> read(String filePath) {
        List<String> fileData = new ArrayList<>();
        String temp;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((temp = bufferedReader.readLine()) != null && !temp.trim().isEmpty()) fileData.add(temp);
        } catch (IOException e) {

        }
        return fileData;
    }

    public static <Type> void write(String filePath, List<Type> fileData) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Object temp : fileData) bufferedWriter.write(temp.toString() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {

        }
    }

}
