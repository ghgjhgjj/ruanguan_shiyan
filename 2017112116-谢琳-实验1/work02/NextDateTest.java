package work02;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NextDateTest {
	
	private int year,month,day;
	private String date;
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	public NextDateTest(int year,int month,int day,String date){
		this.year = year;
		this.month = month;
		this.day = day;
		this.date = date;
	}
	
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(
				new Object[][]{
					{ 2000, 2,   28,  "2000/2/29" }, 
					{ 1800, 12,  2,   "年份错误" }, 
					{ 2020, 12,  31,  "2021/1/1" }, 
					{ 2013, 2,   28,  "2013/3/1" },
					{ 1999, 3,   31,  "1999/4/1" }, 
					{ 2003, 6,   30,  "2003/7/1" }, 
					{ 1975, 1,   6,   "1975/1/7" }, 
					{ 2004, 2,   29,  "2004/3/1" },
					{ 2014, 9,   29,  "2014/9/30" },
					{ 1998, 12,  29,  "1998/12/30" },
					{ 1900, 2,   2,   "1900/2/3" },
					{ 1901, 13,  2,   "月份错误" },
					{ 2023, 2,   30,  "日期错误" },
				});
	}
	
	@Test
	public void testClassify(){
		assertEquals(this.date,NextDate.classify(year, month, day));
	}
}
