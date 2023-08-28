/*
 * @author AJWang
 * @date 21Aug2023
 * Purpose: 
 */
public class Point {

	private int quantity;
	private double price;
	
	public Point() 
	{
		quantity = 0;
		price = 0.0;
	}
	
	public Point(int q, double p)
	{
		quantity = q;
		price = p;
	}
	
	public double getQuantity()
	{
		return quantity;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setQuantity(int q)
	{
		quantity = q;
	}
	
	public void setPrice(double p)
	{
		price = p;
	}
	
	public String toString()
	{
		return "(" + quantity + ", " + price + ")";
	}
	
	public boolean equals(Object otherObject)
	{
		if (otherObject instanceof Point)
		{
			return equals((Point) otherObject);
		}
		
		return false;
	}
	
	public boolean equals(Point otherpoint)
	{
		if (quantity == otherpoint.getQuantity() && price == otherpoint.getPrice())
		{
			return true;
		}
		
		return false;
	}
}
