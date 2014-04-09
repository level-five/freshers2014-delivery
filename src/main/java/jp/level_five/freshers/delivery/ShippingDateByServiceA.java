package jp.level_five.freshers.delivery;

public class ShippingDateByServiceA {

	public StringBuilder preSendShippingDate(int i, int j, String string) {
		StringBuilder sb = new StringBuilder();
		if(i<8){
			sb.append("２０１４年４月８日午前、２０１４年４月８日午後");
		}else if(i==8){
			sb.append("２０１４年４月８日午前、２０１４年４月７日午後");
		}else{
			sb.append("配送不可");
		}
		return sb;
	}

}
