package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShippingDateByServiceBTest {
	ShippingDateByServiceB shippingDateByServiceB = null;
	@Before
	public void setUp(){
		shippingDateByServiceB = new ShippingDateByServiceB();
	}

	@Test
	public void test到着日20140413は日曜日なのでholidayはture() {
		int dataOfArrival = 20140413;
		boolean holiday =shippingDateByServiceB.isHoliday(dataOfArrival);
		assertTrue(holiday);
	}
	

	@Test
	public void test到着日20140419は土曜日なのでholidayはfalse() {
		int dataOfArrival = 20140419;
		boolean holiday =shippingDateByServiceB.isHoliday(dataOfArrival);
		assertFalse(holiday);
	}
	@Test
	public void test到着日20140101は元日で祝日なのでholidayはture(){
		int dataOfArrival = 20140101;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140211は建国記念日で祝日なのでholidayはture(){
		int dataOfArrival = 20140211;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140429は昭和の日で祝日なのでholidayはture(){
		int dataOfArrival = 20140429;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140503は憲法記念日で祝日なのでholidayはture(){
		int dataOfArrival = 20140503;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20130504はみどりの日で祝日なのでholidayはture(){
		int dataOfArrival = 20130504;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140505はこどもの日で祝日なのでholidayはture(){
		int dataOfArrival = 20140505;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20141103は文化の日で祝日なのでholidayはture(){
		int dataOfArrival = 20141103;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20131123は勤労感謝の日で祝日なのでholidayはture(){
		int dataOfArrival = 20131123;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20131223は天皇誕生日で祝日なのでholidayはture(){
		int dataOfArrival = 20131223;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140113は成人の日で祝日なのでholidayはture(){
		int dataOfArrival = 20140113;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140721は海の日で祝日なのでholidayはture(){
		int dataOfArrival = 20140721;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140915は敬老の日で祝日なのでholidayはture(){
		int dataOfArrival = 20140915;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20141013は体育の日で祝日なのでholidayはture(){
		int dataOfArrival = 20141013;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140321は春分の日で祝日なのでholidayはtrue(){
		int dataOfArrival = 20140321;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival);
		assertTrue(holiday);	
	}
	@Test
	public void test到着日20140923は秋分の日で祝日なのでholidayはtrue(){
		int dataOfArrival = 20140923;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival);
		assertTrue(holiday);
	}
	@Test
	public void test到着日20150923は秋分の日で祝日なのでholidayはtrue(){
		int dataOfArrival = 20150923;
		boolean holiday = shippingDateByServiceB.isHoliday(dataOfArrival);
		assertTrue(holiday);
	}
	
	@Test
	public void test郵便番号が1で始まり2014年4月11日夕方が到着日に指定されたときに2014年4月11日午前と2014年4月10日午後が返る() {
		// 2014年4月11日は平日金曜日
		String sb = shippingDateByServiceB.preSendShippingDate(1, 20140411, "夕方");
		String str = "2014年4月11日午前、2014年4月10日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が5で始まり2014年4月11日夕方が到着日に指定されたときに2014年4月10日午前と2014年4月10日午後が返る(){
		String sb = shippingDateByServiceB.preSendShippingDate(5, 20140411, "夕方");
		String str = "2014年4月10日午前、2014年4月10日午後";
		assertEquals(str, sb.toString());
	}
	@Test
	public void test郵便番号が9で始まり2014年4月11日夕方が到着日に指定されたときに2014年4月10日午前と2014年4月10日午後が返る(){
		String sb = shippingDateByServiceB.preSendShippingDate(9, 20140411, "夕方");
		String str = "2014年4月8日午前、2014年4月8日午後";
		assertEquals(str, sb.toString());
	}
	@Test(expected = RuntimeException.class)
	public void test郵便番号が1で始まり2014年4月13日夕方が到着日に指定されたときに例外が返る() {
		// 2014年4月13日は日曜
	    String sb = shippingDateByServiceB.preSendShippingDate(1, 20140413, "夕方");
	}
	@Test(expected = RuntimeException.class)
	public void test郵便番号が1で始まり2014年4月29日夕方が到着日に指定されたときに例外が返る() {
		// 2014年4月29日は祝日
		String sb = shippingDateByServiceB.preSendShippingDate(1, 20140413, "夕方");
	}
	@Test
	public void test郵便番号が1で2014年4月11日夕方が到着日のデータが入ったClientDataのオブジェクトを受け取って2014年4月11日午前と2014年4月10日午後が返る(){
		ClientData clientData = new ClientData("B", 1000000, 20140411, "夕方");
		String sb = shippingDateByServiceB.sendShippingDate(clientData);
		String str = "2014年4月11日午前、2014年4月10日午後";
		assertEquals(str, sb.toString());	
	}
	@Test(expected = RuntimeException.class)
	public void test郵便番号が1で2014年4月29日夕方が到着日のデータが入ったClientDataのオブジェクトを受け取って2014年4月11日午前と2014年4月10日午後が返る(){
		ClientData clientData = new ClientData("B", 1000000, 20140429, "夕方");
		String sb = shippingDateByServiceB.sendShippingDate(clientData);			
	}
	@Test
	public void test郵便番号が1で2014年4月1日夕方が到着日のデータが入ったClientDataのオブジェクトを受け取って2014年4月1日午前と2014年3月31日午後が返る(){
		ClientData clientData = new ClientData("B", 1000000, 20140401, "夕方");
		String sb = shippingDateByServiceB.sendShippingDate(clientData);
		String str = "2014年4月1日午前、2014年3月31日午後";
		assertEquals(str, sb.toString());	
	}
	@Test
	public void test郵便番号が9で2014年1月3日夕方が到着日のデータが入ったClientDataのオブジェクトを受け取って2013年12月31日午前と2014年12月31日午後が返る(){
		ClientData clientData = new ClientData("B", 9000000, 20140103, "夕方");
		String sb = shippingDateByServiceB.sendShippingDate(clientData);
		String str = "2013年12月31日午前、2013年12月31日午後";
		assertEquals(str, sb.toString());	
	} 
}
