package JEU;

import java.util.ArrayList;
import java.util.ListIterator;


public class Tableronde {
	private  ArrayList<Chevalier> tableronde;

	public Tableronde() {
		this.tableronde = new ArrayList<Chevalier>();
	}

	public void Ajouter(Chevalier chevalier){
		tableronde.add(chevalier);
	}

	public void Retirer(String name){
		boolean trouve = false;
		ListIterator<Chevalier> it = tableronde.listIterator();
		while(it.hasNext()) {
			Chevalier c = it.next();

			if( name.equals(c.getName())){
				it.remove();
				trouve = true;				
			}
		}
		if (!trouve){ 
			System.out.println("le chevalier n'est pas dans la table");			}


	}
	public Chevalier getChevalier(String name ){
		Chevalier c = null;
		Chevalier cint = null;
		ListIterator<Chevalier> it = tableronde.listIterator();
		while(it.hasNext()) {
			cint = it.next();
			if (cint.getName().equals(name)){
				c = cint;
			}


		}
		return c ;
	}

	public String toString(){
		String s = "";
		if ( tableronde.size() > 0){
			ListIterator<Chevalier> it = tableronde.listIterator();
			while(it.hasNext()) {
				Chevalier l = it.next();
				s = s + "A la place " + it.nextIndex() + " de la table ronde "  + l + "\n";
			}
			return s;
		}
		else{
			return "La table ronde ne contient pas de chevaliers.";
		}

	}

}		


