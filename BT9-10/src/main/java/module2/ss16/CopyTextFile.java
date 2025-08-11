package main.java.module2.ss16;

import java.io.*;

public class CopyTextFile {
    public static void main(String[] args) {
        String File_Path = "src/module2.ss16/TextFile.txt";
        String File_Taget_Path = "src/module2.ss16/FileTaget.txt";
        try (FileReader fileReader = new FileReader(File_Path);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(File_Taget_Path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            String line =null;
            while ((line= bufferedReader.readLine())!=null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            System.out.println("Copy file thành công");
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
        }

    }

}
