package jp.level_five.freshers.delivery;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputOutput {

	private PrintStream printStream;
	private Scanner scan ;

	public InputOutput() {
		setInputStream(System.in);
		setPrintStream(System.out);
	}

	public void setInputStream(InputStream stream) {
		scan = new Scanner(stream);
	}

	public void setPrintStream(PrintStream stream) {
		printStream = stream;
	}

	public String inputShippingMethod() {
		printStream.format("配送方法を選択してください。　A　または　B");
		String inputShippingMethod = scan.next();
		
		return inputShippingMethod;
	}

	public int inputPostalCode() {
		printStream.format("郵便番号7桁を入力してください。");
		int inputPostalCode = scan.nextInt();
		return inputPostalCode;
	}

	public int inputArrivalDate() {
		printStream.format("希望される到着指定日を入力してください。　例）20140410");
		int inputArrivalDate = scan.nextInt();
		return inputArrivalDate;
	}

	public String inputTimeZone() {
		printStream.format("希望される時間帯を選択してください。午前、午後、夕方");
		String inputTimeZone = scan.next();
		return inputTimeZone;
	}
	public void modeSelect(){
	    printStream.format("使用したい機能を選択してください。\n 1: サービスの一覧を表示\n 2: 指定日時に届く発送日を調べる\n 3: 最も安い配送サービスを調べる");
        
	    int mode = this.inputMode();
	    modeCreate(mode);
  
	    }
	    
	public void modeCreate(int mode){
	       if(mode == 1){
	            String output = new ListDisplay().displayList();
	            this.output(output);}
	        else if(mode == 2){
	            ShippingDateByShippingMethod service2 = new ShippingDateByShippingMethod();
	                System.out.println(this.inputShippingMethod());
	                (this.inputShippingMethod());
	          }
	}
	
	
	public int inputMode() {
		int inputMode = scan.nextInt();
		System.out.println(inputMode);
		return inputMode;
	}
	
	public void output(String output) {
		printStream.format(output);
	}
}
