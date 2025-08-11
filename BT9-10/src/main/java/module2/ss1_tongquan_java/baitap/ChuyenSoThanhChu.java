package main.java.module2.ss1_tongquan_java.baitap;

import java.util.Scanner;

public class ChuyenSoThanhChu {
    public static void main(String[] args) {
        System.out.printf("Nhập số bạn muốn chuyển: ");
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        String DonVi[] = {"không ", "một ", "hai ", "ba ", "bốn ", "năm ", "sáu ", "bảy ", "tám ", "chín "};

        if (number/1000>0){
            System.out.printf(DonVi[number/1000] +"nghìn ");
            System.out.printf(DonVi[number%1000/100] +"trăm ");
            if (number % 1000 % 100 < 10 && number % 1000%100%10 > 0) {
                System.out.printf("linh " + DonVi[number % 1000 % 100 % 10]);
            }
            if (number % 1000 % 100 / 10 == 1) {
                System.out.printf("mười ");
                if (number % 1000 % 100 % 10 == 5) {
                    System.out.printf("lăm ");
                }else if (number % 1000 % 100 % 10 == 0) {
                    System.out.printf("");
                }else {
                    System.out.printf(DonVi[number % 1000 % 100 % 10]);
                }
            }else if (number % 1000 % 100 / 10 > 1) {
                System.out.printf(DonVi[number % 1000%100/10]+"mươi ");
                if (number % 1000 % 100 % 10 ==1) {
                    System.out.printf("mốt ");
                } else if (number % 1000 % 100 % 10 == 5) {
                    System.out.printf("lăm ");
                }else if (number % 1000 % 100 % 10 == 0) {
                    System.out.printf("");
                }else {
                    System.out.printf(DonVi[number % 1000 % 100 % 10]);
                }
            }
        }else{
            if (number % 1000 / 100 > 0) {
                System.out.printf(DonVi[number % 1000/100] +"trăm ");
                if (number % 1000%100 < 10 && number % 1000%100%10 > 0) {
                    System.out.printf("linh " + DonVi[number % 1000%100%10]);
                }
            }
            if (number % 1000 % 100 / 10 == 1) {
                System.out.printf("mười ");
                if (number % 1000 % 100 % 10 == 5) {
                    System.out.printf("lăm ");
                }else if (number % 1000 % 100 % 10 == 0) {
                    System.out.printf("");
                }else {
                    System.out.printf(DonVi[number % 1000 % 100 % 10]);
                }
            }else if (number % 1000 % 100 / 10 > 1) {
                System.out.printf(DonVi[number % 1000%100/10]+"mươi ");
                if (number % 1000 % 100 % 10 ==1) {
                    System.out.printf("mốt ");
                } else if (number % 1000 % 100 % 10 == 5) {
                    System.out.printf("lăm ");
                }else if (number % 1000 % 100 % 10 == 0) {
                    System.out.printf("");
                }else {
                    System.out.printf(DonVi[number % 1000 % 100 % 10]);
                }
            }else {
                System.out.printf(DonVi[number % 1000 % 100 % 10]);
            }
        }

    }
}
