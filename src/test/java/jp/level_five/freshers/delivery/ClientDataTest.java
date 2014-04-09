package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientDataTest {
	ClientData clientData = null;

	@Test(expected = RuntimeException.class)
	public void testインスタンス化時の引数がZと1234567と12345678と午前のとき例外を返す(){
		clientData = new ClientData('Z',1234567,12345678,"午前");
}
}