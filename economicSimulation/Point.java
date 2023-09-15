package economicSimulation;

/**
 * Date: Aug 2023
 * Group: Evan McNaughton, Nicholas Henson, Andrew Wang, and Jackson Amick
 * Description:
 * Point is a class with a price and a quantity.  
 * It's the basis for the entire project.
 */

public class Point 
{
	private double price; // y-axis of the point
	private int quantity; // x-axis of the point
	
	//each point has a default 1 penny tolerance for equality
	private final double TOLERANCE = 0.01;
	
	/**
	 * blank constructor that sets the price and quantity to 0.
	 * if you want an actual point specify the price and quantity.
	 */
	public Point()
	{
		price    = 0;
		quantity = 0;
	}
	
	/**
	 * proper constructor. 
	 * specifies p and q as parameters to set price and quantity.
	 */
	public Point(int q, double p)
	{
		price    = p;
		quantity = q;
	}

	/**
	 * this method returns the price.
	 */
	public double getPrice() 
	{
		return price;
	}

	/**
	 * set method for price that uses the parameter p.
	 */
	public void setPrice(double p) 
	{
		price = p;
	}

	/**
	 * this method returns the quantity.
	 */
	public int getQuantity() 
	{
		return quantity;
	}

	/**
	 * set method for quantity that uses the parameter q.
	 */
	public void setQuantity(int q) 
	{
		quantity = q;
	}
	
	
	public String toString()
	{
		return "("+quantity+" "+price+")";
	}
 	
	/**
	 * OverRIDES Object's equals(Object) method.
	 */
	public boolean equals(Object otherObj)
	{
//		System.out.println("overRIDE equals is being called.");
		if (otherObj instanceof Point)
		{
			return equals((Point) otherObj);
		}
		System.out.println("Object is not a Point!");
		return false;
	}
	
	/**
	 * OverLOADS Object's equals(Object) method.
	 */
	public boolean equals(Point otherPoint)
	{
//		System.out.println("overLOAD equals is being called");
		if ((this.quantity == otherPoint.quantity) && 
				Math.abs(this.price - otherPoint.price) < TOLERANCE)
		{
			return true;
		}
		return false;
	}
	
}
