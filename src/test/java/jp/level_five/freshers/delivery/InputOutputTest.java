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
	public void test����A����͂���ƕ����^��A���Ԃ��Ă���() {
		String inputString = "A";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputString.getBytes());
		inputOutput.setInputStream(inputStream);

		String input = inputOutput.inputShippingMethod();

		assertEquals("A", input);
		assertEquals("�z�����@��I�����Ă��������B�@A�@�܂��́@B", outputStream.toString());
	}

	@Test
	public void test�X�֔ԍ�1000000����͂����1000000���Ԃ��Ă���() {
		String inputcode = "1000000";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputcode.getBytes());
		inputOutput.setInputStream(inputStream);
		int input = inputOutput.inputPostalCode();
		assertEquals(1000000, input);
		assertEquals("�X�֔ԍ�7������͂��Ă��������B", outputStream.toString());
	}

	@Test
	public void test������20140410����͂����20140410���Ԃ��Ă���() {
		String inputArrival = "20140410";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputArrival.getBytes());
		inputOutput.setInputStream(inputStream);
		int input = inputOutput.inputArrivalDate();
		assertEquals(20140410, input);
		assertEquals("��]����铞���w�������͂��Ă��������B�@��j20140410", outputStream.toString());
	}

	@Test
	public void test�z�B�w�莞�ԑт̑I���ߑO��I������ƌߑO���Ԃ��Ă���() {
		String inputTimeZone = "�ߑO";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputTimeZone.getBytes());
		inputOutput.setInputStream(inputStream);
		String input = inputOutput.inputTimeZone();
		assertEquals("�ߑO", input);
		assertEquals("��]����鎞�ԑт�I�����Ă��������B�ߑO�A�ߌ�A�[��", outputStream.toString());
	}

	@Test
	public void test�g�p����@�\�P��I�ԂƂP���Ԃ��Ă���() {
		String inputMode = "1";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				inputMode.getBytes());

		inputOutput.setInputStream(inputStream);
		int input = inputOutput.inputMode();
		assertEquals(1, input);
		assertEquals(
				"�g�p�������@�\��I�����Ă��������B\n 1: �T�[�r�X�̈ꗗ��\��\n 2: �w������ɓ͂��������𒲂ׂ�\n 3: �ł������z���T�[�r�X�𒲂ׂ�",
				outputStream.toString());
	}
	
	@Test
	public void testoutput���\�b�h��String�I�u�W�F�N�g20140410���n���ꂽ�Ƃ��ɏo�͂���(){
		String output ="20140410";
		inputOutput.output(output);
		assertEquals("20140410",outputStream.toString());
	}
	@Test
	public void testoutput���\�b�h��String�I�u�W�F�N�g1330056���n���ꂽ�Ƃ��ɏo�͂���() {
		StringBuilder sb = new StringBuilder();
		sb.append("1330056");
		inputOutput.output(sb.toString());
		assertEquals("1330056", outputStream.toString());
	}

}
