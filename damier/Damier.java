import java.util.Vector;

public class Damier extends Object
{
	Vector<Point> pt = new Vector<Point>();
    Vector<Link> lien = new Vector<Link>();
	
	public Damier(String lolo,Vector<Point> pt1,Vector<Link> lien1)
	{
		Point a = new Point (lolo,0,0);
		
		
		
		// défini les deux vector qui forme le damier du réseau
	    pt = pt1;
	    lien = lien1;
	    
	    // défini le centre du damier sur le premier poste qui crée le réseau
		pt.addElement(a);		
		
	}
	
	void ajouter(String beuh)
	{
		
		
		
		// méthode d'ajout d'un point (placement + lien avec les autres points)
		
		int a;
		int b;
		
		int s = pt.size();
		
		
		int r1;
		int r2;
		
		
		
		if(s == 1) // si le damier ne contient qu'un seul point (le centre) alors on place manuellementle second point (0,1)
		{
			a = 0;
			b = 1;
			
			Point p = pt.elementAt(0);
						
			Point x  = new Point(beuh,a,b);
			
			pt.addElement(x);
			
			Link l = new Link(p,x);
			
			lien.addElement(l);
			
		}
		
		if(s > 1)// algorithme qui détermine la position du prochain point
		{
			
			Point ante = pt.lastElement();
			
			a=ante.x;
			b=ante.y;
			
			if(a>0 && b<=a && b>(-a)) 
			{
				r1 = a;
				r2 = b-1;
				
				Point x  = new Point(beuh,r1,r2);			
				pt.addElement(x);			
				ajoutlink(beuh,r1,r2);
			}
			
			if(a<0 && b>=a && b<=(-a))
			{
				r1 = a;
				r2 = b+1;
				
				Point x  = new Point(beuh,r1,r2);			
				pt.addElement(x);			
				ajoutlink(beuh,r1,r2);
			}
				
			if(b>0 && a<b && a>(-b))
			{
				r1 = a+1;
				r2 = b;
				
				Point x  = new Point(beuh,r1,r2);			
				pt.addElement(x);			
				ajoutlink(beuh,r1,r2);
			}
				
			if(b<0 && a>b && a<=(-b))
			{
				r1 = a-1;
				r2 = b;
				
				Point x  = new Point(beuh,r1,r2);			
				pt.addElement(x);			
				ajoutlink(beuh,r1,r2);
			}
			
						
		}
		
		
		
		
		
	}

	void ajoutlink(String beuh,int a,int b)
	{
		// Méthode auxiliaire permettant de définir les liens a établir
		
		Vector<Link> test = new Vector<Link>();
		
		int i;
		
		int sp = pt.size();
		
		
		
		Point x  = new Point(beuh,a,b);
			
		// Associe a x1,2,3,4,5,6,7,8 les points composants le carré autour du point ajouté
		
		for(i=0;i<sp;i++) 
		{
		
			Point testpoint = pt.elementAt(i); 
			
			if(testpoint.x==(a) && testpoint.y==(b+1))
			{
				Point x1 = null;
				
				x1 = pt.elementAt(i);
				
				if(x1 != null)
				{
					Link y = new Link(x,x1);
					test.addElement(y);
				}
				
		
			}
			
		}
		
		for(i=0;i<sp;i++)
		{
		
			Point testpoint = pt.elementAt(i); 
			
			if(testpoint.x==(a) && testpoint.y==(b-1))
			{
				Point x2 = null;
				x2 = pt.elementAt(i);
				
				if(x2 != null)
				{
					Link y = new Link(x,x2);
					test.addElement(y);
				}		
				
			}
			
		}
		
		for(i=0;i<sp;i++)
		{
		
			Point testpoint = pt.elementAt(i); 
			
			if(testpoint.x==(a-1) && testpoint.y==(b))
			{
				Point x3 = null;
				x3 = pt.elementAt(i);
				
				if(x3 != null)
				{
					Link y = new Link(x,x3);
					test.addElement(y);
				}
				
			}
			
		}
		
		for(i=0;i<sp;i++)
		{
		
			Point testpoint = pt.elementAt(i); 
			
			if(testpoint.x==(a+1) && testpoint.y==(b))
			{
				Point x4 = null;
				x4 = pt.elementAt(i);				
				
				if(x4 != null)
				{
					Link y = new Link(x,x4);
					test.addElement(y);
				}
				
				
			}
			
		}
		
		System.out.println(test.size());
		
		if(test.size() == 1) // Si i n'y a qu'un seul lien créé, on en rajoute un avec le point situé en diagonale (x5,6,7,8)
		{
			
			Link transfert = test.elementAt(0);
			lien.addElement(transfert);			
		
			for(i=0;i<sp;i++)
			{
			
				Point testpoint = pt.elementAt(i); 
				
				if(testpoint.x==(a+1) && testpoint.y==(b+1))
				{
					Point x5 = null;
					x5 = pt.elementAt(i);				

					if(x5 != null)
					{
						Link y = new Link(x,x5);
						lien.addElement(y);
					}
					
				}
				
			}
			
			for(i=0;i<sp;i++)
			{
			
				Point testpoint = pt.elementAt(i); 
				
				if(testpoint.x==(a+1) && testpoint.y==(b-1))
				{
					Point x6 = null;
					x6 = pt.elementAt(i);
					
					if(x6 != null)
					{
						Link y = new Link(x,x6);
						lien.addElement(y);
					}
				
				}
				
			}
			
			for(i=0;i<sp;i++)
			{
			
				Point testpoint = pt.elementAt(i); 
				
				if(testpoint.x==(a-1) && testpoint.y==(b+1))
				{
					Point x7 = null;
					x7 = pt.elementAt(i);				

					if(x7 != null)
					{
						Link y = new Link(x,x7);
						lien.addElement(y);
					}
					
				}
				
			}
			
			for(i=0;i<sp;i++)
			{
			
				Point testpoint = pt.elementAt(i); 
				
				if(testpoint.x==(a-1) && testpoint.y==(b-1))
				{
					Point x8 = null;
					x8 = pt.elementAt(i);				

					if(x8 != null)
					{
						Link y = new Link(x,x8);
						lien.addElement(y);
					}
				
					
				}
				
			}
		
			
		}
		
		if(test.size() > 1) // Si il y plus de deux lien créés, cela est suffisant
		{
			for(i=0;i<test.size();i++)
			{
				Link transfert = test.elementAt(i);
				
				lien.addElement(transfert);
								
			}					
			
		}
		
		
		for(i=0;i<sp;i++)
		{
		
			Point bip = pt.elementAt(i); 
			
			controle(bip);
			
		}
		
	}

	void controle(Point p)
	{
		
		int i;
		int sl = lien.size();
		int sp = pt.size();
		
		Link lit;
		Vector<Link> testl = new Vector<Link>();
		
		for(i=0;i<sl;i++)
		{
			
			lit = lien.elementAt(i);
			
			if(lit.px == p || lit.py == p)
			{
				testl.addElement(lit);
				
			}			
		}
		
		if(testl.size() > 4)
		{
			
			Point x1 = null;
			Point x2 = null;
			Point x3 = null;
			Point x4 = null;
			
			int a = p.x;
			int b = p.y;
			
			
			for(i=0;i<sp;i++) 
			{
			
				Point testpoint = pt.elementAt(i); 
				
				if(testpoint.x==(a) && testpoint.y==(b+1))
				{
					x1 = pt.elementAt(i);
				}
				
			}
			
			for(i=0;i<sp;i++)
			{
			
				Point testpoint = pt.elementAt(i); 
				
				if(testpoint.x==(a) && testpoint.y==(b-1))
				{
					x2 = pt.elementAt(i);
				}
				
			}
			
			for(i=0;i<sp;i++)
			{
			
				Point testpoint = pt.elementAt(i); 
				
				if(testpoint.x==(a-1) && testpoint.y==(b))
				{
					x3 = pt.elementAt(i);
				}
				
			}
			
			for(i=0;i<sp;i++)
			{
			
				Point testpoint = pt.elementAt(i); 
				
				if(testpoint.x==(a+1) && testpoint.y==(b))
				{
					x4 = pt.elementAt(i);
				}
							
				
			}
			
			
			for(i=0;i<testl.size();i++)
			{
				
				Point t1x = testl.elementAt(i).px;
				Point t1y = testl.elementAt(i).py;
				
				if(t1x == x1 || t1y == x1)
				{
				
					testl.removeElementAt(i);
					i-=1;
					
				}
				
				if(t1x == x2 || t1y == x2)
				{
				
					testl.removeElementAt(i);
					i-=1;
					
				}
				
				if(t1x == x3 || t1y == x3)
				{
				
					testl.removeElementAt(i);
					i-=1;
					
				}
				
				if(t1x == x4 || t1y == x4)
				{
				
					testl.removeElementAt(i);
					i-=1;
					
				}
				
								
			}
			
			for(i=0;i<testl.size();i++)
			{
			
			int ref = lien.indexOf(testl.elementAt(i));
			lien.removeElementAt(ref);
			
			}
			
		}
		
	}

	void delete(String sup)
	{
		
		int i;
		int sl = pt.size();
		int pos;
		
		Point p;
		Point ante = pt.lastElement();
		
		for(i=0;i<sl;i++)
		{
			
			if(pt.elementAt(i).h == sup)
			{
				
				p = pt.elementAt(i);
				
				pos = pt.indexOf(p);
				
				pt.setElementAt(ante, pos);
				
				pt.removeElementAt(sl - 1);
				
				
			}
			
		}
	
		
	}

	void afficher()
	{
		
		int i;
		int sp = pt.size();
	
		for(i=0;i<sp;i++)
		{
			
			Point test = pt.elementAt(i);
			
			test.affiche();
				
		}
		
	}

	void afficherlink()
	{
		
		int i;
		int sl = lien.size();
	
		for(i=0;i<sl;i++)
		{
			
			Link test = lien.elementAt(i);
			
			test.affiche();
				
		}
		
	}
	
	
}
