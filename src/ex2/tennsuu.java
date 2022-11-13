package ex2;

public class tennsuu {
    int[] array = new int[1000];
    int min() {
        int min = 0;
        for (int i : array) {
            if (min >= array[i]) {
                min = array[i];
            }
        }
        return min;
    }


int max(){
        int max = 0;
        for (int i:array){
        if(max<=array[i]){
            max =array[i];
        }
        }
        return max;
    }
String[] strings = new String[array.length];
    String[] hantei(){
        for(int i:array){
            if(array[i]<60){
                strings[i]="不可";
            }if(array[i]<70){
                strings[i]="可";
            }if(array[i]<80){
                strings[i]="良";
            }if(array[i]<90){
                strings[i]="優";
            }if(array[i]<100){
                strings[i]="秀";
            }


        }
        return strings;
    }

}

