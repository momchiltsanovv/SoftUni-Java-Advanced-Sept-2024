package _04_StreamsFilesAndDirectories;

import java.io.File;

public class _08_GetFolderSize {

    public static long calculateFolderSize(File folder) {
        long length = 0;
        // Get all files and directories in the current folder
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                // If it is a file, add its size to the total length
                if (file.isFile()) {
                    length += file.length();
                }
                // If it's a directory, recurse into it and add its size
                else if (file.isDirectory()) {
                    length += calculateFolderSize(file);
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        // Provide the folder path
        String folderPath = "C:/path/to/your/Folder Exercises Resources"; // Replace with your folder path
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            // Calculate the size of the folder
            long folderSize = calculateFolderSize(folder);
            System.out.println("The size of the folder is: " + folderSize + " bytes");
        } else {
            System.out.println("The specified path is not a valid folder.");
        }
    }
}
