package JEU;

public class Bag {
	private Graal bag[];
	private int nbgraal = 0;
	private int poidsbag;

	public Bag() {
		this.nbgraal = 0;
		this.bag = new Graal[4];
		this.poidsbag = 0;
	}
	public int getnbgraal(){
		return nbgraal;
	}

	public void ajoute(Graal graal){
		if (( bag.length > nbgraal ) ){
			bag[nbgraal] = graal;
			poidsbag = poidsbag + graal.getPoids();
			nbgraal++;
		}
	}
	public int getpoid(){
		return poidsbag;
	}

	public String toString(){
		String s = "";

		for(int i = 0; i < nbgraal; i++) {

			if (bag[i] != null){
				s = s + bag[i].name + " le poids de l'objet est " +  bag[i].getPoids() + " kg \n";
			}
		}		
		return s;	
	}
}
