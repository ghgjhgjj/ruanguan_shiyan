package rctest03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;
public class TelFee {
	
	public static double telFee;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//字符输入流
		
		System.out.println("请输入起始时间（如20170102030405）:");
		String sd1=input.next();
		System.out.println("请输入截止时间（如20170102030405）:");
		String sd2=input.next();
		
		System.out.println(classify(sd1,sd2));
		
	}

	static String classify(String sd1, String sd2) {
		// TODO Auto-generated method stub
		HoldingTime ht = new HoldingTime(sd1,sd2);
			
		System.out.println("电话接通时间："+ht.DateFormate(ht.startT));
		System.out.println("电话结束时间："+ht.DateFormate(ht.endT));
		ht.DateFormate(ht.startT);
		ht.DateFormate(ht.endT);
		DecimalFormat df = new DecimalFormat("######0.00"); 
		long minute = ht.getHoldingTime();
		//计算话费
		if(minute == 0){
			telFee = 0.00;
		}
		else if(minute>0 && minute <= 20){
			telFee = 0.05*minute;
		}
		else{
			telFee = 1.00 + (minute - 20)*0.1;
		}
		//System.out.println("通话时间为："+minute+"分钟");
		//System.out.println("本次通话话费为："+df.format(telFee)+"美元");
		
		return minute+","+df.format(telFee);
	}
	
	
}