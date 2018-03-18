import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class krydsOgBolle {
	public static void main(String[] args) {
		//Kryds og bolle
		Map<String,String> kob = new HashMap<String,String>();
		Scanner in = new Scanner(System.in);
		//Byg brettet
		kob.put("a1", "_");
		kob.put("b1", "_");
		kob.put("c1", "_");
		kob.put("a2", "_");
		kob.put("b2", "_");
		kob.put("c2", "_");
		kob.put("a3", "_");
		kob.put("b3", "_");
		kob.put("c3", "_");
		//Print brettet
		System.out.println("   "+"a "+"b "+"c" );
		System.out.println(" 1 "+kob.get("a1")+" "+kob.get("b1")+" "+kob.get("c1"));
		System.out.println(" 2 "+kob.get("a2")+" "+kob.get("b2")+" "+kob.get("c2"));
		System.out.println(" 3 "+kob.get("a3")+" "+kob.get("b3")+" "+kob.get("c3"));
		
		/*Cell p;
		p = new Cell();
		
		p.print();
		*/
		//i er tur
		int i = 0;
		//Kontroler om cellen er tom
		while (true){
			if (i%2==0) {
				System.out.println("X your move: ");
				String move = in.next();
				if(kob.get(move)!="_") {
					System.out.println("You cant do that ");
					i -= 1;
				}
				else {
					kob.put(move, "X");
				}
			}
			else {
				System.out.println("O your move: ");
				String move = in.next();
				if(kob.get(move)!="_") {
					System.out.println("You cant do that ");
					i -= 1;
				}
				else {
					kob.put(move, "O");
				}
			}
		//Print brettet
		System.out.println("   "+"a "+"b "+"c" );
		System.out.println(" 1 "+kob.get("a1")+" "+kob.get("b1")+" "+kob.get("c1"));
		System.out.println(" 2 "+kob.get("a2")+" "+kob.get("b2")+" "+kob.get("c2"));
		System.out.println(" 3 "+kob.get("a3")+" "+kob.get("b3")+" "+kob.get("c3"));
		
		//Kigger efter vinder
		int tellerX=0;
		int tellerO=0;
		for(int j = 0;j<3;j++) {
		tellerX=0;	
		tellerO=0;
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
						System.exit(1);
					}
					else if(tellerO==3) {
						System.out.println("O"+" wins");
						System.exit(1);
					}
				}
			}
		//Horisontalt
		for(int j = 1;j<4;j++) {
			tellerX=0;	
			tellerO=0;
			//løber igennem 1-3
			String y = Integer.toString(j);
			for(int k=0;k<3;k++) {
				//løber gennem abc
				char x =(char) (k+97);
				if(kob.get(x+y)=="X") {
					tellerX+=1;
				}
				else if(kob.get(x+y)=="O"){
					tellerO+=1;
				}
				if (tellerX==3) {
					System.out.println("X"+" wins");
					System.exit(1);
				}
				else if(tellerO==3) {
					System.out.println("O"+" wins");
					System.exit(1);
				}
			}	
		}
		//Kigger efter vinder i X
		if(kob.get("a1")==kob.get("b2")&&kob.get("b2")==kob.get("c3")&&kob.get("a1")!="_") {
			System.out.println(kob.get("b2")+" wins");
			System.exit(1);
		}
		else if(kob.get("a3")==kob.get("b2")&&kob.get("b2")==kob.get("c1")&&kob.get("b2")!="_") {
			System.out.println(kob.get("b2")+" wins");
			System.exit(1);
		}
		//Naeste tur	
		i += 1;	
		}
	}
}

