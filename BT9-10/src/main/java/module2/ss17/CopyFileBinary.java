package main.java.module2.ss17;

import java.io.*;
import java.util.Scanner;

public class CopyFileBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Source_File_Path = "src/module2.ss17/TagetFile.dat";
        String Taget_File_Path = "src/module2.ss17/SourceFile.dat";
        File sourceFile = new File(Source_File_Path);
        File targetFile = new File(Taget_File_Path);

        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại.");
            return;
        }

        // Nếu tệp đích đã tồn tại, cảnh báo người dùng
        if (targetFile.exists()) {
            System.out.print("Tệp đích đã tồn tại. Bạn có muốn ghi đè? (y/n): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                System.out.println("Đã huỷ thao tác sao chép.");
                return;
            }
        }
        try (
                InputStream inputStream = new FileInputStream(sourceFile);
                OutputStream outputStream = new FileOutputStream(targetFile)
        ) {
            byte[] buffer = new byte[4096]; // Bộ đệm 4KB
            int bytesRead;
            int totalBytes = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println("Đã sao chép thành công.");
            System.out.println("Tổng số byte đã sao chép: " + totalBytes);
        } catch (IOException e) {
            System.err.println("Lỗi khi sao chép tệp. ");
        }
    }


}
