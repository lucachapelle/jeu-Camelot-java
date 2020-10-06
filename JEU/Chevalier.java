package JEU;

public class Chevalier {
	private String name;
	private Bag  bag;
	private int life;
	private Coordonnees position;

	public Chevalier(String name) {
		this.name = name;
		this.life = 1000;
		this.bag = new Bag();
		this.position = new Coordonnees (-1,-1);
	}

	public void chevalierdeplacer(){
		position.deplacer();
	}

	public Coordonnees getCoord(){
		return position;
	}

	public int getx(){
		return position.getX();
	}

	public int gety(){
		return position.getY();
	}

	public int getvie(){
		return life;
	}

	public String getName(){
		return name;
	}
	public int poidsbag(){
		return bag.getpoid();
	}

	public void perdrevie(int degats){
		life = life - degats;
	}

	public void gagnevie(int bonus){
		life = life + bonus;
	}

	public void ajouteBag (Graal g){
		bag.ajoute(g);
	}



	public boolean ko(){
		boolean ko = false;
		if(life <= 0 ){
			ko = true;
		}
		return ko;
	}

	public boolean gagne(){
		boolean gagne = false;
		if(bag.getnbgraal() == 4){
			gagne = true;
		}
		return gagne;
	}

	public String toString(){
		if (bag.getnbgraal() == 0) {
			return "Le Chevalier : " + name + "\n"
					+ " " + life + " Point de vie" + "\n" +
					" Son sac est vide ";		
		}
		else {
			return "Le Chevalier : " + name + "\n"
					+ " " + life + " Point de vie" + "\n" +
					" Son sac contient :\n" + bag.toString() + "\n" +
					" Le poids de son sac est de  " + poidsbag() +" kg \n";		
		}

	}
}

