import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Grid {
	public static void main(String[] args) {
		//Kryds og bolle
		Map<String,String> kob = new HashMap<String,String>();
		Scanner in = new Scanner(System.in);
		//Byg brettet
		kob.put("a1", "O");
		kob.put("b1", "O");
		kob.put("c1", "O");
		kob.put("a2", "");
		kob.put("b2", "");
		kob.put("c2", "");
		kob.put("a3", "");
		kob.put("b3", "");
		kob.put("c3", "");
		
		int tellerX=0;
		int tellerO=0;
		
		for(int j = 0;j<3;j++) {
		tellerX=0;	
		tellerO=0;
		//vinder horisontalt 
		//løber igennem abc
		char x =(char) (j+97);
			for(int k=1;k<4;k++) {
				//løber gennem 1-3
				String y = Integer.toString(k);
				if(kob.get(x+y)=="X") {
					tellerX+=1;
				}
				else if(kob.get(x+y)=="O"){
					tellerO+=1;
				}
				if (tellerX==3) {
					System.out.println("X"+" wins");
					break;
				}
				else if(tellerO==3) {
					System.out.println("O"+" wins");
					break;
				}
			}
			
		}
		for(int j = 1;j<4;j++) {
			tellerX=0;	
			tellerO=0;
			// vinder horisontalt 
			//løber igennem abc
			String y = Integer.toString(j);
			for(int k=0;k<3;k++) {
				//løber gennem 1-3
				
				char x =(char) (k+97);
				if(kob.get(x+y)=="X") {
					tellerX+=1;
				}
				else if(kob.get(x+y)=="O"){
					tellerO+=1;
				}
				if (tellerX==3) {
					System.out.println("X"+" wins");
					break;
				}
				else if(tellerO==3) {
					System.out.println("O"+" wins");
					break;
				}
				
			}	
		}
	}
}
