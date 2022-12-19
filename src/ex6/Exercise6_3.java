package ex6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exercise6_3 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        //System.out.println(random.nextInt(100));
        ArrayList <Integer> dice = new ArrayList<>();
        dice.add(random.nextInt(6)+1);
        dice.add(random.nextInt(6)+1);
        dice.add(random.nextInt(6)+1);
        dice.add(random.nextInt(6)+1);
        dice.add(random.nextInt(6)+1);
        dice.add(random.nextInt(6)+1);
        System.out.println("さいころを5つ振りました.\n" + "何番目のさいころの値を確認しますか？");
        try {
            int number = input.nextInt();
            System.out.println(dice.get(number-1));
        }catch (IndexOutOfBoundsException e){
            System.out.println("ArrayListの範囲外アクセスを確認しました.\n" +
                    "プログラムを終了します.\n");
        }catch (InputMismatchException e){
            System.out.println("整数以外の値が入力されました。\n" +
                    "プログラムを終了します。");
        }
    }
}
