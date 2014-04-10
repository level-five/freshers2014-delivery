package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MadeClientDataTest {
	private MadeClientData madeClientData = null;
	@Before
	public void setup() {
		madeClientData = new MadeClientData();
	}

	@Test
	public void test配送方法は初期値では空白が入っている() {
		char a = madeClientData.shippingmethod;
		assertEquals(a, ' ');
	}

	@Test
	public void test郵便番号の初期値は０が入っている() {
		int b = madeClientData.postalCode;
		assertEquals(b, 0);
	}
	@Test
	public void test到着日の初期値は０が入っている() {
		int c = madeClientData.dataOfArrival;
		assertEquals(c, 0);
	}
	@Test
	public void test時間帯の初期値は０が入っている() {
		int d = madeClientData.timeZone;
		assertEquals(d, 0);
	}
	@Test
	public void test配送方法に文字のAをセットすることができる(){
		madeClientData.setShippingMethod('A');
		char c = madeClientData.shippingmethod;
		assertEquals(c, 'A');
	}
	@Test
	public void test郵便番号に数字の1000000をセットすることができる(){
		madeClientData.setpostalCode(1000000);
		int b = madeClientData.postalCode;
		assertEquals(b, 1000000);
	}
	@Test
	public void test到着日に数字の20140411をセットすることができる(){
		madeClientData.setdataOfArrival(20140411);
		assertEquals(madeClientData.dataOfArrival, 20140411);
	}

}
