package main.java.module2.ss2_loop_java;

public class HienThi20SoNguyenTo {
    public static void main(String[] args) {
        int count = 0, num = 2;

        while (count < 20) {
            while (count < 20) {
                boolean check = true;

                if (num < 2) {
                    check = false;
                } else {
                    for (int i = 2; i <= Math.sqrt(num); i++) {
                        if (num % i == 0) {
                            check = false;
                            break;
                        }
                    }
                }
                if (check) {
                    System.out.print(num + " ");
                    count++;
                }

                num++;
            }
        }
    }
}
