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
        short total = 0;
        for (String string : results) {
            String[] split = string.split("-");
            total += Integer.parseInt(split[1]);
            message += "Resultados: " + split[0] + ": " + split[1] + "\n";
        }
        message += "\n Total: " + total;
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
        short found = 0;
        String nameFile = file.getName();
        while (line != null) {
            found += searchWords(line, word);
            line = br.readLine();
        }
        results.add(nameFile + "-" + found);
        fr.close();
    }

    public int searchWords(String line, String word) {
        short founded = 0;
        line = line.trim();
        int index = 0;
        int indexFounded = line.indexOf(word, index);
        while (indexFounded != -1) {
            index = indexFounded + word.length();
            founded++;
            indexFounded = line.indexOf(word, index);
        }
        return founded;
    }

}
