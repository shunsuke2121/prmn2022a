package ex5;

public class Exercise5_3 {
    public static void main(String[] args) {
        Butterfly butterfly = new Butterfly();
        Insect insect = butterfly;
        insect.move();
    }
}
