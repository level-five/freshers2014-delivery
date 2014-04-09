package jp.level_five.freshers.delivery;

public class ClientData {

	private int postalCode;

	public void checkDataOfArrival(char dataOfArrival) {
		switch (dataOfArrival) {
		case 'A':
		case 'a':
		case 'B':
		case 'b':
			break;
		default:
			throw new RuntimeException("そのサービスは存在しません。");
		}

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
