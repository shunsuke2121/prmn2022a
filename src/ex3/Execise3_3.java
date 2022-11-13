package ex3;

import java.util.Scanner;

public class Execise3_3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String[] mozi = new String[2];
        int[] num = new int[2];
        for(int i=0;i<2;i++){
            System.out.println(i+1+"つ目の整数を入力してください：");
            mozi[i] = input.nextLine();
            num[i] = Integer.parseInt(mozi[i]);
        }
        System.out.print(mozi[0]+"+"+mozi[1]+"=");
        System.out.println(num[0]+num[1]);
    }
}
