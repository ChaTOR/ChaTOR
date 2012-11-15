
public class Link extends Object
{

	Point px;
	Point py;
	
	public Link (Point p1, Point p2)
	{
		
		
		// un lien est compos� de deux point
		px = p1;
		py = p2;
	 	
	}

	void affiche()
	{		    
		System.out.println(px.h+"=>"+py.h);					
			
	}

	
	
	
}
