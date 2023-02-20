package model;

import java.io.File;
import java.io.IOException;

public class Upload {

    private File readedFiles;

    public void uploadFile(String path) throws IOException {
        readedFiles = new File(path);
    }

    public File getFile() {
        return this.readedFiles;
    }
}
