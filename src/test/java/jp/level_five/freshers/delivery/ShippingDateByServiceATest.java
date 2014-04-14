package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShippingDateByServiceATest {
	ShippingDateByServiceA service;

	@Before
	public void setUp() {
		service = new ShippingDateByServiceA();
		}

	@Test
	public void test郵便番号が１で2014年４月９日夕方が到着日の時を渡すとStringBuilder型で発送日が返ってくる() {
		String sb = service.preSendShippingDate(1, 20140409, "夕方");
		String str = "2014年4月8日午前、2014年4月8日午後";
		assertEquals(str, sb.toString());
	}

	@Test
	public void test郵便番号が８で2014年04月09日午後が到着日の時を渡すとStringBuilder型で発送日が返ってくる() {
		String sb = service.preSendShippingDate(8, 20140409, "午後");
		String str = "2014年4月7日午前、2014年4月7日午後";
		assertEquals(str, sb.toString());
	}

	@Test
	public void test郵便番号が９で2014年04月09日午後が到着日の時を渡すとStringBuilder型で発送日が返ってくる() {
		String sb = service.preSendShippingDate(9, 20140409, "午後");
		String str = "配送不可";
		assertEquals(str, sb.toString());
	}

	@Test
	public void test郵便番号が３で2014年4月9日午後が到着日の時を渡すとStringBuilder型で発送日が返ってくる() {
		String sb = service.preSendShippingDate(3, 20140409, "午後");
		String str = "2014年4月8日午前、2014年4月8日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が1で2014年4月9日午前が到着日の時を渡すと20140407午後と20140408午前で発送日が返ってくる() {
		String sb = service.preSendShippingDate(1, 20140409, "午前");
		String str = "2014年4月8日午前、2014年4月7日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が1で2014年4月1日午前が到着日の時を渡すと20140331午前と201400330午後で発送日が返ってくる() {
		String sb = service.preSendShippingDate(1, 20140401, "午前");
		String str = "2014年3月31日午前、2014年3月30日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が1で2014年4月1日午後が到着日の時を渡すと20140331午前と201400330午後で発送日が返ってくる() {
		String sb = service.preSendShippingDate(1, 20140401, "午後");
		String str = "2014年3月31日午前、2014年3月31日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が1で2014年3月1日午後が到着日の時を渡すと20140228午前と201400228午後で発送日が返ってくる() {
		String sb = service.preSendShippingDate(1, 20140301, "午後");
		String str = "2014年2月28日午前、2014年2月28日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が1で2014年1月1日午後が到着日の時を渡すと20131231午前と20131231午後で発送日が返ってくる() {
		String sb = service.preSendShippingDate(1, 20140101, "午後");
		String str = "2013年12月31日午前、2013年12月31日午後";
		assertEquals(str, sb.toString());
		}
	@Test
	public void test郵便番号が1で2014年1月1日午後が到着日のデータが入ったClientDataのオブジェクトを受け取って20131231午前と20131231午後で発送日を返す(){
		ClientData clientData = new ClientData("A", 1000000, 20140101, "午後");
		String sb = service.sendShippingDate(clientData);
		String str = "2013年12月31日午前、2013年12月31日午後";
		assertEquals(str, sb.toString());	
	}
}