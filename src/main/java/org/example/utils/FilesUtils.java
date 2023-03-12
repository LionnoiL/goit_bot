package org.example.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilesUtils {

    private static final Logger LOG = LogManager.getLogger(FilesUtils.class);

    private FilesUtils() {
    }

    public static void saveTextFile(String filePath, String text) {
        try (FileWriter file = new FileWriter(filePath)) {
            checkFileDirAndCreateDir(filePath);
            file.write(text);
        } catch (IOException e) {
            LOG.warn("Error save file! " + filePath);
        }
    }

    public static void checkFileDirAndCreateDir(String filePath) throws IOException {
        File dir = new File(new File(filePath).getParent());
        if (!dir.exists() && !dir.mkdirs()) {
            LOG.warn("Error create dir! " + dir.getAbsolutePath());
        }
    }
}