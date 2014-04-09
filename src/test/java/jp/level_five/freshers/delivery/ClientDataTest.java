package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientDataTest {
	ClientData clientData = null;

	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がZと1234567と12345678と午前のとき例外を返す() {
		clientData = new ClientData('Z', 1234567, 12345678, "午前");
	}

	@Test
	public void testインスタンス化時の引数がAと1234567と12345678と午前のときgetShippingMethodでAが返る() {
		clientData = new ClientData('A', 1234567, 12345678, "午前");
		assertEquals(clientData.getShippingMethod(), 'A');
	}

	@Test
	public void testインスタンス化時の引数がbと1234567と12345678と午前のときgetShippingMethodでBが返る() {
		clientData = new ClientData('b', 1234567, 12345678, "午前");
		assertEquals(clientData.getShippingMethod(), 'B');
	}

	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数が1と1234567と12345678と午前のとき例外が発生する() {
		clientData = new ClientData('1', 1234567, 12345678, "午前");
	}

}
