package ex2;

public class Car {
    int fuel;
    Tire tires;

    Car(){
        this.fuel=0;
    }
    void run(){
        if(fuel>0) {
            System.out.println("燃料を" + fuel + "消費して走りました。");
        }
        System.out.println("走れないよこんなんじゃ");
    }
}
