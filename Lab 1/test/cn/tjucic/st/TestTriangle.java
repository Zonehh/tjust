package cn.tjucic.st;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestTriangle {

	private Triangle Tri;
	private int x;
	private Boolean expected;
	
	public TestTriangle(Boolean expected, int x) {
		this.x = x;
		this.expected = expected;
	}
	
	@Before
	public void setUp () {
		Tri = new Triangle();
	}
	
	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{false,-1},
			{false,84},
			{true,83},
			{true,0},
			{false,64}
		});
	}
	
	@Test
	public void testCoin () {
		assertEquals(this.expected, Tri.Coin(x));
	}
}
