package work03;

import java.util.Scanner;

public class Commission {
	
	
	 public static int totalLock = 0;
	 public static int totalStock = 0;
	 public static int totalBarrel = 0;
	 public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 int lock = input.nextInt();
		 while(lock != -1){
			 int stock = input.nextInt();
			 int barrel = input.nextInt();
			 totalLock += lock;
			 totalStock += stock;
			 totalBarrel += barrel;
			 lock = input.nextInt();
		 }
		 classify(totalLock,totalStock,totalBarrel);
		 
	 }
	
	 public static String classify(int totalLock,int totalStock,int totalBarrel){

		 
		 double lockPrice = 45.0;
		 double stockPrice = 30.0;
		 double barrelPrice = 25.0;
		 
		 double allSale = totalLock*lockPrice + totalStock*stockPrice + totalBarrel*barrelPrice;
		 
		 double commission = 0;;
		 if(allSale>1800)
			 commission += ((allSale-1800)*0.2+800*0.15+1000*0.1);
		 else if(allSale>1000)
			 commission += (allSale-1000)*0.15+1000*0.1;
		 else
			 commission +=(allSale*0.1);
		 
		 
		 return ""+commission;
		 
	 }
}
