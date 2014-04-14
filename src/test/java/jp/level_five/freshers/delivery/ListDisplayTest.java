package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ListDisplayTest {

	@Test
	public void test呼び出されたらサービスA改行サービスBと表示する() {
		ListDisplay listdisp = new ListDisplay();
		InputOutput output = new InputOutput();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		output.setPrintStream(printStream);
		output.output(listdisp.displayList());
		assertEquals("サービスA\nサービスB", outputStream.toString());
	}

}
