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
	public void test�z�����@�͏����l�ł͋󔒂������Ă���() {
		char a = madeClientData.shippingmethod;
		assertEquals(a, ' ');
	}

	@Test
	public void test�X�֔ԍ��̏����l�͂O�������Ă���() {
		int b = madeClientData.postalCode;
		assertEquals(b, 0);
	}
	@Test
	public void test�������̏����l�͂O�������Ă���() {
		int c = madeClientData.dataOfArrival;
		assertEquals(c, 0);
	}
	@Test
	public void test���ԑт̏����l�͂O�������Ă���() {
		int d = madeClientData.timeZone;
		assertEquals(d, 0);
	}
	@Test
	public void test�z�����@�ɕ�����A���Z�b�g���邱�Ƃ��ł���(){
		madeClientData.setShippingMethod('A');
		char c = madeClientData.shippingmethod;
		assertEquals(c, 'A');
	}
	@Test
	public void test�X�֔ԍ��ɐ�����1000000���Z�b�g���邱�Ƃ��ł���(){
		madeClientData.setpostalCode(1000000);
		int b = madeClientData.postalCode;
		assertEquals(b, 1000000);
	}
	@Test
	public void test�������ɐ�����20140411���Z�b�g���邱�Ƃ��ł���(){
		madeClientData.setdataOfArrival(20140411);
		assertEquals(madeClientData.dataOfArrival, 20140411);
	}

}
