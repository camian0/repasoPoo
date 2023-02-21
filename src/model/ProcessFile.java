package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ProcessFile {

    private HashMap<String, Integer> results = new HashMap<>();
    Upload upload = new Upload();

    public HashMap<String, Integer> getHashMap() {
        return results;
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
            found += searchWords(line, word);
            line = br.readLine();
        }
        results.put(nameFile, found);
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
