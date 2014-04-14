package jp.level_five.freshers.delivery;

public class MadeClientData {
	String shippingmethod = " ";
	int postalCode;
	int dataOfArrival;
	String timeZone = " ";
	void setShippingMethod(String c){
		shippingmethod = c;
	}
	void setpostalCode(int code){
		postalCode = code;
	}
	void setdataOfArrival(int data){
		dataOfArrival = data;
	}
	void settimeZone(String timezone){
	    timeZone = timezone;
	}
	ClientData clientdata = new ClientData(shippingmethod, postalCode, dataOfArrival, timeZone);
	
}
