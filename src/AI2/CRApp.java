//package AI2;
//
//import AI.NeuralNet;
//
//import java.util.ArrayList;
//
///**
// * 文字認識(Character Recognition)
// * @author tkato
// *
// */
//public class CRApp {
//
////	static final int MASS_X = 6; // マス目の数（縦）
////	static final int MASS_Y = 6; // マス目の数（横）
//	static ArrayList<Double>unknownInputs = new ArrayList<>();
//
//	public static void main(String[] args) {
//	int count  = 1;
//		NeuralNet nn = new NeuralNet(count, count, 4);
//
//		// 訓練データ（入力）
//		double knownInputs[][] = {
//			{ // 0の訓練データ
//			  0, 0, 1, 1, 0, 0,
//			  0, 1, 0, 0, 1, 0,
//			  0, 1, 0, 0, 1, 0,
//			  0, 1, 0, 0, 1, 0,
//			  0, 1, 0, 0, 1, 0,
//			  0, 0, 1, 1, 0 ,0
//			},
//			{ // 1の訓練データ
//			  0, 0, 0, 1, 0, 0,
//			  0, 0, 0, 1, 0, 0,
//			  0, 0, 0, 1, 0, 0,
//			  0, 0, 0, 1, 0, 0,
//			  0, 0, 0, 1, 0, 0,
//			  0, 0, 0, 1, 0 ,0
//			},
//				{ // 1の訓練データ
//				1, 1, 1, 0, 1, 1,
//				0, 0, 0, 0, 0, 1,
//				1, 1, 1, 1, 1, 1,
//				1, 0, 0, 0, 0, 0,
//				1, 0, 0, 0, 0, 0,
//				1, 1, 1, 1, 1, 1
//		}
//		};
//
//		// 教師データ
//		double t[][] = {
//				{0, 0, 0, 0}, // この組み合わせを0とする
//				{0, 0, 0, 1},  // この組み合わせを1とする
//				{0, 0, 1, 0}  // この組み合わせを2とする
//		};
//
//		// 学習
//		System.out.println("--学習開始--");
//		nn.learn(knownInputs, t);
//		System.out.println("--学習終了--");
//
//		System.out.println("\n--推論開始--");
//		// ---------------------
//		// 推定はここから
//		// ---------------------
//		unknownInputs.add();
//				// 教師データ
//		double expects[][] = {
//				{0, 0, 0, 0}, // この組み合わせを0とする
//				{0, 0, 0, 1}, // この組み合わせを1とする
//				{0, 0, 1, 0}  // この組み合わせを2とする
//		};
//
////		for ( int i=0; i<unknownInputs.size(); i++ ) {
////			System.out.println("das"+unknownInputs[i]);
////			double[] output = nn.compute(unknownInputs[i]);
////			print(unknownInputs[i], output, expects[i]);
////		}
//		int i=0;
//		for (Double unknown : unknownInputs){
//			System.out.println("das"+unknown);
//			double[] output = nn.compute(unknown);
//			print(unknown, output, expects[i]);
//			i++;
//		}
//		System.out.println("\n--推論終了--");
//
//	}
//
//	// 画面に入力データと実体値、予測値を表示する
//	public static void print(double[] input, double[] output, double[] expect) {
//		System.out.println();
//		System.out.println("入力データ");
////		for (int j = 0; j < MASS_Y; j++) {
////			for (int k=0; k<MASS_X; k++) {
////				System.out.print((int)input[j*MASS_X+k]);
////				System.out.print(" ");
////			}
////			System.out.println();
////		}
//		System.out.println("期待する値（文字）：" + value(expect) );
//		System.out.println("ニューラルネットワークが予測した値（文字）：" + value(output));
//	}
//
//	// 出力データと数字のマッピングを行う
//	public static int value(double[] a){ //いらない
//        // ステップ関数（0.5を閾値として0,1に変換）
//		int v1 = (int)(a[0]+0.5);
//		int v2 = (int)(a[1]+0.5);
//		int v3 = (int)(a[2]+0.5);
//		int v4 = (int)(a[3]+0.5);
////		System.out.println(v1);
////		System.out.println(v2);
////		System.out.println(v3);
////		System.out.println(v4);
////		System.out.println(v1 * 8 + v2 * 4 + v3 * 2 + v4 * 1);
//		// 出力層の値
//		return v1 * 8 + v2 * 4 + v3 * 2 + v4 * 1;
//	}
//
//}
