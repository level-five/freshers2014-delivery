package jp.level_five.freshers.delivery;

public class ShippingDateByServiceA {

	public String preSendShippingDate(int postalCode, int arrivalDate, String string) {
		int[] shippingDate = new int[6];
		shippingDate[0] = arrivalDate / 10000;//amYear
		shippingDate[1] = arrivalDate % 10000 / 100;//amMonth
		shippingDate[2] = arrivalDate % 100;//amDay
		shippingDate[3] = arrivalDate / 10000;//pmYear
		shippingDate[4] = arrivalDate % 10000 / 100;//pmMonth
		shippingDate[5] = arrivalDate % 100;//pmDay
		StringBuilder sb = new StringBuilder();

		if (postalCode < 8) {
			if (string == "午前") {//郵便番号１〜７、午前のとき
				shippingDate[2] -= 1;
				shippingDate[5] -= 2;
			} else {//郵便番号１〜７、午後、夕方のとき
				shippingDate[2] -= 1;
				shippingDate[5] -= 1;
			}
			if(shippingDate[2] < 1)//到着日が1日のときに発送日は前の月になる
				shippingDate = convertPrevAmMonthDay(shippingDate);
			if(shippingDate[5] < 1)
				shippingDate = convertPrevPmMonthDay(shippingDate);
		} else if (postalCode == 8) {
			if (string == "午前") {//郵便番号８、午前のとき
				shippingDate[2] -= 2;
				shippingDate[5] -= 3;
			} else if (string == "午後") {//郵便番号８、午後のとき
				shippingDate[2] -= 2;
				shippingDate[5] -= 2;
			} else {//郵便番号８、夕方のとき
				shippingDate[2] -= 1;
				shippingDate[5] -= 2;
			}
			if(shippingDate[2] < 1)//到着日が1日のときに発送日は前の月になる
				shippingDate = convertPrevAmMonthDay(shippingDate);
			if(shippingDate[5] < 1)
				shippingDate = convertPrevPmMonthDay(shippingDate);
		} else {//郵便番号9のとき
			sb.append("配送不可");
			return sb.toString();
		}

		sb.append(shippingDate[0] + "年"+ shippingDate[1]  + "月"+ shippingDate[2] + "日"+ "午前" + "、");
		sb.append(shippingDate[3] + "年"+ shippingDate[4]  + "月"+ shippingDate[5] + "日"+ "午後");
		return sb.toString();
	}

	private int[] convertPrevAmMonthDay(int[] shippingDate) {
		switch(shippingDate[1]){
		case 1: //1月のときは前年の12月31日に変更
			shippingDate[0] -= 1; shippingDate[1] = 12;  shippingDate[2] += 31; break;
		case 2: case 4: case 6: case 8: case 9: case 11:
			shippingDate[1] -= 1; shippingDate[2] += 31; break;
		case 5: case 7: case 10: case 12:
			shippingDate[1] -= 1; shippingDate[2]  += 30; break;
		case 3:
			if(isLeapYear(shippingDate[0])){
				shippingDate[2] += 29;
			}else{
				shippingDate[2] += 28;
			}
			shippingDate[1] -= 1;
			break;
		default :
			throw new RuntimeException();
		}
		return shippingDate;
	}
	
	private int[] convertPrevPmMonthDay(int[] shippingDate){
		switch(shippingDate[4]){
		case 1:
			shippingDate[3] -= 1; shippingDate[4] = 12; shippingDate[5] += 31; break;
		case 2: case 4: case 6: case 8: case 9: case 11:
			shippingDate[4] -= 1; shippingDate[5] += 31; break;
		case 5: case 7: case 10: case 12:
			shippingDate[4] -= 1; shippingDate[5]  += 30; break;
		case 3:
			if(isLeapYear(shippingDate[3])){
				shippingDate[5] += 29;
			}else{shippingDate[5] += 28;
			}
			shippingDate[4] -= 1;
			break;
		default :
			throw new RuntimeException();
		}
		return shippingDate;
	}
	
	private boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;
			if (year % 100 == 0)
			return false;
			if (year % 4 == 0)
			return true;
		return false;
	}
	String sendShippingDate(ClientData clientData){
		int postalCode = clientData.getPostalCode();
		int dataOfArrival = clientData.getDateOfArrival();
		
		String timeZone = clientData.getTimeZone();
		return preSendShippingDate(postalCode,dataOfArrival,timeZone);
			
	}

}
