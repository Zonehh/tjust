package cn.tjucic.st;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BackPackTest {

	private BackPack Bp;
	
	PrintStream console = null;
    ByteArrayOutputStream bytes = null;
	
	@Before
	public void setUp() throws Exception {
		Bp = new BackPack();
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
		String s = new String("0\t0\t4\t4\t4\t4\t4\t4\t4\t4\t\r\n0\t0\t4\t5\t5\t5\t9\t9\t9\t9\t\r\n0\t0\t4\t5\t6\t6\t9\t10\t11\t11\t\r\n");
		
		Class pp = Bp.getClass();
        Method method = pp.getDeclaredMethod("main", new Class[]{String[].class});
        method.setAccessible(true);
        method.invoke(null, new Object[] {new String[] {}});
        assertEquals(s, bytes.toString());
	}

}
