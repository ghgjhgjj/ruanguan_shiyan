package work01;

public class Triangle {
	 public static String classify(int a,int b,int c){
		 if(!((a+b>c) && (a+c>b) && (b+c>a))){
			 return "��������";
		 }
		 else if(a==b && a==c && b==c){
			 return "�ȱ�������";
		 }
		 else if(a!=b && a!=c && b!=c){
			 return "���ȱ�������";
		 }
		 else{
			 return "����������";
		 }
	 }
}
