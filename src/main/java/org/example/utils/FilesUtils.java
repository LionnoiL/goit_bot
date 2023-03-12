package org.example.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilesUtils {
    private FilesUtils() {
    }

    public static void saveTextFile(String filePath, String text) {
        FileWriter file = null;
        try {
            checkFileDirAndCreateDir(filePath);
            file = new FileWriter(filePath);
            file.write(text);
        } catch (IOException e) {
            System.out.println("Error save file! " + filePath);
        }
        if (file != null) {
            try {
                file.close();
            } catch (IOException e) {
                System.out.println("Error close file! " + filePath);
            }
        }
    }

    public static void checkFileDirAndCreateDir(String filePath) throws IOException {
        File dir = new File(new File(filePath).getParent());
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Error create dir! " + dir.getAbsolutePath());
        }
    }
}