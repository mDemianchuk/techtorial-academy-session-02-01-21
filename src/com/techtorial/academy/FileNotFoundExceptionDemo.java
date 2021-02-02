package com.techtorial.academy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFoundExceptionDemo {
    public static void main(String[] args) {
        Scanner consoleReader = new Scanner(System.in);
        String fileContents = "";
        while (fileContents.isEmpty()) {
            System.out.print("Please enter the file path: ");
            String filePath = consoleReader.nextLine();
            fileContents = getFileContents(filePath);
        }
        System.out.print("File contents: ");
        System.out.println(fileContents);
    }

    private static String getFileContents(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                sb.append(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            boolean isFileRead = sb.length() > 0;
            System.out.println("The file was " + (isFileRead ? "read" : "not read"));
            return sb.toString();
        }
    }
}
