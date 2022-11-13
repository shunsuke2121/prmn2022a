package ex3;

import java.util.Scanner;

public class Exercise3_1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("任意の文字列を入力してください：");
        String line = input.nextLine();
        System.out.println(line+"と入力されました");
    }
}
