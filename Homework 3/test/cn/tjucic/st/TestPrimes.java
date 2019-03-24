package cn.tjucic.st;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPrimes {

	private PrintPrimes p;

    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        p = new PrintPrimes();
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }
    
    @Test
    public void testResult() throws Exception {
        String s = new String("Prime: 2" + '\r'+'\n');
        s += "Prime: 3" + '\r'+'\n';
        s += "Prime: 5" + '\r'+'\n';
        
        Class pp = p.getClass();
        Method method = pp.getDeclaredMethod("printPrimes", new Class[]{int.class});
        method.setAccessible(true);
        method.invoke(p, 3);
        assertEquals(s, bytes.toString());

    }
    
    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

}
