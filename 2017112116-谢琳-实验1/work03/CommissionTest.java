package work03;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CommissionTest {
	
	private int lock,stock,barrel;
	private String commission;
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	public CommissionTest(int lock,int stock,int barrel,String commission){
		this.lock = lock;
		this.stock = stock;
		this.barrel = barrel;
		this.commission = commission;
	}
	
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(
				new Object[][]{
					{ 1,  1,  1,  "10.0" }, 
					{ 1,  1,  2,  "12.5" }, 
					{ 1,  2,  1,  "13.0" }, 
					{ 2,  1,  1,  "14.5" },
					{ 5,  5,  5,  "50.0" }, 
					{ 14, 14, 14,  "160.0" }, 
					{ 10, 9,  10, "97.0" }, 
					{ 70,  80, 90, "1420.0" },

				});
	}
	
	@Test
	public void testClassify(){
		assertEquals(this.commission,Commission.classify(lock, stock, barrel));
	}
}
