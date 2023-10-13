package dev.selenium.utils.filereader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
    public String readFromFileCodeSnippets(String pathToFile) {
        StringBuilder builder = new StringBuilder();
        String text = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFile)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            if (builder.toString().charAt(builder.toString().length() - 1) == '\n') {
                text = builder.toString().replaceAll("\n$", "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

//    private void
}
