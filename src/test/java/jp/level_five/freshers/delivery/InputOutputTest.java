package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class InputOutputTest {
	InputOutput inputOutput = null;
	ByteArrayOutputStream outputStream = null;
	
	@Before
	public void before(){
		inputOutput = new InputOutput();

		outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		inputOutput.setPrintStream(printStream);
	}

	@Test
	public void test文字Aを入力すると文字型でAが返ってくる() {		
		String inputString = "A";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputString.getBytes());
		inputOutput.setInputStream(inputStream);

		String input = inputOutput.inputShippingMethod();

		assertEquals("A", input);
		assertEquals("配送方法を選択してください。　A　または　B", outputStream.toString());
	}

	@Test 
	public void test郵便番号1000000を入力すると1000000が返ってくる(){
		String inputcode = "1000000";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(inputcode.getBytes());
		inputOutput.setInputStream(inputStream);
		int input = inputOutput.inputPostalCode();
		assertEquals(1000000, input);
		assertEquals("郵便番号7桁を入力してください。",outputStream.toString());
	}
	
	@Test
	public void test到着日20140410を入力すると20140410が返ってくる(){
		String inputArrival = "20140410";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(inputArrival.getBytes());
		inputOutput.setInputStream(inputStream);
		int input = inputOutput.inputArrivalDate();
		assertEquals(20140410, input);
		assertEquals("希望される到着指定日を入力してください。　例）20140410",outputStream.toString());
	}
	
	@Test
	public void test配達指定時間帯の選択午前を選択すると午前が返ってくる(){
		String inputTimeZone = "午前";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(inputTimeZone.getBytes());
		inputOutput.setInputStream(inputStream);
		String input = inputOutput.inputTimeZone();
		assertEquals("午前",input);
		assertEquals("希望される時間帯を選択してください。午前、午後、夕方",outputStream.toString());
	}
}
