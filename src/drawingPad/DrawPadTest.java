package drawingPad;

import static org.junit.Assert.*;

import org.junit.Test;

public class DrawPadTest {

	@Test
	public void test() {
		DrawPad dp = new DrawPad();
		dp.font="TimesNew";
		dp.fontsize=30;
		int f=dp.getFontSize();
		String s=dp.getFont();
		assertEquals("TimesNew",s);
		assertEquals(30,f);
	}

}
