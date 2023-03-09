package org.example.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FilesUtils {

  private FilesUtils() {
  }

  public static void saveTextFile(String filePath, String text) {
    FileWriter file = null;
    try {
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
}
