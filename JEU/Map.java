package JEU;

public class Map {
	private Object map[][];
	private final static int taillemap = 10;

	public Map(int taille) {
		this.map = new Object[taille][taille];
	}

	public void Init(){
		for(int i = 0; i < taillemap; i++)
		{
			for(int j = 0; j < taillemap; j++){
				map[i][j] = null;
			}
		}

	}
	public boolean yaobstacle(int x,int y){
		return (map[x][y] instanceof Obstacle);
	}
	public boolean yagraal(int x,int y){
		return (map[x][y] instanceof Graal);
	}
	public Object getobject(int x,int y){
		return map[x][y];
	}

	public void supobject(Object object){
		for(int i = 0; i < taillemap; i++)
		{
			for(int j = 0; j < taillemap; j++){
				if (map[i][j] == object){
					map[i][j] = null;
				}
			}
		}
	}

	public void Ajouter(Object object){
		int x = (int) (Math.random()*10);
		int y = (int) (Math.random()*10);
		boolean ajoute = false;
		while ( !ajoute) {
			if (map[x][y] != null){
				x = (int) (Math.random()*10);
				y = (int) (Math.random()*10);
			}

			else{
				map[x][y] = object;
				ajoute = true;
			}
		}

	}

	public String toString(){
		String s = "";
		String cas = ".";
		for(int i = 0; i < taillemap; i++)
		{
			for(int j = 0; j < taillemap; j++){
				if (map[i][j] != null){
					if(map[i][j].name.equals("excalibur")){
						cas = "E";
					}
					if(map[i][j].name.equals("pierre de fal lial")){
						cas = "P";
					}
					if(map[i][j].name.equals("lance de lug")){
						cas = "L";
					}
					if(map[i][j].name.equals("chaudron de la connaissance")){
						cas = "C";
					}
					if(map[i][j].name.equals("ronce")){
						cas = "n";
					}
					if(map[i][j].name.equals("puits")){
						cas = "p";
					}
					if(map[i][j].name.equals("roche")){
						cas = "r";
					}
				}

				else{
					cas = ".";
				}

				s = s + "  " +cas ;

			}
			s = s + "\n" ;
		}
		return s;


	}
}
