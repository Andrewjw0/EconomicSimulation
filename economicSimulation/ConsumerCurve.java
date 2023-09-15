package economicSimulation;

import java.util.*;

/**
 * Date: Sep 2023
 * Group: Evan McNaughton, Nicholas Henson, Andrew Wang, and Jackson Amick
 * Description:
 * Consumer curve is one of two curve methods that uses an ArrayList of Points.
 * Price INCREASES over the curve.
 */
public class ConsumerCurve 
{	
	private ArrayList<Point> cCurveArrayList;
	
	/**
	 * Default constructor
	 */
	public ConsumerCurve()
	{
		cCurveArrayList = new ArrayList<Point>();
		
		for (int i = 0; i < 10; i++)
		{
			int q = i + 1;
			double p = 10 - i;
			cCurveArrayList.add(new Point(q, p));
		}
	}
	
	/**
	 * Proper constructor, uses a starting point (sp)
	 * and an ending point (ep) to fill in the ArrayList
	 * Number of points is specified with numPoints
	 */
	public ConsumerCurve(Point sp, Point ep, int numPoints)
	{
		cCurveArrayList = new ArrayList<Point>(numPoints + 1);
		cCurveArrayList.add(sp);
		
		int    deltaQ = (int) Math.round((ep.getQuantity() - sp.getQuantity()) / (numPoints * 1.0));
		double deltaP = (ep.getPrice() - sp.getPrice()) / (numPoints - 1);
		
		for (int i = 1; i < numPoints - 1; i++)
		{
			int    q = sp.getQuantity() + deltaQ * (i);
			double p = sp.getPrice() + deltaP * (i);
			cCurveArrayList.add(new Point(q, p));
		}
		
		cCurveArrayList.add(ep);
	}
	
	public String toString()
	{
		String temp = "ConsumerCurve: ";
		
		for (Point p : cCurveArrayList)
		{
			temp = temp + p.toString() + ", ";
		} 
		
		return temp;
	}
	
	/**
	 * goes through cCurveArrayList searching Point op,
	 * returns true if it's found
	 */
	public boolean search(Point op)
	{
		for (Point p : cCurveArrayList)
		{
			if (p.equals(op))
			{
				return true;
			}
		}
		
		return false;
	}

	/**
	 * searches for point op, returns the index where it's found
	 * returns -1 (impossible index) if not
	 */
	private int searchForIndex(Point op)
	{
		for (int i = 0; i < cCurveArrayList.size(); i++)
		{
			if (cCurveArrayList.get(i).equals(op))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Less specific search() method that
	 * solely looks for a matching quantity
	 * returns the index if found, -1 if not
	 */
	private int searchMatchingQuantity(Point op)
	{
		ArrayList<Point> tc = cCurveArrayList;
		
		for (int i = 0; i < tc.size(); i++)
		{
			Point temp = tc.get(i);
			
			if (op.getQuantity() == temp.getQuantity())
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Sorts cCurveArrayList by quantity
	 */
	private void sortByQuantity()
	{
		ArrayList<Point> tc = cCurveArrayList;
		
		for (int a = 0; a < tc.size(); a++)
		{
			for (int i = 0; i < tc.size() - 1; i++)
			{
				int   rhi = i + 1;
				Point leftP = tc.get(i);
				Point rightP = tc.get(rhi);
				
				if (leftP.getQuantity() > rightP.getQuantity())
				{
					swap(i, rhi);
				}
			}
		}
	}

	/**
	 * Adds Point p to cCurveArrayList.
	 * Does not add if:
	 * - Point is on the line
	 * - Point has a quantity of 0 or less
	 * - Point has a price of 0 or less
	 * If p is not on the line but has a matching quantity
	 * the matching point is swapped, otherwise adds p
	 * to the line
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
		int index = searchMatchingQuantity(p);
		
		if (index >= 0) 
		{
			cCurveArrayList.set(index, p);
			return;
		}
		
		cCurveArrayList.add(p);
		
		sortByQuantity(); // Sorts to keep points in order
	}
	
	/**
	 * Deletes p if it's on the line.
	 */
	public void delete(Point p)
	{
		if (search(p))
		{
			cCurveArrayList.remove(searchForIndex(p));
		}
	}
	
	/**
	 * swaps i1 and i2's positions, helper method
	 */
	private void swap(int i1, int i2)
	{
		ArrayList tc = cCurveArrayList;
		
		Object temp = tc.set(i1, tc.get(i2));
		tc.set(i2, temp);
	}
}