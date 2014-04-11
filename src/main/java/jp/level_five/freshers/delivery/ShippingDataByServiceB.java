package jp.level_five.freshers.delivery;

import java.util.Calendar;

public class ShippingDataByServiceB extends ShippingDateByServiceA {
	Calendar calendar = Calendar.getInstance();

	public boolean isHoliday(int dataOfArrival) {
		int year = Integer.parseInt(String.valueOf(dataOfArrival).substring(0, 4));
		int month = Integer.parseInt(String.valueOf(dataOfArrival).substring(4,	6)) - 1;
		int day = Integer.parseInt(String.valueOf(dataOfArrival).substring(6, 8));

		calendar.set(year, month, day);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

		if (dayOfWeek == Calendar.SUNDAY) {
			return true;
		} else {
			switch (month) {
			case Calendar.JANUARY:
				if (day == 1)
					return true;
				if (dayOfWeek == Calendar.MONDAY && dayOfWeekInMonth == 2)
					return true;
				break;

			case Calendar.FEBRUARY:
				if (day == 11)
					return true;
				break;

			case Calendar.MARCH:
				if (day == 21)
					return true;
				break;

			case Calendar.APRIL:
				if (day == 29)
					return true;
				break;

			case Calendar.MAY:
				if (day == 3)
					return true;
				if (day == 4)
					return true;
				if (day == 5)
					return true;
				break;

			case Calendar.JUNE:
				break;

			case Calendar.JULY:
				if (dayOfWeek == Calendar.MONDAY && dayOfWeekInMonth == 3)
					return true;
				break;
			case Calendar.AUGUST:
				break;

			case Calendar.SEPTEMBER:
				if (day == 23)
					return true;
				if (dayOfWeek == Calendar.MONDAY && dayOfWeekInMonth == 3)
					return true;
				break;

			case Calendar.OCTOBER:
				if (dayOfWeek == Calendar.MONDAY && dayOfWeekInMonth == 2)
					return true;
				break;

			case Calendar.NOVEMBER:
				if (day == 3)
					return true;
				if (day == 23)
					return true;
				break;

			case Calendar.DECEMBER:
				if (day == 23)
					return true;
				break;
			}

			return false;
		}
	}
	public String preSendShippingDate(int postalCode, int arrivalDate, String string) {
		int[] shippingDate = {
				arrivalDate / 10000,		//amYear
				arrivalDate % 10000 / 100,	//amMonth
				arrivalDate % 100,			//amDay
				arrivalDate / 10000,		//pmYear
				arrivalDate % 10000 / 100,	//pmMonth
				arrivalDate % 100			//pmDay
				};

		if(isHoliday(arrivalDate)){
			throw new RuntimeException("到着指定日が日曜・祝日です");
		}
		
		if (1 <= postalCode && postalCode <= 4)
			setShippingDateByCalendarSubstruction(shippingDate, 0, 1);
		else if (5 <= postalCode && postalCode <= 8)
			setShippingDateByCalendarSubstruction(shippingDate, 1, 1);
		else if (postalCode == 9)
			setShippingDateByCalendarSubstruction(shippingDate, 3, 3);
		
		StringBuilder shippingData = new StringBuilder();

		shippingData.append(shippingDate[0] + "年"+ shippingDate[1]  + "月"+ shippingDate[2] + "日"+ "午前" + "、");
		shippingData.append(shippingDate[3] + "年"+ shippingDate[4]  + "月"+ shippingDate[5] + "日"+ "午後");

		return shippingData.toString();
	}
	
	private void setShippingDateByCalendarSubstruction(int[] shippingDate, int amSubstructionNumber, int pmSubstructionNumber) {
		calendar.set(shippingDate[0], shippingDate[1] - 1, shippingDate[2]);
		calendar.add(Calendar.DAY_OF_MONTH, -amSubstructionNumber);
		
		shippingDate[0] = calendar.get(Calendar.YEAR);
		shippingDate[1] = calendar.get(Calendar.MONTH) + 1;
		shippingDate[2] = calendar.get(Calendar.DATE);
		
		calendar.set(shippingDate[3], shippingDate[4] - 1, shippingDate[5]);
		calendar.add(Calendar.DAY_OF_MONTH, -pmSubstructionNumber);
		
		shippingDate[3] = calendar.get(Calendar.YEAR);
		shippingDate[4] = calendar.get(Calendar.MONTH) + 1;
		shippingDate[5] = calendar.get(Calendar.DATE);
	}
}
