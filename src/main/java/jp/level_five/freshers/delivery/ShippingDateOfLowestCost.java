package jp.level_five.freshers.delivery;

public class ShippingDateOfLowestCost {

	public String getServiceOfLowestCost(int arrivalDate) {
		ShippingDateByServiceB serviceB = new ShippingDateByServiceB();
		
		if (serviceB.isHoliday(arrivalDate))
			return "A";
		else
			return "B";
	}

	public String getServiceOfLowerCost(ClientData clientData) {
		ShippingDateByServiceB serviceB = new ShippingDateByServiceB();
		
		if ( serviceB.isHoliday( clientData.getDateOfArrival() ) ) {
			
			if ( clientData.getPostalCode()==9 ){
				return "配送不可";
			}
			
			return "A";
			
		} else {
			
			return "B";
			
		}
	}

	public String preSendShippingDate(ClientData clientData) {
		String shippingMethod = getServiceOfLowerCost(clientData);
		String out = null;
		
		switch (shippingMethod) {
		case "A":
			ShippingDateByServiceA serviceA = new ShippingDateByServiceA();
			out = "配送サービスA、" + serviceA.sendShippingDate(clientData);
			break;
		case "B":
			ShippingDateByServiceB serviceB = new ShippingDateByServiceB();
			out = "配送サービスB、" + serviceB.sendShippingDate(clientData);
			break;
		case "配送不可":
			out = "配送不可";
			break;
		}
		
		return out;
	}
}
