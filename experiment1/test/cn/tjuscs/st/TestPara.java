package cn.tjuscs.st;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPara {

	private int input;
	private boolean expected;
	private Change chg = null;
	
	public TestPara(int input, boolean expected){
		this.input = input;
		this.expected = expected;
	}
	
	@Before
	public void setUp(){
		chg = new Change();
	}
	
	@After
	public void tearDown(){
		System.out.println("After test method");
	}
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("After Class");
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
			
		return Arrays.asList(new Object[][]{
			{1,true},
			{2,true},
			{3,true},
			{4,false},
			{5,true},
			{6,true},
			{7,true},
			{8,true},
			{9,false},
			{10,true}
			});
	}
	
	
	@Test
	public void testMakeChange() {
		assertEquals(this.expected,chg.makeChange(input));
	}

}
