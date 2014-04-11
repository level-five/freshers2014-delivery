package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShippingDataByServiceBTest {
	ShippingDataByServiceB shippingDataByServiceB = null;
	@Before
	public void setUp(){
		shippingDataByServiceB = new ShippingDataByServiceB();
	}

	@Test
	public void test到着日20140413は日曜日なのでholidayはture() {
		int dataOfArrival = 20140413;
		boolean holiday =shippingDataByServiceB.isHoliday(dataOfArrival);
		assertTrue(holiday);
	}
	
	
	@Test
	public void test到着日20140419は土曜日なのでholidayはfalse() {
		int dataOfArrival = 20140419;
		boolean holiday =shippingDataByServiceB.isHoliday(dataOfArrival);
		assertFalse(holiday);
	}
	@Test
	public void test到着日20140101は元日で祝日なのでholidayはture(){
		int dataOfArrival = 20140101;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140211は建国記念日で祝日なのでholidayはture(){
		int dataOfArrival = 20140211;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140429は昭和の日で祝日なのでholidayはture(){
		int dataOfArrival = 20140429;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140503は憲法記念日で祝日なのでholidayはture(){
		int dataOfArrival = 20140503;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20130504はみどりの日で祝日なのでholidayはture(){
		int dataOfArrival = 20130504;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140505はこどもの日で祝日なのでholidayはture(){
		int dataOfArrival = 20140505;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20141103は文化の日で祝日なのでholidayはture(){
		int dataOfArrival = 20141103;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20131123は勤労感謝の日で祝日なのでholidayはture(){
		int dataOfArrival = 20131123;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20131223は天皇誕生日で祝日なのでholidayはture(){
		int dataOfArrival = 20131223;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140113は成人の日で祝日なのでholidayはture(){
		int dataOfArrival = 20140113;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140721は海の日で祝日なのでholidayはture(){
		int dataOfArrival = 20140721;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140915は敬老の日で祝日なのでholidayはture(){
		int dataOfArrival = 20140915;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20141013は体育の日で祝日なのでholidayはture(){
		int dataOfArrival = 20141013;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival) ;
		assertTrue(holiday);
	}
	@Test
	public void test到着日20140321は春分の日で祝日なのでholidayはtrue(){
		int dataOfArrival = 20140321;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival);
		assertTrue(holiday);	
	}
	@Test
	public void test到着日20140923は秋分の日で祝日なのでholidayはtrue(){
		int dataOfArrival = 20140923;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival);
		assertTrue(holiday);
	}
	@Test
	public void test到着日20150923は秋分の日で祝日なのでholidayはtrue(){
		int dataOfArrival = 20150923;
		boolean holiday = shippingDataByServiceB.isHoliday(dataOfArrival);
		assertTrue(holiday);
	}
}
