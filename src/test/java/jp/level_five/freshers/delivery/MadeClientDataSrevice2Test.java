package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;

public class MadeClientDataSrevice2Test {
	
	@Mocked
	InputStream mockedInputStream;

	@Test
	public void test入出力から発送方法の入力を受け取れる() {
		MadeClientDataService2 service2 = new MadeClientDataService2();
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
		MadeClientDataService2 service2 = new MadeClientDataService2();
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
		MadeClientDataService2 service2 = new MadeClientDataService2();
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
		MadeClientDataService2 service2 = new MadeClientDataService2();
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
		MadeClientDataService2 service2 = new MadeClientDataService2();
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
		MadeClientDataService2 service2 = new MadeClientDataService2();
		String inputString = "A 1234567 20140411 午前";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputString.getBytes());
		service2.setInputStream(inputStream);
		service2.inputClientData();
		ClientData client = service2.createClientData(service2.shippingMethod, service2.postalCode, service2.dateOfArrival, service2.timeZone);
		assertTrue(client instanceof ClientData);
	}
	
	
}
