package AI3;


import java.util.ArrayList;
import java.util.List;

/**
 * 文字認識(Character Recognition)
 * @author tkato
 *
 */
public class CRApp {

	static final int MASS_X = 1; // マス目の数（縦）
	static final int MASS_Y = 1; // マス目の数（横）
	static int True=0;
	static int False=0;
	public static void main(String[] args) {
	CsvReadSample csvReadSample = new CsvReadSample();
		NeuralNet nn = new NeuralNet(21, 16, 3);
		ArrayList<List<Double>> knownInputs =new ArrayList<>();
		ArrayList<List<Double>> t = new ArrayList<>();
//		while(csvReadSample.count<80) {
//			// 訓練データ（入力）
//			ArrayList<List<Double>> Sample;
//
//			System.out.println(csvReadSample.read());
//			Sample = csvReadSample.read();
//			// 教師データ
//			for (int count = 0; count < Sample.size(); count++) {
//				if (count < Sample.size() - 1) {
//					for(double number : Sample.get(count))
//					{
//						knownInputs.add(number);
//						//System.out.println(knownInputs);
//					}
//				} else {
//					for(double number : Sample.get(count))
//					{
//						t.add(number);
//						//System.out.println(t);
//					}
//				}
//			}
////		for(int i=0; i<knownInputs.length; i++){
////			for (int j=0;j<5;j++){
////			System.out.println(knownInputs[j]);}
////		}
//
//			// 学習
//		}
		while(csvReadSample.count<149){
			ArrayList<List<Double>> SampleSample;
			ArrayList<Double> Samplek=new ArrayList<>();//7日
			ArrayList<Double> Samplet=new ArrayList<>();//1日

			SampleSample = csvReadSample.read();
			for(int count=0;count<SampleSample.size();count++){
				if(count<SampleSample.size()-1){
					for(double number  : SampleSample.get(count)){
						Samplek.add(number);
					}
				}else{
					for(double number  : SampleSample.get(count)){
						Samplet.add(number);
					}
				}
				knownInputs.add(Samplek);
				t.add(Samplet);
				//System.out.println(knownInputs);
			}
		}
		//System.out.println(knownInputs);
		System.out.println("--学習開始--");
		nn.learn(knownInputs, t);
		System.out.println("--学習終了--");
		System.out.println("\n--推論開始--");
		// ---------------------
		// 推定はここから
		// ---------------------
		ArrayList<List<Double>> unknownInputs = new ArrayList<>();
		ArrayList<List<Double>> expects = new ArrayList<>();
		//unknownInputs.add(Arrays.asList(0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0));
		//unknownInputs.add(Arrays.asList(0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0,0.0,0.0,1.0));
//		unknownInputs.add(Arrays.asList(
//				1.0, 0.0, 0.0,
//		1.0, 0.0, 0.0,
//		1.0, 0.0, 0.0,
//		1.0, 0.0, 0.0,
//				1.0, 0.0, 0.0,
//		1.0, 0.0, 0.0,
//		0.0, 0.0, 1.0));
		System.out.println(csvReadSample.hikakin_janken.size());
		while(csvReadSample.hikakin_janken.size()>9){
			System.out.println("aa");
			ArrayList<List<Double>> SampleSample;
			ArrayList<Double> Samplek=new ArrayList<>();//7日
			ArrayList<Double> Samplet=new ArrayList<>();//1日

			SampleSample = csvReadSample.read2();
			for(int count=0;count<SampleSample.size();count++){
				if(count<SampleSample.size()-1){
					for(double number  : SampleSample.get(count)){
						Samplek.add(number);
					}
				}else{
					for(double number  : SampleSample.get(count)){
						Samplet.add(number);
					}
				}
				unknownInputs.add(Samplek);
				expects.add(Samplet);
				//System.out.println(knownInputs);

		}
		}
		System.out.println(unknownInputs.size());
		// 教師データ
//		double expects[][] = {
//				{0, 0, 0, 0}  // この組み合わせを1とする
//		};

		for ( int i=0; i<unknownInputs.size(); i++ ) {
			System.out.println(unknownInputs.size());
			double[] output = nn.compute(unknownInputs.get(i));
			print(unknownInputs.get(i), output, expects.get(i));
		}
		System.out.println("\n--推論終了--");
		csvReadSample.print();

	}
	public static void Judge(String output, List<Double> expect){
		String str=value2(expect);
		System.out.println(expect);
		if(output.equals(str)){
			True++;
		}else{
			False++;
		}
	}
	// 画面に入力データと実体値、予測値を表示する
	public static void print(List<Double> input, double[] output, List<Double> expect) {
		System.out.println();
//		System.out.println("入力データ");
//		for (int j = 0; j < MASS_Y; j++) {
//			for (int k=0; k<MASS_X; k++) {
//				System.out.print((int)input[j*MASS_X+k]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
		//System.out.println("期待する値（文字）：" + value(expect) );
		Judge(value(output),expect);
		System.out.println("ニューラルネットワークが予測した値（文字）：" + value(output));
		System.out.println("期待する値（文字）：" +value2(expect));
		System.out.println("予測があっていた数:"+True);
		System.out.println("予測が間違っていた数:"+False);

	}
	// 出力データと数字のマッピングを行う
	public static String value(double[] a){
        // ステップ関数（0.5を閾値として0,1に変換）
        //  if     0 <= an < 0.5   then  0
        //  if  0.5 <   an <    1  then  1
		int v1 = (int)(a[0]+0.5);
		int v2 = (int)(a[1]+0.5);
		int v3 = (int)(a[2]+0.5);
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		int value =v1 * 4 + v3 * 2 + v3 * 1;
		double Max=maximum(a[0],a[1],a[2]);
		if(Max==a[0]){
			return "グー";
		}else if(Max==a[1]){
			return "チョキ";
		}else {
			return "パー";
		}

	}
	public static String value2(List<Double> a){
		// ステップ関数（0.5を閾値として0,1に変換）
		//  if     0 <= an < 0.5   then  0
		//  if  0.5 <   an <    1  then  1
//		int v1 = (int)(a[0]+0.5);
//		int v2 = (int)(a[1]+0.5);
//		int v3 = (int)(a[2]+0.5);
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
//		int value =v1 * 4 + v3 * 2 + v3 * 1;
		double Max=maximum(a.get(0),a.get(1),a.get(2));
		if(Max==a.get(0)){
			return "グー";
		}else if(Max==a.get(1)){
			return "チョキ";
		}else {
			return "パー";
		}

	}
	static double maximum( double a, double b, double c )
   	{
		   		double ans;

		    		ans = a;
		    		if ( ans < b ) ans = b;
		    		if ( ans < c ) ans = c;
		   		return ans;
		    	}


}
