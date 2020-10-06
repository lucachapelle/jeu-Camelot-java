package JEU;

public class Object {
	public String name;
	public int vie;
	public int poids;

	public Object(String name,int vie,int poids) {
		this.name = name;
		this.vie = vie;
		this.poids = poids;
	}

	public Object(String name,int vie) {
		this.name = name;
		this.vie = vie;
		this.poids = 0;
	}

	public int getPoids (){
		return poids;
	}

}
