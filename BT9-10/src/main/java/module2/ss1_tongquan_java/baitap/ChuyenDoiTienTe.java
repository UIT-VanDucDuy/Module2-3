package main.java.module2.ss1_tongquan_java.baitap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        System.out.printf("Từ loại tiền (vnd,usd,eur): ");
        Scanner sc = new Scanner(System.in);
        String from,to;
        from = sc.nextLine();
        System.out.printf("Sang loại tiền (vnd,usd,eur): ");
        to = sc.nextLine();
        System.out.printf("Số tiền bạn muốn chuyển: ");
        double money = Double.parseDouble(sc.nextLine());

        switch (from + "_" + to){
            case "vnd_usd":System.out.println(money/25970);break;
            case "vnd_eur":System.out.println(money/28755);break;
            case "eur_usd":System.out.println(money/28755*25970);break;
            case "usd_eur":System.out.println(money/25970*28755);break;
            case "usd_vnd":System.out.println(money*25970);break;
            case "eur_vnd":System.out.println(money*28755);break;
            default:System.out.println(money);
        }
    }

}
