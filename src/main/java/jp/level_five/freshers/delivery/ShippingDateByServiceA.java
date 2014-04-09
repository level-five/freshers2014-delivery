package jp.level_five.freshers.delivery;

public class ShippingDateByServiceA {

	public StringBuilder preSendShippingDate(int postalCode, int arrivalDate,
			String string) {
		int am;
		int pm;
		StringBuilder sb = new StringBuilder();

		if (postalCode < 8) {
			am = --arrivalDate;
			if (string == "午前") {
				pm = --arrivalDate;
			} else {
				pm = am;
			}
			StringBuilder amString = new StringBuilder(Integer.toString(am));
			StringBuilder pmString = new StringBuilder(Integer.toString(pm));
			
			String year = amString.substring(0,4) + "年";
			String month = amString.substring(4,6)+"月";
			String day = amString.substring(6)+"日";
			
			sb.append(year + month + day + "午前" + "、");
			
			year = pmString.substring(0,4) + "年";
			month = pmString.substring(4,6)+"月";
			day = pmString.substring(6)+"日";
			
			sb.append(year + month + day + "午後");
			System.out.println(sb);
			
		} else if (postalCode == 8) {
//			sb.append();
		} else {
			sb.append("配送不可");
		}
		return sb;
	}

}
