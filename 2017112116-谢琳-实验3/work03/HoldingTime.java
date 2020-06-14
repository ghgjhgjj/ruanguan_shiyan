package rctest03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class HoldingTime {
	private String startingTime;
	private String endingTime;
	private long minute;//ͨ��ʱ��
	public Date startT;
	public Date endT;
	 
	public  HoldingTime(String startingTime,String endingTime){
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.startT = StrToDate(this.startingTime);
		this.endT = StrToDate(this.endingTime);
	}
	
	//��str���͵��ַ�ת��ΪyyyyMMddHHmmss��ʽ������
	public Date StrToDate(String str) {
		   SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		   Date date = null;
		   try {
			   date = format.parse(str);
		   } 
		   catch (ParseException e) {
			   e.printStackTrace();
		   }
		   return date;
	}
	
	//��dateת����yyyy-MM-dd HH:mm:ss E��ʽ�ı�׼��ʽ������
	public String DateFormate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		String sdate = format.format(date);
		return sdate;
	}
	
	//��ȡ�������ڵ������ڼ� ,�Լ�
	public long getHoldingTime(){
		long between;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(startT);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(endT);
		
		between = cal2.getTime().getTime()-cal1.getTime().getTime();
		
		if(between<0)
			minute =( (cal2.getTime().getTime()-cal1.getTime().getTime())/1000)/60;//�õ�ͨ��ʱ��
		else
			minute = (between/1000+59)/60;
		
		//�жϽ�ͨʱ���Ƿ��ڷ���ת��������
		if((cal1.get(Calendar.MONTH) ==Calendar.MARCH && cal1.get(Calendar.DATE) >= 29 && cal1.get(Calendar.DATE) <= 31 && cal1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY && cal1.get(Calendar.HOUR_OF_DAY)<2 && cal2.get(Calendar.HOUR_OF_DAY)>=3)
	   || ((cal1.get(Calendar.MONTH) ==Calendar.APRIL && cal1.get(Calendar.DATE) >= 1 && cal1.get(Calendar.DATE) <= 4 && cal1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY && cal1.get(Calendar.HOUR_OF_DAY)<2 && cal2.get(Calendar.HOUR_OF_DAY)>=3))){
			//System.out.println("��Ҫת��1");
				minute -=60;//ʱ���2��ת����3���ȥ1h
		}
		else if((cal2.get(Calendar.MONTH) ==Calendar.MARCH && cal2.get(Calendar.DATE) >= 29 && cal2.get(Calendar.DATE) <= 31 && cal2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY && cal2.get(Calendar.HOUR_OF_DAY)>3)
		    || ((cal2.get(Calendar.MONTH) ==Calendar.APRIL && cal2.get(Calendar.DATE) >= 1 && cal2.get(Calendar.DATE) <= 4 && cal2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY && cal2.get(Calendar.HOUR_OF_DAY)>3))){
				//�жϽ���ʱ���Ƿ���ת��������
				minute -=60;
		}
		
		//��λ��ת����ʱ����ڵ�ʱ�䶼�����Ѿ�ת��֮���
		if(cal1.get(Calendar.MONTH) ==Calendar.OCTOBER && cal1.get(Calendar.DATE) >= 25 && cal1.get(Calendar.DATE) <= 31 && cal1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY && cal1.get(Calendar.HOUR_OF_DAY) ==2){
				minute +=60;
		}
		else if(cal2.get(Calendar.MONTH) ==Calendar.OCTOBER && cal2.get(Calendar.DATE) >= 25 && cal2.get(Calendar.DATE) <= 31 && cal2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY && cal2.get(Calendar.HOUR_OF_DAY)==2){
				minute +=60;
		}
		
		
		if(minute>1800 || minute <0){
			//System.out.println("ʱ�����ʱ�޷�Χ���ԣ�");
			return 0;
		}
		else{
			//System.out.println("�����ȷ");
			return minute;
		}
	}
}