package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientDataTest {
	ClientData clientData = null;

	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がZと1234567と12340410と午前のとき例外を返す() {
		clientData = new ClientData("Z", 1234567, 12340410, "午前");
	}

	@Test
	public void testインスタンス化時の引数がAと1234567と12340410と午前のときgetShippingMethodでAが返る() {
		clientData = new ClientData("A", 1234567, 12340410, "午前");
		assertEquals(clientData.getShippingMethod(), "A");
	}

	@Test
	public void testインスタンス化時の引数がbと1234567と12340410と午前のときgetShippingMethodでBが返る() {
		clientData = new ClientData("b", 1234567, 12340410, "午前");
		assertEquals(clientData.getShippingMethod(), "B");
	}

	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数が1と1234567と12340410と午前のとき例外が発生する() {
		clientData = new ClientData("1", 1234567, 12340410, "午前");
	}

	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がAAと1234567と12340410と午前のとき例外が発生する() {
		clientData = new ClientData("AA", 1234567, 12340410, "午前");
	}
	@Test 
	public void testインスタンス化時の引数が空文字と1234567と12340410と午前のときgetShippingMethodで空文字が返る(){
		clientData = new ClientData("", 1234567, 12340410, "午前");
		assertEquals("", clientData.getShippingMethod());
	}

	@Test
	public void testインスタンス化時の引数がAと1234567と12340410と午前のときgetPostalCodeで1が返る() {
		clientData = new ClientData("A", 1234567, 12340410, "午前");
		assertEquals(clientData.getPostalCode(), 1);
	}
	
	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がAと12345678と12340410と午前のときgetPostalCodeで例外が発生する() {
		clientData = new ClientData("A", 12345678, 12340410, "午前");
	}
	
	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がAと987654と12340410と午前のときgetPostalCodeで例外が発生する() {
		clientData = new ClientData("A", 987654, 12340410, "午前");
	}
	@Test
	public void testインスタンス化時の引数がAと1234567と12340410と午前のときgetDateOfArrivalで12345678が返ってくる() {
		clientData = new ClientData("A", 1234567, 12340410, "午前");
		assertEquals(12340410, clientData.getDateOfArrival());
	}
	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がAと1234567と123456789と午前のとき例外が発生する() {
		clientData = new ClientData("A", 1234567, 123456789, "午前");
	}
	@Test
	public void testインスタンス化時の引数がAと1234567と20160229と午前のときisLeapYearはtrueを返す() {
		clientData = new ClientData("A", 1234567, 20160229, "午前");
		assertTrue(clientData.isLeapYear());
	}
	@Test
	public void testインスタンス化時の引数がAと1234567と21000228と午前のときisLeapYearはtrueを返す() {
		clientData = new ClientData("A", 1234567, 21000228, "午前");
		assertFalse(clientData.isLeapYear());
	}
	@Test
	public void testインスタンス化時の引数がAと1234567と20000228と午前のときisLeapYearはtrueを返す() {
		clientData = new ClientData("A", 1234567, 20000228, "午前");
		assertTrue(clientData.isLeapYear());
	}
	@Test
	public void testインスタンス化時の引数がAと1234567と20140228と午前のときisLeapYearはtrueを返す() {
		clientData = new ClientData("A", 1234567, 20000228, "午前");
		assertTrue(clientData.isLeapYear());
	}
	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がAと1234567と20141328と午前のとき例外が発生する() {
		clientData = new ClientData("A", 1234567, 20141328, "午前");
	}
	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がAと1234567と20140132と午前のとき例外が発生する() {
		clientData = new ClientData("A", 1234567, 20140132, "午前");
	}
	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がAと1234567と20140229と午前のとき例外が発生する() {
		clientData = new ClientData("A", 1234567, 20140229, "午前");
	}
	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がAと1234567と20140431と午前のとき例外が発生する() {
		clientData = new ClientData("A", 1234567, 20140431, "午前");
	}
	
}
