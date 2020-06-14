package work01;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TriangleTest {
	
	private int a,b,c;
	private String type;
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	public TriangleTest(int a,int b,int c,String type){
		this.a = a;
		this.b = b;
		this.c = c;
		this.type = type;
	}
	
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(
				new Object[][]{
					{ 10, 20, 30, "��������" }, 
					{ 2, 2, 2, "�ȱ�������" }, 
					{ 0, 0, 0, "��������" }, 
					{ 4, 3, 5, "���ȱ�������" },
					{ 3, 3, 4, "����������" }, 
					{ 4, 4, 5, "����������" }, 
					{ 1, 0, 0, "��������" }, 
					{ 2, 1, 1, "��������" },

				});
	}
	
	@Test
	public void testClassify(){
		assertEquals(this.type,Triangle.classify(a, b, c));
	}
}
