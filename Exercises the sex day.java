Q1\ 
A--
public class circle {
    public static void main(String[]args){

    }
    private double radios = 1.0;
    private String Color = "red";

    public circle (){
    }
    public circle(double radios) {
        this.radios=radios;
        this.Color=Color;
    }
    public circle(double radios, String color) {
        this.radios = radios;
        Color = color;
    }

    public double getRadios() {
        return radios;
    }

    public void setRadios(double radios) {
        this.radios = radios;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public double getArea() {
       return radios*2;
    }

    @Override
    public String toString() {
        return "circle{" +
                "radios=" + radios +
                ", Color='" + Color + '\'' +
                '}';
    }
}
------------------
B\ 
public class Cylinder extends circle {
    private double height = 1.0;

    public Cylinder(double radios) {
        super(radios);
    }

    public Cylinder(double radios, double height) {
        super(radios);
        this.height = height;
    }

    public Cylinder(double radios, String color, double height) {
        super(radios, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return Math.PI * Math.pow(getRadius(),2) * height;
    }
}




Q2\ 
Skip to content
AtawiTech
/
Week2Day1
Public
Code
Issues
Pull requests
Actions
Projects
Wiki
More
Week2Day1/Account.java /
@AtawiTech
AtawiTech Add files via upload
 1 contributor
61 lines (49 sloc)  1.25 KB
package com.company;

public class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
        balance = 0;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    public int debit(int amount) {
        if(amount<=balance) {
            balance -= amount;
        }else {
            System.out.println("Amount exceeded balance");
        }

        return balance;
    }

    public int transferTo(Account another,int amount) {
        if(amount <= balance) {
            this.balance -= amount;
            another.balance += amount;
        }else {
            System.out.println("Amount exceeded balance");
        }

        return this.balance;
    }

    public String toString() {
        return String.format("Account[id=%s,name=%s,balance=%d]", id,name,balance);
    }
}
---------------
Q3 /
public interface GeometricObject {
    double getPerimeter();
    double getArea();
}
public interface Resizable {
    void resize(int percent);
}
public class ResizeableCircle extends Circle implements  Resizable{


    public ResizeableCircle(double radius) {
        super(radius);
    }

    @Override
    public String toString() {
        return "ResizeableCircle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public void resize(int percent) {
        radius *= percent/100.0;
    }
}

public class Circle implements GeometricObject{

    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public double getPerimeter() {
        return 2*radius*3.14159265359;
    }

    @Override
    public double getArea() {
        return (radius*radius)*3.14159265359;
    }
} 
--------------------------
Q4\
import java.security.PublicKey;

public interface Movable {
    public void moveUp ();
    public void moveDown();
    public void moveLeft();
    public void moveRight();

}
public class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center ;

    public MovableCircle(int x,int y, int xSpeed,int ySpeed,int radiuse) {
        MovablePoint center=new MovablePoint(x,y,xSpeed,ySpeed);
        this.radius=radiuse;

    }

    @Override
    public String toString() {
        return "(x,Y),Speed=radius=("+center.x+","+center.y+", radius"+radius;
    }

    public void moveUp (){

    }
    public void moveDown(){

    }
    public void moveLeft(){

    }

    public void moveRight() {

    }
}
public class MovablePoint extends Point{
    private float xSpeed;
    private float ySpeed;

    public MovablePoint() {
        xSpeed = 0.0f;
        ySpeed = 0.0f;
    }

    public MovablePoint(float xSpeed,float ySpeed) {
        super();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x,float y,float xSpeed,float ySpeed) {
        super.setXY(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed,float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] results = new float[2];

        results[0] = xSpeed;
        results[1] = ySpeed;

        return results;
    }
    @Override
    public String toString() {
        return String.format("%s,speed=(%.1f,%.1f)", super.toString(),xSpeed,ySpeed);
    }

    public MovablePoint move() {
        super.setX(getX()+xSpeed);//cannot write super.setX(x+xSpeed) as x is invisible in the subclass
        super.setY(getY()+ySpeed);
        return this;
    }
}
-----------------------------------------
Q5\ 
public class Customer {

    private int id;
    private String name;
    private int discount;

    public Customer(int ID, String name, int discount) {
        this.id = ID;
        this.name = name;
        this.discount = discount;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return  name + "(" +id+") ("+
                + discount +
                "%)";
    }
}
public class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId(){
        return this.customer.getID();
    }

    public String getCustomerName(){
        return this.customer.getName();
    }

    public int getCustomerDiscount(){
        return  this.customer.getDiscount();
    }

    public double getAmountAfterDiscount(){
        return amount-=amount*getCustomerDiscount()/100;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + customer.toString() +
                ", amount=" + amount +
                '}';
    }
}
public class TestMain {

    public static void main(String []args){

        Invoice invoice=new Invoice(0,new Customer(1,"Ali",10),500);
        System.out.println(invoice);
        System.out.println("Amount after discount= "+ invoice.getAmountAfterDiscount());
    }
}
