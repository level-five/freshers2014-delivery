package jp.level_five.freshers.delivery;

import java.util.Calendar;

public class ShippingDataByServiceB {
	Calendar calendar = Calendar.getInstance();

	public boolean isHoliday(int dataOfArrival) {
		int year = Integer.parseInt(String.valueOf(dataOfArrival).substring(0,
				4));
		int month = Integer.parseInt(String.valueOf(dataOfArrival).substring(4,
				6)) - 1;
		int day = Integer.parseInt(String.valueOf(dataOfArrival)
				.substring(6, 8));

		calendar.set(year, month, day);
		int week = calendar.get(Calendar.DAY_OF_WEEK);

		int week1 = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

		if (week == 1) {
			return true;
		} else {
			switch (month) {
			case 0:
				if (day == 1)
					return true;
				if (week == 2 && week1 == 2)
					return true;

			case 1:
				if (day == 11)
					return true;
			case 2:
				if (day == 21)
					return true;
			case 3:
				if (day == 29)
					return true;
				
			case 4:
				if (day == 3)
					return true;
				if (day == 4)
					return true;
				if (day == 5)
					return true;
			case 6:
				if (week == 2 && week1 == 3)
					return true;
			case 8:
				if (week == 2 && week1 == 3)
					return true;
			case 9:
				if (week == 2 && week1 == 2)
					return true;
			case 10:
				if (day == 3)
					return true;
				if (day == 23)
					return true;
			case 11:
				if (day == 23)
					return true;
			}
			return false;
		}
	}

}
