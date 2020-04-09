import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBubbleSort {
    
	public BubbleSort bs = null;
	@Before 
	public void setup(){
		 bs = new BubbleSort();
	}
	
	@Test
	public void testBubbleSort(){
	     int expect[] = {1, 2, 2, 5, 6};
	     int par[] = {2, 5, 6, 2, 1};
	     Assert.assertArrayEquals(expect,bs.BubbleSort(par));
		
	}

}