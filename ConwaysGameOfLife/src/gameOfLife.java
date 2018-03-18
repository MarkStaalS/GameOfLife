import java.util.HashMap;
import java.util.Map;

public class gameOfLife {
	public static void main(String args[]) {
		//Creating hashmap: grid
		Map<String ,String> grid = new HashMap<String,String>();
		Map<String ,String> next_grid = new HashMap<String,String>();
		//gameloop run time
		int run_time = 30000;
		//Size of the grid
		int s = 37;
		//Neighbouring cells
		int nb = 0;
		//sleep time
		int t = 150;
		//Running throught y coordinates
		for(int y =0; y< s; y++){
			//Runs through x when finnished with y
			for(int x=0; x<s;x++) {
				//Setting fields to (dead) "_"
				grid.put(gameOfLife.conv(x, y), "_ ");
			}
		}
		//Populate withe one of the following "patterns"
		//gameOfLife.Glider(grid);
		gameOfLife.GosperGliderGun(grid);
		//gameOfLife.Beacon(grid);
		//gameOfLife.Blinker(grid);
		//print start
		gameOfLife.print(s,grid);
		System.out.println("");
		//Gameloop
		for(int z=0;z<run_time;z++) {			
				for(int y =0; y< s; y++){
					//Løber gennem x koordinater, når den er løbet gennem hele rækken gå vi en gang ned i y rækken
					for(int x=0; x<s;x++) {
						nb=0;
						for(int i=-1;i<2;i++) {
							for(int j=-1;j<2;j++) {
								if(i==0&&j==0);
								else if(grid.get(gameOfLife.conv(x+j,y+i))=="# ") nb++;						
							}
						}
						//Reglset
						if(nb<2)next_grid.put(conv(x,y), "_ ");
						else if(nb==3)next_grid.put(conv(x,y), "# ");
						else if(nb>3)next_grid.put(conv(x,y), "_ ");
						else if( (nb==2||nb ==3)&&( grid.get(gameOfLife.conv(x, y))=="# ")) {
							next_grid.put(conv(x,y), "# ");
						}
						else {
							next_grid.put(conv(x,y), "_ ");
						}
					}
				}
				//printer
				gameOfLife.print(s, next_grid);
				//flytter værdier fra midlertidigt til grid
				grid.putAll(next_grid);
				gameOfLife.sleep(t);
			}
	}
	//konvertere int til string for vores koordinater
	public static String conv(int x,int y) {
		String str = Integer.toString(x)+","+Integer.toString(y);
		return str;
	}
	//Printer vores grid
	public static void print(int s, Map<String,String>grid) {
		for(int y =0; y< s; y++){
					//Løber gennem x koordinater, når den er løbet gennem hele rækken gå vi en gang ned i y rækken
					for(int x=0; x<s;x++) {
						//Setter pågældene felt til "_"
						System.out.print(grid.get(gameOfLife.conv(x, y)));
					}
					System.out.println("");
		}
	}
	public static void sleep(int tid) {
		try{
			//print something here
			Thread.sleep(tid); //sleep 
			//print something else here
			}
			catch(InterruptedException e){   
				System.out.println("got interrupted!");
			}
	}
	//Forskellige mønstre
	//Glider
	public static Map<String,String> Glider(Map<String,String>grid) {
		grid.put("1,0", "# ");
		grid.put("2,1", "# ");
		grid.put("0,2", "# ");
		grid.put("1,2", "# ");
		grid.put("2,2", "# ");
		return grid;
	}
	//Gosper glider gun
	public static Map<String,String> GosperGliderGun(Map<String,String>grid) {
		grid.put("1,5", "# ");
		grid.put("1,6", "# ");
		grid.put("2,5", "# ");
		grid.put("2,6", "# ");
		grid.put("11,5", "# ");
		grid.put("11,6", "# ");
		grid.put("11,7", "# ");
		grid.put("12,4", "# ");
		grid.put("12,8", "# ");
		grid.put("13,3", "# ");
		grid.put("13,9", "# ");
		grid.put("14,3", "# ");
		grid.put("14,9", "# ");
		grid.put("15,6", "# ");
		grid.put("16,4", "# ");
		grid.put("16,8", "# ");
		grid.put("17,5", "# ");
		grid.put("17,6", "# ");
		grid.put("17,7", "# ");
		grid.put("18,6", "# ");
		grid.put("21,3", "# ");
		grid.put("21,4", "# ");
		grid.put("21,5", "# ");
		grid.put("22,3", "# ");
		grid.put("22,4", "# ");
		grid.put("22,5", "# ");
		grid.put("23,2", "# ");
		grid.put("23,6", "# ");
		grid.put("25,1", "# ");
		grid.put("25,2", "# ");
		grid.put("25,6", "# ");
		grid.put("25,7", "# ");
		grid.put("35,3", "# ");
		grid.put("35,4", "# ");
		grid.put("36,3", "# ");
		grid.put("36,4", "# ");
		return grid;
	}
	public static Map<String,String> Beacon(Map<String,String>grid) {
		//Beacon
		grid.put("2,2", "# ");
		grid.put("3,2", "# ");
		grid.put("2,3", "# ");
		grid.put("5,5", "# ");
		grid.put("5,4", "# ");
		grid.put("4,5", "# ");
		return grid;
	}
	public static Map<String,String> Blinker(Map<String,String>grid) {
		//Blinker
		grid.put("2,1", "# ");
		grid.put("2,2", "# ");
		grid.put("2,3", "# ");
		return grid;
	}

}

