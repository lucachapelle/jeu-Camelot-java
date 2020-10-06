package JEU;

public class Coordonnees {
	private int x;
	private int y;

	public Coordonnees(int x, int y) {
		this.x = x;
		this.y = y;

	}		

	public void deplacer (){
		int coordx = (int) (Math.round(Math.random()*10) % 3);
		int coordy = (int) (Math.round(Math.random()*10) % 3);

		switch (coordx) {
		case 0:
			x = x-1;
			break;
		case 2:
			x = x+1;
			break;
		default:
			break;
		}
		switch (coordy) {
		case 0:
			y = y-1;
			break;
		case 2:
			y = y+1;
			break;
		default:
			break;
		}
		x = (x+10) % 10;
		y = (y+10) % 10;
	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "Les coordonnees sont : ( " + x + " , " + y + " )";
	}


}
