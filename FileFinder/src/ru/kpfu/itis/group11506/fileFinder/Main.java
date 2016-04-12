package ru.kpfu.itis.group11506.fileFinder;

import java.io.*;
import java.util.Scanner;

public class Main
{
    private static boolean recursion = false;
    static FileReader fR = null;
    private static boolean result = false;
    private static String absolutePath = null;

    public static void main(String[] args)
    {
        String path = null;
        String file;
        String word = null;

        System.out.println("Start settings:");
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-r")) {
                recursion = true;
            }
            if (args[i].equals("-p")) {
                System.out.println("Directory - " + args[i+1]);
                path = args[i+1];
            }
            if (args[i].equals("-c")) {
                System.out.println("Finding text - " + args[i+1]);
                word = args[i+1];
            }
        }

        System.out.println("Recursion is " + recursion);

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of required file: ");
        file = input.nextLine();
        find(path, file);
        findText(absolutePath, word);
        if(result)
            System.out.println("File located in the folder");
        else System.out.println("File was not found ");

    }

    private static void find(String path,  String file) {
        File f  = new File(path);
        String[] allFiles = f.list();

        for (String files : allFiles) {
            File newFile = new File(path+"\\" + files);
            if(((path + "\\" + files).equals(path+"\\"+file)) && newFile.isFile())
            {
                result = true;
                absolutePath = newFile.getAbsolutePath();
                System.out.println("Path - " + absolutePath);
            }
            if (recursion && newFile.isDirectory()) {
                find(path+"\\" + files,file);
            }
        }
    }

    private static boolean findText(String path, String word) {
        boolean isContain = false;
        try {
            File f = new File(path);
            fR = new FileReader(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found at: " + path);
        }
        BufferedReader bR = new BufferedReader(fR);
        String line;
        int currLine = 0;
        try {
            while ((line = bR.readLine()) != null) {
                currLine++;
                if (line.contains(word)) {
                    isContain = true;
                    System.out.println("Word " + word + " contain in string number: " + currLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e.toString());
        }
        return isContain;
    }

}