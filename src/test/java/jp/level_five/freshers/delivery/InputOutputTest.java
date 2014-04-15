package jp.level_five.freshers.delivery;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class InputOutputTest {
    InputOutput inputOutput = null;
    ByteArrayOutputStream outputStream = null;

    @Before
    public void before() {
        inputOutput = new InputOutput();

        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        inputOutput.setPrintStream(printStream);
    }

    @Test
    public void test使用する機能1を選ぶとサービスAサービスBと表示される() {
       String inputMode = "1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                inputMode.getBytes());
        inputOutput.setInputStream(inputStream);
        
         inputOutput.modeSelect();
       
        assertEquals(
                "使用したい機能を選択してください。\n 1: サービスの一覧を表示\n 2: 指定日時に届く発送日を調べる\n 3: 最も安い配送サービスを調べるサービスA\nサービスB",
                outputStream.toString());
    }
     @Test
     public void test使用する機能2を選び配送データを入力をすると配送日が表示される() {
         String inputMode = "2\nA\n1234567\n2014042"
                 + "7\n午前";
         ByteArrayInputStream inputStream = new ByteArrayInputStream(
                 inputMode.getBytes());
         inputOutput.setInputStream(inputStream);
      
        
         inputOutput.modeSelect();
       //  配送方法を選択してください。　A　または　B郵便番号7桁を入力してください。希望される到着指定日を入力してください。　例）20140410希望される時間帯を選択してください。午前、午後、夕方
  
     assertEquals("使用したい機能を選択してください。\n 1: サービスの一覧を表示\n 2: 指定日時に届く発送日を調べる\n 3: 最も安い配送サービスを調べる2014年4月26日午前、2014年4月25日午後", outputStream.toString());
     }
     @Test
     public void test使用する機能3を選び配送データを入力すると最安値の方法で配送日が表示される() {
         String inputMode = "3\n1234567\n20140607\n午前";
         ByteArrayInputStream inputStream = new ByteArrayInputStream(
                 inputMode.getBytes());
         inputOutput.setInputStream(inputStream);
      
        
         inputOutput.modeSelect();
       //  配送方法を選択してください。　A　または　B郵便番号7桁を入力してください。希望される到着指定日を入力してください。　例）20140410希望される時間帯を選択してください。午前、午後、夕方
  
     assertEquals("使用したい機能を選択してください。\n 1: サービスの一覧を表示\n 2: 指定日時に届く発送日を調べる\n 3: 最も安い配送サービスを調べる配送サービスB、2014年6月6日午前、2014年6月6日午後", outputStream.toString());
     }
}
