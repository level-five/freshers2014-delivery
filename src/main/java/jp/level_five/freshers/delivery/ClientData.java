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

	}

	public int getPostalCode() {
		return 1;
	}

}
