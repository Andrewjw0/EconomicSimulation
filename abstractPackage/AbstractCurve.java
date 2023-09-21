package abstractPackage;

import java.util.*;


public abstract class AbstractCurve implements CurveInterface
{ // needs to declare field variable of type ArrayList<Point>
	private ArrayList<Point> curveArrayList;

	/**
	 * Proper constructor, uses a starting point (sp)
	 * and an ending point (ep) to fill in the ArrayList
	 * Number of points is specified with numPoints
	 */
	public AbstractCurve(Point sp, Point ep, int numPoints)
	{
		curveArrayList = new ArrayList<Point>(numPoints + 1);
		curveArrayList.add(sp);
		
		int    deltaQ = (int) Math.round((ep.getQuantity() - sp.getQuantity()) / (numPoints * 1.0));
		double deltaP = (ep.getPrice() - sp.getPrice()) / (numPoints - 1);
		
		for (int i = 1; i < numPoints - 1; i++)
		{
			int    q = sp.getQuantity() + deltaQ * (i);
			double p = sp.getPrice() + deltaP * (i);
			curveArrayList.add(new Point(q, p));
		}
		
		curveArrayList.add(ep);
	}
	
	/**
	 * Returns curveArrayList because 
	 * we're not allowed to make it protected.
	 */
	public ArrayList<Point> getCurveArrayList()
	{
		return curveArrayList;
	}
	
	/**
	 * Adds Point p to the curve.
	 * Doesn't add p if:
	 * - p is on the curve
	 * - p has a quantity/price of 0 or less
	 * - p has an identical quantity to one of the points (SWAPS)
	 * If all these checks are cleared, adds p and sorts
	 */
	public void add(Point p)
	{
		// Checks if p is on the line, if so doesn't add
		if (search(p) == true)
		{
			System.out.println("Point is already on the curve!");
			return;
		}
				
		// Checks if p has a quantity below or equal to 0, if so doesn't add
		if (p.getQuantity() <= 0)
		{
			System.out.println("Quantity can't be 0 or less!");
			return;
		}
				
		// Checks if p has a price below or equal to 0, if so doesn't add
		if (p.getPrice() <= 0)
		{
			System.out.println("Price can't be less than or equal to 0!");
			return;
		}
				
		// Checks if p has a matching quantity on the line, if so swaps instead
		int index = searchQuantity(p);
				
		if (index <= 0) 
		{
			curveArrayList.set(index, p);
			return;
		}
				
		curveArrayList.add(p);
				
		sort(); // Sorts to keep points in order
	}
	
	/**
	 * Deletes a Point.
	 * Prints out a message if the point is off the line.
	 */
	public void delete(Point p)
	{
		if (search(p))
		{
			curveArrayList.remove(searchForIndex(p));
			return;
		}
		System.out.println("Point not found on the line!");
	}
	
	/**
	 * Prints out each Point on the curve.
	 */
	public String toString()
	{
		String temp = "Curve: ";
		
		for (Point p : curveArrayList)
		{
			temp = temp + p.toString() + ", ";
		} 
			
		return temp;
	}
	
	// SEARCH METHODS-----------------------------------------------------
	
	/**
	 * Searches for an identical Point on the curve.
	 * If there is one, returns true
	 */
	public boolean search(Point p)
	{
		for (Point pt : curveArrayList)
		{
			if (pt.equals(p))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Searches for Point p on the curveArrayList.
	 * If there, returns the index.  
	 * Otherwise returns -1 (impossible index)
	 */
	private int searchForIndex(Point p)
	{
		for (int i = 0; i < curveArrayList.size(); i++)
		{
			if (curveArrayList.get(i).equals(p))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Searches for quantity of Point p on the curveArrayList.
	 * If there, returns the index.  
	 * Otherwise returns -1 (impossible index)
	 */
	private int searchQuantity(Point p)
	{
		ArrayList<Point> tc = curveArrayList;
		
		for (int i = 0; i < tc.size(); i++)
		{
			Point temp = tc.get(i);
			
			if (p.getQuantity() == temp.getQuantity())
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Searches for price of Point p on the curveArrayList.
	 * If there, returns the index.  
	 * Otherwise returns -1 (impossible index)
	 */
	private int searchPrice(Point p)
	{
		ArrayList<Point> tc = curveArrayList;
		
		for (int i = 0; i < tc.size(); i++)
		{
			Point temp = tc.get(i);
			
			if (p.getPrice() == temp.getPrice())
			{
				return i;
			}
		}
		
		return -1;
	}
	// END OF SEARCH METHODS----------------------------------------------
	
	/**
	 * Sort method is abstract because
	 * ProducerCurve and ConsumerCurve will
	 * sort differently.
	 */
	public abstract void sort();
	
	public void swap(int i1, int i2)
	{
		ArrayList tc = curveArrayList;
		
		Object temp = tc.set(i1, tc.get(i2));
		tc.set(i2, temp);
	}
}
