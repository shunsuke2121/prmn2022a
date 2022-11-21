package ex3;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Exercise3_2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        ArrayList<String> test = new ArrayList<>();
        System.out.println("何行分入力しますか？");
        int number = input.nextInt();
        input.nextLine();
        for(int i=0; i<=number-1;i++){
            System.out.println(i+1+"行目:");
            String b = input.nextLine();
            test.add(b);
        }
        System.out.println("入力した文字列");
        for(String j:test){
            System.out.println(j);
        }
    }
}
