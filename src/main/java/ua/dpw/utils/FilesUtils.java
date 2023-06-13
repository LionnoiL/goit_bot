package ua.dpw.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FilesUtils {

    public static void saveTextFile(String filePath, String text) {
        checkFileDirAndCreateDir(filePath);
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(text);
        } catch (IOException e) {
            log.error("Error save file = {}", filePath);
        }
    }

    public static void checkFileDirAndCreateDir(String filePath) {
        File dir = new File(new File(filePath).getParent());
        if (!dir.exists() && !dir.mkdirs()) {
            log.error("Error create dir = {}", dir.getAbsolutePath());
        }
    }
}
