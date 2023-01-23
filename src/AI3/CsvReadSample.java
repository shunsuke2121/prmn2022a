package AI3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CsvReadSample{
    private ArrayList<List<Double>> knownInputs= new ArrayList<>();
    private ArrayList<List<Double>> t= new ArrayList<>();
    ArrayList<String>hikain= new ArrayList<>();
    public int count=0;
    ArrayList<List<Double>>hikakin_janken= new ArrayList<>();
    public CsvReadSample(){
        //test.txtファイルのパスを設定
        File f = new File("src/AI3/hikakin1 2021.txt");
        //closeメソッドは自動呼び出しの対象とする。
        try(Scanner sc = new Scanner(f)){
            //hasNextLineで次の行が存在するかを判定します。
            while(sc.hasNextLine()){
                //次の行を読み込み
                String str = sc.nextLine();
                hikain.add(str);
                //System.out.println(str);
            }
            int l=0;
            System.out.println(l);
            for (int p=0;p< hikain.size();p++){
                System.out.println(hikain.get(p));
//                switch (hikakins){
//                    case "グー":
//                        hikakin_janken.add(Arrays.asList(1.0,0.0,0.0));
//                        System.out.println(l);
//                    case "チョキ":
//                        hikakin_janken.add(Arrays.asList(0.0,1.0,0.0));
//                        System.out.println(l);
//                    case "パー":
//                        hikakin_janken.add(Arrays.asList(0.0,0.0,1.0));
//                        System.out.println(l);
//                    default:
//                }
                if(hikain.get(p).equals("グー")){
                    hikakin_janken.add(Arrays.asList(1.0,0.0,0.0));
                    System.out.println(l);
                }else if(hikain.get(p).equals("チョキ")){
                    hikakin_janken.add(Arrays.asList(0.0,1.0,0.0));
                    System.out.println(l);
                }else if(hikain.get(p).equals("パー")){
                    hikakin_janken.add(Arrays.asList(0.0,0.0,1.0));
                    System.out.println(l);
                }else {
                    System.out.println("エラー");
                }
                l++;
            }
//            System.out.println(hikain.size());
//            System.out.println(hikain.get(0));
//            System.out.println(hikain.get(1));
//            System.out.println(hikakin_janken.size());
//            System.out.println(hikakin_janken.get(0));
//            System.out.println(hikakin_janken.get(1));
//            System.out.println(hikakin_janken.get(2));
//            System.out.println(hikakin_janken.get(3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<List<Double>> read(){
        ArrayList<List<Double>> x= new ArrayList<>();
        for(int k=0;k<8;k++){
            x.add(hikakin_janken.get(k));
            System.out.println(x.get(k));
            if(k==7){
                this.t.add(hikakin_janken.get(k));
            }
        }
        for(int k=0;k<1;k++){
            hikakin_janken.remove(k);
        }
        count++;
        System.out.println(hikakin_janken.size());
        return  x;

    }
    public ArrayList<List<Double>> read2(){
        ArrayList<List<Double>> x= new ArrayList<>();
        for(int k=0;k<8;k++){
            x.add(hikakin_janken.get(k));
            System.out.println(x.get(k));
            if(k==7){
                this.t.add(hikakin_janken.get(k));
            }
        }
        for(int k=0;k<8;k++){
            hikakin_janken.remove(k);
        }
        count++;
        System.out.println(hikakin_janken.size());
        return  x;

    }
    public void print(){
        System.out.println(hikakin_janken.size());
    }
}

//※ irisのデータはこんな感じなので「,」で区切っている
//        0,5.1,3.5,1.4,0.2,setosa
//        50,7.0,3.2,4.7,1.4,versicolor
//        116,6.5,3.0,5.5,1.8,virginica