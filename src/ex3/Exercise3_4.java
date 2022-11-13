package ex3;

import java.util.ArrayList;

public class Exercise3_4 {
    public static void main(String[] args) {
        ArrayList<Vegetable> vegetables = new ArrayList();
        vegetables.add(new Vegetable("にんじん",117));
        vegetables.add(new Vegetable("たまねぎ",120));
        vegetables.add(new Vegetable("じゃがいも",154));
        for(int i =0;i<vegetables.size();i++){
            vegetables.get(i).print();
        }
    }
}
