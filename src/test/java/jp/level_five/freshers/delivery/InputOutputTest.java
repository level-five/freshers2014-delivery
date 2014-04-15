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
     public void test使用する機能2を選ぶと配送データの入力が要求される() {
         String inputMode = "2\nA";
         ByteArrayInputStream inputStream = new ByteArrayInputStream(
                 inputMode.getBytes());
         inputOutput.setInputStream(inputStream);
      
        
         inputOutput.modeSelect();
   
         System.out.println(outputStream.toString());
     assertEquals("使用したい機能を選択してください。\n 1: サービスの一覧を表示\n 2: 指定日時に届く発送日を調べる\n 3: 最も安い配送サービスを調べる配送方法を選択してください。　A　または　B", outputStream.toString());
     }

}
