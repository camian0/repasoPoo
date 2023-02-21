package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessFile {

    private ArrayList<String> results = new ArrayList<>();
    Upload upload = new Upload();

    public String getResults() {
        String message = "";
        for (String string : results) {
            String[] split = string.split("-");
            message += "Resultados: " + split[0] + ": " + split[1] + "\n";
        }

        return message;
    }

    public void processFile(String path, String word) throws IOException {
        upload.uploadFile(path);
        File file = upload.getFile();

        File[] files = file.listFiles();
        for (File aFile : files) {
            this.readFile(aFile, word);
        }
    }

    public void readFile(File file, String word) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int found = 0;
        String nameFile = file.getName();
        while (line != null) {
            found += searchWords(nameFile, word);
            line = br.readLine();
        }
        results.add(nameFile + "-" + found);
        fr.close();
    }

    public int searchWords(String line, String word) {
        int found = 0;
        line = line.trim();
        String[] split = line.split(" ");
        for (String string : split) {
            if (string.equals(word)) {
                found++;
            }
        }

        return found;
    }

}
