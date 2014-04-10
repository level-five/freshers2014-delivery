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
		printStream.format("�z�����@��I�����Ă��������B�@A�@�܂��́@B");
		Scanner shippingMethodScan = new Scanner(inputStream);
		String inputShippingMethod = shippingMethodScan.next();
		shippingMethodScan.close();
		return inputShippingMethod;
	}

	public int inputPostalCode() {
		printStream.format("�X�֔ԍ�7������͂��Ă��������B");
		Scanner postalScan = new Scanner(inputStream);
		int inputPostalCode = postalScan.nextInt();
		postalScan.close();
		return inputPostalCode;
	}

	public int inputArrivalDate() {
		printStream.format("��]����铞���w�������͂��Ă��������B�@��j20140410");
		Scanner arrivalDateScan = new Scanner(inputStream);
		int inputArrivalDate = arrivalDateScan.nextInt();
		arrivalDateScan.close();
		return inputArrivalDate;
	}

	public String inputTimeZone() {
		printStream.format("��]����鎞�ԑт�I�����Ă��������B�ߑO�A�ߌ�A�[��");
		Scanner timeZoneScan = new Scanner(inputStream);
		String inputTimeZone = timeZoneScan.next();
		timeZoneScan.close();
		return inputTimeZone;
	}

	public int inputMode() {
		printStream.format("�g�p�������@�\��I�����Ă��������B\n 1: �T�[�r�X�̈ꗗ��\��\n 2: �w������ɓ͂��������𒲂ׂ�\n 3: �ł������z���T�[�r�X�𒲂ׂ�");
		Scanner mode = new Scanner(inputStream);
		int inputMode = mode.nextInt();
		mode.close();

		return inputMode;
	}

	public void output(String output) {
		printStream.format(output);
	}
}
