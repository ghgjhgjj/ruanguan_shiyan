package rctest03;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TelFeeTest {
	
	private String date1,date2;
	private String str;
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	public TelFeeTest(String date1,String date2,String str){
		this.date1 = date1;
		this.date2 = date2;
		this.str = str;
	}
	
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(
				new Object[][]{
					{"20200101000000","20200101120000","720,71.00"}, 
					{"20200101000000","20200101002000","20,1.00"}, 
					{"20200329015959","20200329033000","31,2.10"},
					{"20200329020000","20200329040000","60,5.00"},
					{"20201025010000","20201025020000","120,11.00"},
					{"20201025025959","20201025023000","31,2.10"},
					{"20200430000000","20200502000000","0,0.00"},
				});
	}
	
	@Test
	public void testClassify(){
		assertEquals(this.str,TelFee.classify(date1, date2));
	}
}
