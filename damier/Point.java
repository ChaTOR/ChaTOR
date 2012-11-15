
public class Point extends Object
{
	String h;
	int x;
	int y;
	
	public Point (String h1,int x1, int y1)
	{
		
		// un point est compos� de son nom et de sa position en coordonn�e cart�sienne
		h = h1;
		x = x1;
		y = y1;
	}
	
	void affiche()
	{
		System.out.println
		           (h+"("+x+","+y+")");
	}
	

}
