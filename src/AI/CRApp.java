package AI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 文字認識(Character Recognition)
 * @author tkato
 *
 */
public class CRApp {

	static final int MASS_X = 6; // マス目の数（縦）
	static final int MASS_Y = 6; // マス目の数（横）

	public static void main(String[] args) {
		int count =0;
		NeuralNet nn = new NeuralNet(36, 36, 3);
		Scanner scanner = new Scanner(System.in);
		double knownInputs[][] = {

		};
		System.out.println("出す手を決めてグー:0 チョキ:1 パー:2");
		int Action = scanner.nextInt();
		switch (Action){		// 訓練データ（入力）
			case 0:
				knownInputs[count][0] =1;
				knownInputs[count][1] =0;
				knownInputs[count][2] =0;
			case 1:
				knownInputs[count][0] =0;
				knownInputs[count][1] =1;
				knownInputs[count][2] =0;
			case 2:
				knownInputs[count][0] =0;
				knownInputs[count][1] =0;
				knownInputs[count][2] =1;
			default:
		}


		// 教師データ
		double t[][] = {
				{1, 0, 0}, // この組み合わせをグーとする
				{0, 1, 0},// この組み合わせをチョキとする
				{0, 0, 1}// この組み合わせをパーとする
		};

		// 学習
		System.out.println("--学習開始--");
		nn.learn(knownInputs, t);
		System.out.println("--学習終了--");

		System.out.println("\n--推論開始--");
		// ---------------------
		// 推定はここから
		// ---------------------
		double[][] unknownInputs = {

		};
		switch (Action) {        // 訓練データ（入力）
			case 0:
				unknownInputs[count][0] = 1;
				unknownInputs[count][1] = 0;
				unknownInputs[count][2] = 0;
			case 1:
				unknownInputs[count][0] = 0;
				unknownInputs[count][1] = 1;
				unknownInputs[count][2] = 0;
			case 2:
				unknownInputs[count][0] = 0;
				unknownInputs[count][1] = 0;
				unknownInputs[count][2] = 1;
			default:
		}
		// 教師データ
		double expects[][] = {
				{1, 0, 0}, // この組み合わせをグーとする
				{0, 1, 0},// この組み合わせをチョキとする
				{0, 0, 1}// この組み合わせをパーとする
		};

		for ( int i=0; i<unknownInputs.length; i++ ) {
			double[] output = nn.compute(unknownInputs[i]);
			print(unknownInputs[i], output, expects[i]);
		}
		System.out.println("\n--推論終了--");

	}

	// 画面に入力データと実体値、予測値を表示する
	public static void print(double[] input, double[] output, double[] expect) {
		System.out.println();
		System.out.println("入力データ");
		for (int j = 0; j < MASS_Y; j++) {
			for (int k=0; k<MASS_X; k++) {
				System.out.print((int)input[j*MASS_X+k]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("期待する値（文字）：" + value(expect) );
		System.out.println("ニューラルネットワークが予測した値（文字）：" + value(output));
	}

	// 出力データと数字のマッピングを行う
	public static int value(double[] a){
        // ステップ関数（0.5を閾値として0,1に変換）
        //  if     0 <= an < 0.5   then  0
        //  if  0.5 <   an <    1  then  1
		int v1 = (int)(a[0]+0.5);
		int v2 = (int)(a[1]+0.5);
		int v3 = (int)(a[2]+0.5);
		int v4 = (int)(a[3]+0.5);

		// 出力層の値
		return v1 * 8 + v2 * 4 + v3 * 2 + v4 * 1;
	}

}
