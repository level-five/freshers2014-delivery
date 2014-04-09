package jp.level_five.freshers.delivery;

public class ClientData {

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

}
