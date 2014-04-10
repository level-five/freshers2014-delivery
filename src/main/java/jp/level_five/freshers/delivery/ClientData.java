package jp.level_five.freshers.delivery;

public class ClientData {

	private String shippingMethod;
	private int postalCode;
	private int dateOfArrival;
	private String timeZone;

	public ClientData(String shippingMethod, int postalCode, int dateOfArrival, String timeZone) {
		this.shippingMethod = shippingMethod;
		checkShippingMethod();
		this.postalCode = postalCode;
		checkPostalCode();
		this.dateOfArrival = dateOfArrival;
		checkDateOfArrival();
		this.timeZone = timeZone;
		checkTimeZone();
	}
	
	public void checkShippingMethod() {
		shippingMethod = shippingMethod.toUpperCase();
		switch (shippingMethod) {
		case "A":
		case "B":
		case "":
			break;
		default:
			throw new RuntimeException("そのサービスは存在しません。");
		}
	}
	
	public String getShippingMethod() {
		return shippingMethod;
	}

	public void checkPostalCode() {
		postalCode = postalCode / 1000000;
		if ((this.postalCode < 1) | (9 < this.postalCode))
			throw new RuntimeException("不正な郵便番号です。");
	}

	public int getPostalCode() {
		return postalCode;
	}
	
	public void checkDateOfArrival() {
		int dateCheck = dateOfArrival / 10000000;
		if ((dateCheck < 1) | (2 < dateCheck))
			throw new RuntimeException("不正な到着日です。");		

		int arrivalMonth = Integer.parseInt(Integer.toString(dateOfArrival).substring(4, 6));
		if(arrivalMonth == 0  || 12 < arrivalMonth)
			throw new RuntimeException();
		
		int arrivalDay = Integer.parseInt(Integer.toString(dateOfArrival).substring(6, 8));
		checkArrivalDay(arrivalMonth, arrivalDay);
	}

	private void checkArrivalDay(int arrivalMonth, int arrivalDay) {
		switch (arrivalMonth) {
		case 1: case 3: case 5: case 7:
		case 8: case 10: case 12:
			if(arrivalDay == 0  || 31 < arrivalDay)
				throw new RuntimeException("その日は存在しません。");
			break;
		case 2:
			if(isLeapYear()){
				if(arrivalDay == 0  || 29 < arrivalDay)
					throw new RuntimeException("その日は存在しません。");				
			}else{
				if(arrivalDay == 0  || 28 < arrivalDay)
					throw new RuntimeException("その日は存在しません。");
			}
			break;	
		case 4: case 6: case 9: case 11:
			if(arrivalDay == 0  || 30 < arrivalDay)
				throw new RuntimeException("その日は存在しません。");
			break;
		}
	}


	public int getDateOfArrival() {
		return dateOfArrival;
	}

	public boolean isLeapYear() {
		int arrivalYear = Integer.parseInt(Integer.toString(dateOfArrival).substring(0, 4));
		
		if (arrivalYear % 400 == 0)
			return true;
		if (arrivalYear % 100 == 0)
			return false;
		if (arrivalYear % 4 == 0)
			return true;
		
		return false;
	}

	public void checkTimeZone(){
		if(!(timeZone.equals("午前"))&&!(timeZone.equals("午後"))&&!(timeZone.equals("夕方")))
			throw new RuntimeException();
	}

	public String getTimeZone() {
		return timeZone;
	}

}
