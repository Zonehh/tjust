package cn.tjucic.st;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

	private BubbleSort Bs;
	
	PrintStream console = null;
    ByteArrayOutputStream bytes = null;
	
	@Before
	public void setUp() throws Exception {
		Bs = new BubbleSort();
		bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(console);
	}

	@Test
	public void test() throws Exception {
		String s = new String("[1, 2, 2, 5, 6]\r\n");
		
		Class pp = Bs.getClass();
        Method method = pp.getDeclaredMethod("main", new Class[]{String[].class});
        method.setAccessible(true);
        method.invoke(null, new Object[] {new String[] {}});
        assertEquals(s, bytes.toString());
	}

}
