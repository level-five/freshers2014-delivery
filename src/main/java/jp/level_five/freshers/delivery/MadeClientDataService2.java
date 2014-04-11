package jp.level_five.freshers.delivery;

import java.io.InputStream;

public class MadeClientDataService2 {

	public String shippingMethod ;
	public int postalCode ;
	public int dateOfArrival ;
	public String timeZone ;
	InputOutput input = new InputOutput();

	public void setInputStream(InputStream inputStream) {
		input.setInputStream(inputStream);
	}
	public void inputClientData(){
		inputShippingMethod();
		inputPostalCode();
		inputDateOfArrival();
		inputTimeZone();
	}
	public void inputShippingMethod() {
		shippingMethod = input.inputShippingMethod();	
	}
	public void inputPostalCode(){
		postalCode = input.inputPostalCode();		
	}
	public void inputDateOfArrival() {
		dateOfArrival = input.inputArrivalDate();
	}
	public void inputTimeZone() {
		timeZone = input.inputTimeZone();
	}
	public ClientData createClientData(String shippingMethod, int postalCode, int dateOfArrival, String timeZone) {
		return new ClientData(shippingMethod, postalCode, dateOfArrival, timeZone);
	}

}
