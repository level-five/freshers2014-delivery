package jp.level_five.freshers.delivery;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputOutput {

	private InputStream inputStream;
	private PrintStream printStream;

	public InputOutput() {
		inputStream = System.in;
		printStream = System.out;
	}

	public void setInputStream(InputStream stream) {
		inputStream = stream;
	}

	public void setPrintStream(PrintStream stream) {
		printStream = stream;
	}

	public String inputShippingMethod() {
		printStream.format("配送方法を選択してください。　A　または　B");
		Scanner shippingMethodScan = new Scanner(inputStream);
		String inputShippingMethod = shippingMethodScan.next();
		shippingMethodScan.close();
		return inputShippingMethod;
	}

	public int inputPostalCode() {
		printStream.format("郵便番号7桁を入力してください。");
		Scanner postalScan = new Scanner(inputStream);
		int inputPostalCode = postalScan.nextInt();
		postalScan.close();
		return inputPostalCode;
	}

	public int inputArrivalDate() {
		printStream.format("希望される到着指定日を入力してください。　例）20140410");
		Scanner arrivalDateScan = new Scanner(inputStream);
		int inputArrivalDate = arrivalDateScan.nextInt();
		arrivalDateScan.close();
		return inputArrivalDate;
	}

	public String inputTimeZone() {
		printStream.format("希望される時間帯を選択してください。午前、午後、夕方");
		Scanner timeZoneScan = new Scanner(inputStream);
		String inputTimeZone = timeZoneScan.next();
		timeZoneScan.close();
		return inputTimeZone;
	}

	public int inputMode() {
		printStream.format("使用したい機能を選択してください。\n 1: サービスの一覧を表示\n 2: 指定日時に届く発送日を調べる\n 3: 最も安い配送サービスを調べる");
		Scanner mode = new Scanner(inputStream);
		int inputMode = mode.nextInt();
		mode.close();

		return inputMode;
	}

	public void output(String output) {
		printStream.format(output);
	}
}
