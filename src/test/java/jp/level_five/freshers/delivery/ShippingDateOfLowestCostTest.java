package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShippingDateOfLowestCostTest {

	ShippingDateOfLowestCost lowestService = null;

	@Before
	public void setUp() {
		lowestService = new ShippingDateOfLowestCost();
	}

	@Test
	public void testShippingDateByServiceBクラスのisHolidayに20140413を渡すとtrueが返る() {
		// 20140413は日曜日
		ShippingDateByServiceB obj = new ShippingDateByServiceB();
		assertTrue(obj.isHoliday(20140413));
	}
	@Test
	public void testgetServiceOfLowestCostに渡された日付が日曜祝日なら文字列Aが返る() {
		int arrivalDate = 20140413;
		String expected = "A";
		String actual = lowestService.getServiceOfLowestCost(arrivalDate);

		assertEquals(expected, actual);
	}
	@Test
	public void testgetServiceOfLowerCostに渡された日付が平日なら文字列Bが返る(){
		int arrivalDate = 20140411;
		String expected = "B";
		String actual = lowestService.getServiceOfLowestCost(arrivalDate);

		assertEquals(expected, actual);
	}
	@Test
	public void testgetServiceOfLowerCostに1から始まる郵便番号と平日の到着日と夕方からなるClientDataオブジェクトを渡すと文字列Bが返る() {
		ClientData clientData = new ClientData("", 1000000, 20140411, "夕方");
		String expected = "B";
		String actual = lowestService.getServiceOfLowerCost(clientData);

		assertEquals(expected, actual);
	}
	@Test
	public void testgetServiceOfLowerCostに1から始まる郵便番号と休日の到着日と夕方からなるClientDataオブジェクトを渡すと文字列Bが返る(){
		ClientData clientData = new ClientData("", 1000000, 20140413, "夕方");
		String expected = "A";
		String actual = lowestService.getServiceOfLowerCost(clientData);

		assertEquals(expected, actual);
	}
	@Test
	public void testgetServiceOfLowerCostに9から始まる郵便番号と休日の到着日と夕方からなるClientDataオブジェクトを渡すと文字列配送不可が返る(){
		ClientData clientData = new ClientData("", 9000000, 20140413, "夕方");
		String expected = "配送不可";
		String actual = lowestService.getServiceOfLowerCost(clientData);

		assertEquals(expected, actual);
	}
	@Test
	public void testgetServiceOfLowerCostに1から始まる郵便番号と2010411と夕方からなるClientDataオブジェクトを渡すと発送日20140410午前と20140410午後が返る(){
		// 20140411は平日
		ClientData clientData = new ClientData("", 1000000, 20140411, "夕方");
		
		String expected = "配送サービスB、2014年4月11日午前、2014年4月10日午後";
		String actual = lowestService.preSendShippingDate(clientData);
		
		assertEquals(expected, actual);
	}
	@Test
	public void testgetServiceOfLowerCostに9から始まる郵便番号と2010411と夕方からなるClientDataオブジェクトを渡すと発送日20140408午前と20140408午後が返る(){
		// 20140411は平日
		ClientData clientData = new ClientData("", 9000000, 20140411, "夕方");
		
		String expected = "配送サービスB、2014年4月8日午前、2014年4月8日午後";
		String actual = lowestService.preSendShippingDate(clientData);
		
		assertEquals(expected, actual);
	}
	@Test
	public void testgetServiceOfLowerCostに9から始まる郵便番号と2010413と夕方からなるClientDataオブジェクトを渡すと配送不可(){
		// 20140413は日曜
		ClientData clientData = new ClientData("", 9000000, 20140413, "夕方");
		
		String expected = "配送不可";
		String actual = lowestService.preSendShippingDate(clientData);
		
		assertEquals(expected, actual);
	}
	@Test
	public void testgetServiceOfLowerCostに1から始まる郵便番号と2010413と夕方からなるClientDataオブジェクトを渡すと発送日20140412午前と20140412午後が返る(){
		// 20140413は日曜
		ClientData clientData = new ClientData("", 1000000, 20140413, "夕方");
		
		String expected = "配送サービスA、2014年4月12日午前、2014年4月12日午後";
		String actual = lowestService.preSendShippingDate(clientData);
		
		assertEquals(expected, actual);
	}

}
