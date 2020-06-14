package rctest03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;
public class TelFee {
	
	public static double telFee;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//�ַ�������
		
		System.out.println("��������ʼʱ�䣨��20170102030405��:");
		String sd1=input.next();
		System.out.println("�������ֹʱ�䣨��20170102030405��:");
		String sd2=input.next();
		
		System.out.println(classify(sd1,sd2));
		
	}

	static String classify(String sd1, String sd2) {
		// TODO Auto-generated method stub
		HoldingTime ht = new HoldingTime(sd1,sd2);
			
		System.out.println("�绰��ͨʱ�䣺"+ht.DateFormate(ht.startT));
		System.out.println("�绰����ʱ�䣺"+ht.DateFormate(ht.endT));
		ht.DateFormate(ht.startT);
		ht.DateFormate(ht.endT);
		DecimalFormat df = new DecimalFormat("######0.00"); 
		long minute = ht.getHoldingTime();
		//���㻰��
		if(minute == 0){
			telFee = 0.00;
		}
		else if(minute>0 && minute <= 20){
			telFee = 0.05*minute;
		}
		else{
			telFee = 1.00 + (minute - 20)*0.1;
		}
		//System.out.println("ͨ��ʱ��Ϊ��"+minute+"����");
		//System.out.println("����ͨ������Ϊ��"+df.format(telFee)+"��Ԫ");
		
		return minute+","+df.format(telFee);
	}
	
	
}