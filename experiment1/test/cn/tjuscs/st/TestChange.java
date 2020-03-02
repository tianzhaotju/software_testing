package cn.tjuscs.st;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;

import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestChange {
	
	private Change chg = null;
	
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
	
	@Test
	public void testMakeChange(){
		boolean result = chg.makeChange(5);
		System.out.println("testing...");
		System.out.print("test result: ");
		System.out.println(result);
		assertTrue(result);
	}
		
}
