package jp.level_five.freshers.delivery;

public class MadeClientData {
	char shippingmethod = ' ';
	int postalCode;
	int dataOfArrival;
	int timeZone;
	void setShippingMethod(char c){
		shippingmethod = c;
	}
	void setpostalCode(int code){
		postalCode = code;
	}
	void setdataOfArrival(int data){
		dataOfArrival = data;
	}
}
