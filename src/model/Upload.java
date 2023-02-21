package model;

import java.io.File;

public class Upload {

    private File readedFiles;

    public void uploadFile(String path) {
        readedFiles = new File(path);
    }

    public File getFile() {
        return this.readedFiles;
    }
}
