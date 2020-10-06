package JEU;
import in.keyboard.Keyboard;
public class VraiMain {
	private static  Map creation () {
		Map Au4coinsdumonde = new Map(10);
		Au4coinsdumonde.Init();
		Graal excalibur = new Graal("excalibur",100,5);
		Au4coinsdumonde.Ajouter(excalibur);

		Graal pierre = new Graal("pierre de fal lial",80,4);
		Au4coinsdumonde.Ajouter(pierre);

		Graal lance = new Graal("lance de lug",40,2);
		Au4coinsdumonde.Ajouter(lance);

		Graal chaudron = new Graal("chaudron de la connaissance",50,3);
		Au4coinsdumonde.Ajouter(chaudron);

		Obstacle roche = new Obstacle("roche",20);
		Au4coinsdumonde.Ajouter(roche);

		Obstacle puits = new Obstacle("puits",30);
		Au4coinsdumonde.Ajouter(puits);

		Obstacle ronce = new Obstacle("ronce",10);
		Au4coinsdumonde.Ajouter(ronce);
		Au4coinsdumonde.Ajouter(ronce);

		return Au4coinsdumonde;
	}

	private static void affiche() {
		System.out.println("appuyer sur 1 pour Créer un chevalier");
		System.out.println("appuyer sur 2 pour Expulser un chevalier de la table ronde"); 
		System.out.println("appuyer sur 3 pour Afficher les membres de la table ronde");
		System.out.println("appuyer sur 4 pour Afficher la map ");
		System.out.println("appuyer sur 5 pour Envoyer un chevalier faire sa quete ");
		System.out.println("appuyer sur 6 pour quitter ");
	}

	private static void jouer(Map Au4coinsdumonde,Tableronde table) {		
		System.out.println("Veuillez rentrer le nom du chevalier qui va faire la quete : ");
		String namec = Keyboard.getString();
		Chevalier c = table.getChevalier(namec);
		if (c == null){
			System.out.println("le chevalier est pas dans la table");
		}
		else{
			System.out.println(Au4coinsdumonde.toString());
			c.chevalierdeplacer();
			while( !c.ko() && !c.gagne()){
				int x = c.getx();
				int y = c.gety();
				if (Au4coinsdumonde.yaobstacle(x,y)){
					Object obstacle = Au4coinsdumonde.getobject(x,y);
					c.perdrevie(obstacle.vie);
					Au4coinsdumonde.supobject(obstacle);			
				}
				else if (Au4coinsdumonde.yagraal(x,y)){
					Object graal = Au4coinsdumonde.getobject(x,y);
					c.gagnevie(graal.vie);

					if (graal instanceof Graal){
						c.ajouteBag((Graal) graal);
						System.out.println(c.toString() );
						System.out.println("la position du chevalier  est " + c.getCoord().toString() + "\n" + "\n");
					}
					Au4coinsdumonde.supobject(graal);

				}
				c.chevalierdeplacer();
				c.perdrevie(c.poidsbag());
			}	
		}

		System.out.println(Au4coinsdumonde.toString());
		if (c != null){
			fin(c);
			table.Retirer(namec);

		}
	}

	private static boolean menu(boolean fini, int choix, Tableronde table, Map Au4coinsdumonde) {
		switch (choix){

		case 1 :
			System.out.println("Veuillez rentrer un nom de chevalier : ");
			String name = Keyboard.getString();
			Chevalier chevalier = new Chevalier(name);
			table.Ajouter(chevalier);
			break;

		case 2 :
			System.out.println("Veuillez rentrer un nom de chevalier que vous voulez supprimer : ");
			String retire = Keyboard.getString();					
			table.Retirer(retire);				
			break;	

		case 3 :
			System.out.println(table.toString());
			break;

		case 4 : 
			System.out.println(Au4coinsdumonde.toString());
			break;

		case 5 : 
			jouer(Au4coinsdumonde,table);
			System.out.println("la map se recréé veuillez patienter");
			System.out.println(".....");
			System.out.println(".....");
			Au4coinsdumonde = creation();
			break;

		case 6 : 
			fini = true;
			break;


		}
		return fini;
	}
	private static void fin(Chevalier c) {
		if (c.ko()){
			System.out.println("c est perdu");
			System.out.println(c.toString());
			System.out.println("le chevalier est mort il ne fait plus partie de la table ronde");

		}
		else if (c.gagne()){
			System.out.println("c est gagner");
			System.out.println(c.toString());
			System.out.println("le chevalier a gagné ducoup il est parti de la table ronde");
		}
	}


	public static void main(String[] args) {
		boolean fini =false;
		Tableronde table = new Tableronde();
		Map Au4coinsdumonde = creation();
		while (!fini ){
			affiche();
			fini = menu(fini,Keyboard.getInt(),table,Au4coinsdumonde);

		}

	}
}


