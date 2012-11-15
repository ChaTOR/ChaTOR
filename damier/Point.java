
public class Point extends Object
{
	String h;
	int x;
	int y;
	
	public Point (String h1,int x1, int y1)
	{
		
		// un point est composé de son nom et de sa position en coordonnées cartésiennes
		h = h1;
		x = x1;
		y = y1;
	}
	
	void affiche()
	{
		System.out.println
		           (h+"("+x+","+y+")");
	}
	
	public String toString() {
		return "Name: "+h+", X: "+x+", Y: "+y;
	}
	
	public boolean equals(Point p2) {
		if (this.h.equals(p2.h) && this.x == p2.x && this.y == p2.y) {
			return true;
		}
		return false;
	}
	

}
