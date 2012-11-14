import java.util.Vector;

public class Test extends Object
{
	public static void main (String args[])
	{
	   
		Vector<Point> pt1 = new Vector<Point>();
		Vector<Link> lien1 = new Vector<Link>();
		
		Damier damiertest = new Damier("poste0",pt1,lien1);
			
		damiertest.ajouter("p1");
		damiertest.ajouter("p2");
		damiertest.ajouter("p3");
		damiertest.ajouter("p4");
		damiertest.ajouter("p5");

	    damiertest.afficherlink();		
	
				
		
	}

}
