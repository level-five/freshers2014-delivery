package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShippingDateByServiceATest {
	ShippingDateByServiceA service ;
	@Before
	public void setUp(){service = new ShippingDateByServiceA();}


	@Test
	public void test郵便番号が１で２０１４年４月９日夕方が到着日の時を渡すとStringBuilder型で発送日が返ってくる() {
		StringBuilder sb = service.preSendShippingDate(1, 20140409, "夕方");
		String str ="２０１４年４月８日午前、２０１４年４月８日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が８で２０１４年4月9日午後が到着日の時を渡すとStringBuilder型で発送日が返ってくる(){
		StringBuilder sb = service.preSendShippingDate(8, 20140409, "午後");
		String str ="２０１４年４月８日午前、２０１４年４月７日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が９で２０１４年4月9日午後が到着日の時を渡すとStringBuilder型で発送日が返ってくる(){
		StringBuilder sb = service.preSendShippingDate(9, 20140409, "午後");
		String str = "配送不可";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が３で２０１４年4月9日午後が到着日の時を渡すとStringBuilder型で発送日が返ってくる(){
		StringBuilder sb = service.preSendShippingDate(3, 20140409, "午後");
		String str ="２０１４年４月８日午前、２０１４年４月８日午後";
		assertEquals(str, sb.toString());
	}
	}
