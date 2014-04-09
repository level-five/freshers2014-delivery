package jp.level_five.freshers.delivery;

public class ClientData {

	private char shippingMethod;
	private int postalCode;

	public ClientData(char shippingMethod, int postalCode, int dateOfArrival, String timeZone) {
		this.shippingMethod = shippingMethod;
		checkShippingMethod();
	}
	
	public void checkShippingMethod() {
		switch (shippingMethod) {
		case 'a':
			shippingMethod = 'A';
			break;
		case 'b':
			shippingMethod = 'B';
		case 'A':
		case 'B':
			break;
		default:
			throw new RuntimeException("そのサービスは存在しません。");
		}
	}
	
	public char getShippingMethod() {
		return shippingMethod;
	}

	public void checkPostalCode(int postalCode) {
		this.postalCode = postalCode / 1000000;
		
		if ((this.postalCode < 1) | (9 < this.postalCode))
			throw new RuntimeException("不正な郵便番号です。");
	}

	public int getPostalCode() {
		return postalCode;
	}

}
