package ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("B2210960 gotou shunsuke");
        int studentNumber = 2210960;
        System.out.println("B" + studentNumber + "gotou shunsuke");
        int age = input.nextInt();
        if (age >= 20) {
            System.out.println(" am XX years old so I cannot drink liquor.");

        } else {
            System.out.println("I am XX years old so I can drink liquor.");
        }
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                sum=array[i]+sum;
            }
        }

    }
}