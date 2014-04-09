package jp.level_five.freshers.delivery;

public class ClientData {

	public void checkDataOfArrival(char dataOfArrival) {
		switch (dataOfArrival) {
		case 'A':
		case 'B':
			break;
		default:
			throw new RuntimeException("そのサービスは存在しません。");
		}

	}

}
