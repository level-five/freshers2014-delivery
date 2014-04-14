package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ShippingDateByShippingMethodTest {

	@Test
	public void test入出力から発送方法の入力を受け取れる() {
		ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
		String inputString = "A";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputString.getBytes());
		service2.setInputStream(inputStream);
		service2.inputShippingMethod();
		String shippingMethod = service2.shippingMethod;
		assertEquals("A", shippingMethod);
	}

	@Test
	public void test入出力から郵便番号の入力を受け取れる() {
		ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
		String inputPostalCode = "1234567";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputPostalCode.getBytes());
		service2.setInputStream(inputStream);
		service2.inputPostalCode();
		int postalCode = service2.postalCode;
		assertEquals(1234567, postalCode);
	}

	@Test
	public void test入出力から到着日の入力を受け取れる() {
		ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
		String inputDateOfArrival = "20140411";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputDateOfArrival.getBytes());
		service2.setInputStream(inputStream);
		service2.inputDateOfArrival();
		int DateOfArrival = service2.dateOfArrival;
		assertEquals(20140411, DateOfArrival);
	}

	@Test
	public void test入出力から時間帯の入力を受け取れる() {
		ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
		String inputTimeZone = "午前";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputTimeZone.getBytes());
		service2.setInputStream(inputStream);
		service2.inputTimeZone();
		String timeZone = service2.timeZone;
		assertEquals("午前", timeZone);
	}

	@Test
	public void test入出力から発送方法＿郵便番号＿到着日＿時間帯を受け取ることができる() {
		ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
		String inputString = "A 1234567 20140411 午前";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputString.getBytes());
		service2.setInputStream(inputStream);
		service2.inputClientData();
		assertEquals("A", service2.shippingMethod);
		assertEquals(1234567, service2.postalCode);
		assertEquals(20140411, service2.dateOfArrival);
		assertEquals("午前", service2.timeZone);
	}

	@Test
	public void test４つのデータからClientDataのオブジェクトを作成できる() {
		ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
		String inputString = "A 1234567 20140411 午前";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputString.getBytes());
		service2.setInputStream(inputStream);
		service2.inputClientData();
		ClientData client = service2.createClientData(service2.shippingMethod,
				service2.postalCode, service2.dateOfArrival, service2.timeZone);
		assertTrue(client instanceof ClientData);
	}

	@Test
	public void test作成したオブジェクトをShippingDateByServiceAクラスに渡すと発送日が返る() {
		ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
		String inputString = "A 1234567 20140414 午前";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputString.getBytes());
		service2.setInputStream(inputStream);
		service2.inputClientData();
		ClientData client = service2.createClientData(service2.shippingMethod,
				service2.postalCode, service2.dateOfArrival, service2.timeZone);
		String sendShippingDate = service2.modeSelection(client);
		assertEquals("2014年4月13日午前、2014年4月13日午後", sendShippingDate);
	}
	
	@Test
	public void test作成したオブジェクトをShippingDateByServiceBクラスに渡すと発送日を表示させる() {
		ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
		String inputString = "B 7777777 20140414 午後";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputString.getBytes());
		service2.setInputStream(inputStream);
		service2.inputClientData();
		ClientData client = service2.createClientData(service2.shippingMethod,
				service2.postalCode, service2.dateOfArrival, service2.timeZone);
		String sendShippingDate = service2.modeSelection(client);
		InputOutput output = new InputOutput();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		output.setPrintStream(printStream);
		output.output(sendShippingDate);
		assertEquals("2014年4月13日午前、2014年4月13日午後", outputStream.toString());
		
	}
}
