package main.java.module2.ss4_OOP;

import java.util.Scanner;

public class StopWatch {
    private int hours;
    private int minutes;
    private int seconds;

    public StopWatch() {
    }
    public StopWatch(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    public void startCount() throws InterruptedException{
        while (hours > 0 || minutes > 0 || seconds > 0) {
            System.out.printf("\r"+String.format("%02d",hours)+":"+String.format("%02d",minutes)+":"+String.format("%02d",seconds));
            if (seconds == 0&& minutes > 0) {
                minutes--;
                seconds =60;
            }
            if (minutes == 0 && hours > 0) {
                hours--;
                minutes=60;
            }
            seconds--;
            Thread.sleep(1000);

        }
        System.out.printf("\rHết giờ !!!!!!!!!!");

    }
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter hours: ");
        int hours = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter minutes: ");
        int minutes = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter seconds: ");
        int seconds = Integer.parseInt(sc.nextLine());
        StopWatch watch =new StopWatch(hours, minutes, seconds);
        watch.startCount();
    }
}
