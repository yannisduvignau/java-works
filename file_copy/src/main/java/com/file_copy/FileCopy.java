package com.file_copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileCopy <source_file> <destination_file>");
            return;
        }

        String sourcePath = args[0];
        String destinationPath = args[1];

        try {
            FileInputStream fileInputStream = new FileInputStream(sourcePath);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationPath);

            byte[] buffer = new byte[5];
            int length;
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }

            fileInputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourcePath);
        } catch (IOException e) {
            System.out.println("Error occurred while copying the file.");
            e.printStackTrace();
        }
    }
}
