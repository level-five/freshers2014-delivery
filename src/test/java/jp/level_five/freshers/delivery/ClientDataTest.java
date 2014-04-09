package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientDataTest {
	ClientData clientData = null;

	@Before
	public void before() {
		clientData = new ClientData();
	}

	@Test
	public void testchar型AをcheckDataOfArrivalに渡すと例外が発生しない() {
		clientData.checkDataOfArrival('A');
	}

	@Test(expected = RuntimeException.class)
	public void testchar型XをcheckDataOfArrivalに渡すと例外が発生する() {
		clientData.checkDataOfArrival('X');
	}

	@Test
	public void testchar型bをcheckDataOfArrivalに渡すと例外が発生しない() {
		clientData.checkDataOfArrival('b');
	}

	@Test(expected = RuntimeException.class)
	public void testchar型1をcheckDataOfArrivalに渡すと例外が発生する() {
		clientData.checkDataOfArrival('1');
	}

	@Test(expected = RuntimeException.class)
	public void testchar型アンドをcheckDataOfArrivalに渡すと例外が発生する() {
		clientData.checkDataOfArrival('＆');
	}

}
