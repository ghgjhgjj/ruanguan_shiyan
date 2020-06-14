package work02;

public class NextDate {
	 public static String classify(int year,int month,int day){
		 if(year<1900 || year>2050)
			 return "��ݴ���";
		 else if(month<1 || month>12)
			 return "�·ݴ���";
		 else if(day<1 || day>31)
			 return "���ڴ���";
		 else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10){
			 if(day<31)
				 day += 1;
			 else if(day==31){
				 month += 1;
				 day = 1;
			 }
		 }
		 else if(month==4 || month==6 || month==9 || month==11){
			 if(day<30)
				 day += 1;
			 else if(day==30){
				 month += 1;
				 day = 1;
			 }
			 else
				 return "���ڴ���";
		 }
		 else if(month==12){
			 if(day<31)
				 day += 1;
			 else if(day==31){
				 year += 1;
				 month = 1;
				 day = 1;
			 }
			 else
				 return "���ڴ���";
		 }
		 else if(month==2){
			 if(day<28)
				 day += 1;
			 else if(day==28){
				 if((year%4==0 && year%100!=0) || year%400==0){//�ж�����
					day += 1;
				 }
				 else{
					 month += 1;
					 day = 1;
				 }
			 }
			 else if(day==29){
				 if((year%4==0 && year%100!=0) || year%400==0){//�ж�����
						month += 1;
						day = 1;
				 }
				 else
					 return "���ڴ���";
			 }
			 else
				 return "���ڴ���";
		 }
		 
		 return ""+year+"/"+month+"/"+day;
	 }
}
