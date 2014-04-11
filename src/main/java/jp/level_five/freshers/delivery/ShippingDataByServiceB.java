package jp.level_five.freshers.delivery;

import java.util.Calendar;

public class ShippingDataByServiceB {
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

}
