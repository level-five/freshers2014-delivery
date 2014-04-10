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

		Scanner scan = new Scanner(inputStream);
		String val = scan.next();
		System.out.println(val);
		// System.out.println("配送方法を選んでください");
		// char[] input = val.toCharArray();
		// System.out.println(input[0]);
		scan.close();
		return val;
	}

	public int inputPostalCode() {
		printStream.format("郵便番号7桁を入力してください。");
		Scanner scan1 = new Scanner(inputStream);
		int val = scan1.nextInt();
		scan1.close();
		return val;
	}

	public int inputArrivalDate() {
		printStream.format("希望される到着指定日を入力してください。　例）20140410");
		Scanner scan1 = new Scanner(inputStream);
		int val = scan1.nextInt();
		scan1.close();
		return val;
	}

};
