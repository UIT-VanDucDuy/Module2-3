package main.java.module2.ss4_OOP;

public class Fan {
    private String CompanyName;
    private boolean Status;
    private String color;
    private int speed;

    public Fan(String CompanyName) {
        this.CompanyName = CompanyName;
        this.Status = false;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getCompanyName() {
        return CompanyName;
    }
    public void setStatus(boolean status) {
        Status = status;
    }
    public boolean getStatus() {
        return Status;
    }
    public void aboutFan(){
        if(this.Status == true) {
            System.out.println("Fan is ON - Speed: " + this.speed +" Color: " + this.color+" Company Name: " + this.CompanyName);
        }else {
            System.out.println("Fan is OFF - color: " + this.color+" Company Name: " + this.CompanyName);
        }
    }

}
