package ex6;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Exercise6_1 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("小数値を入力してください:");
        try{
            input.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("エラー");
        }
    }
}
