package model;

import java.io.File;

public class Upload {

    private File readedFiles;

    // Method to upload files, with a received path
    public void uploadFile(String path) {
        readedFiles = new File(path);
    }

    // method to consult the files uploaded
    public File getFile() {
        return this.readedFiles;
    }
}
