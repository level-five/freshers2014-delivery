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
	}
}
