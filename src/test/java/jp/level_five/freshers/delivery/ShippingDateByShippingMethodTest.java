package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ShippingDateByShippingMethodTest {

	private ShippingDateByShippingMethod testClass = null;
	private ByteArrayOutputStream byteArrayOutputStream = null;
	private PrintStream printStream = null;
	
	@Before
	public void setUp() {
		testClass = new ShippingDateByShippingMethod();
		
		// 出力先のオブジェクトを生成
		byteArrayOutputStream = new ByteArrayOutputStream();
		
		// PrintStreamオブジェクトを生成し、出力先をbyteArrayOutputStreamにする
		printStream = new PrintStream(byteArrayOutputStream);
		
		// I/Oクラスの標準出力先を切り替える
		testClass.io.setPrintStream(printStream);
	}
	
	@Test
	public void testInputOutputクラスのinputShippingMethodでAが入力されるとAが返る() {
		// ユーザーの入力
		String in = "A";
		
		// 文字列inのバイト配列をByteArrayInputStreamに流す
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		
		// InputOutputクラスの標準入力先をinputStreamにセットする
		testClass.io.setInputStream(inputStream);
		
		String actual = testClass.io.inputShippingMethod();
		
		assertEquals("A", actual);
	}
	@Test
	public void testInputOutputクラスのinputShippingMethodでbが入力されるとbが返る() {
		String in = "b";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());		
		testClass.io.setInputStream(inputStream);
		
		String actual = testClass.io.inputShippingMethod();
		
		assertEquals("b", actual);
	}
	@Test
	public void testInputOutputクラスのinputShippingMethodで字が入力されると字が返る() {
		String in = "字"; // 2バイト文字もOK
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);
		
		String actual = testClass.io.inputShippingMethod();
		
		assertEquals("字", actual);
	}
	@Test
	public void testInputOutputクラスのinputPostalCodeで1234567が入力されると1234567が返る() {
		String in = "1234567";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);
		
		int actual = testClass.io.inputPostalCode();
		
		assertEquals(1234567, actual);
	}
	@Test
	public void testInputOutputクラスのinputArrivalDateで20140411が入力されると20140411が返る() {
		String in = "20140411";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);
		
		int actual = testClass.io.inputArrivalDate();
		
		assertEquals(20140411, actual);
	}
	@Test
	public void testInputOutputクラスのinputTimeZoneで午前が入力されると午前が返る() {
		String in = "午前";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);
		
		String actual = testClass.io.inputTimeZone();
		
		assertEquals("午前", actual);
	}
	@Test
	public void testInputOutputクラスのinputTimeZoneで午後が入力されると午後が返る() {
		String in = "午後";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);
		
		String actual = testClass.io.inputTimeZone();
		
		assertEquals("午後", actual);
	}
	@Test
	public void testInputOutputクラスのinputClientDataを用いて値を取り出せる() {
		String in = "A 1234567 20140411 午前";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);
		
		testClass.inputClientData();
		
		assertEquals("A", testClass.getShippingMethod());
		assertEquals(1234567, testClass.getPostalCode());
		assertEquals(20140411, testClass.getDateOfArrival());
		assertEquals("午前", testClass.getTimeZone());
	}
	@Test
	public void testInputOutputクラスのinputClientDataを用いてClientDataオブジェクトを作成出来る() {
		String in = "A 1234567 20140411 午前";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);
		
		testClass.inputClientData();
		ClientData clientData = testClass.createClientData(
				testClass.getShippingMethod(),
				testClass.getPostalCode(),
				testClass.getDateOfArrival(),
				testClass.getTimeZone());
		
		assertTrue(clientData instanceof ClientData);
	}
	@Test
	public void testClientDataオブジェクトをShippingDateByServiceAクラスに渡すと発送日が返る() {
		String in = "A 1234567 20140411 午前";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);

		testClass.inputClientData();
		ClientData clientData = testClass.createClientData(
				testClass.getShippingMethod(),
				testClass.getPostalCode(),
				testClass.getDateOfArrival(),
				testClass.getTimeZone());
		String sendShippingDate = testClass.modeSelection(clientData);
		
		assertEquals("2014年4月10日午前、2014年4月10日午後", sendShippingDate);
	}
	@Test
	public void test作成したオブジェクトをShippingDateByServiceBクラスに渡すと発送日を表示させる() {
		String in = "B 7777777 20140414 午後";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);

		testClass.inputClientData();
		ClientData clientData = testClass.createClientData(
				testClass.getShippingMethod(),
				testClass.getPostalCode(),
				testClass.getDateOfArrival(),
				testClass.getTimeZone());
		String sendShippingDate = testClass.modeSelection(clientData);
		
		assertEquals("2014年4月13日午前、2014年4月13日午後", sendShippingDate);
	}
	@Test
	public void test作成したオブジェクトをShippingDateOfLowestCostクラスに渡すと最安値の発送日が出力される() {
		String in = "7777777 20140414 午後";
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(in.getBytes());
		testClass.io.setInputStream(inputStream);

		testClass.inputClientDataWithoutShippingMethod();
		ClientData clientData = testClass.createClientData(
				"",
				testClass.getPostalCode(),
				testClass.getDateOfArrival(),
				testClass.getTimeZone());
		String sendShippingDate = testClass.modeSelection(clientData);
		
		assertEquals("配送サービスB、2014年4月13日午前、2014年4月13日午後", sendShippingDate);
	}
	@Test
	public void test文字列が出力されているかを確認するテスト() {
		String msg = "Hello";
		testClass.io.output(msg);
		
		String actual = byteArrayOutputStream.toString();
		
		assertEquals(msg, actual);
	}
}
