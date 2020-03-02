package cn.tjuscs.st;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

public class TestHamCrest {
	
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
		assertThat(result,is(true));
	}

}
